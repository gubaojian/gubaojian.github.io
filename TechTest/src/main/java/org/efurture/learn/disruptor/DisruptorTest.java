package org.efurture.learn.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.junit.Test;

import java.nio.ByteBuffer;

public class DisruptorTest {

    @Test
    public void testDisruptorTest() throws InterruptedException {
        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handler
        disruptor.handleEventsWith(new LongEventHandler());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        long start = System.currentTimeMillis();
        for (long l = 0; l < 30000; l++) {
            ByteBuffer bb = ByteBuffer.allocate(8);
            bb.putLong(0, l);
            producer.onData(bb);
        }
        System.out.println(Thread.currentThread() + " producer used " + (System.currentTimeMillis() - start));
    }


    public class LongEvent {
        private long value;

        public void set(long value)
        {
            this.value = value;
        }
    }


    public class LongEventFactory implements EventFactory<LongEvent> {
        public LongEvent newInstance() {
            return new LongEvent();
        }
    }


    public class LongEventHandler implements EventHandler<LongEvent> {
        public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
            System.out.println("onEvent " + Thread.currentThread());
        }
    }


    public class LongEventProducerWithTranslator
    {
        private final RingBuffer<LongEvent> ringBuffer;

        public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer)
        {
            this.ringBuffer = ringBuffer;
        }

        private final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
                new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
                    public void translateTo(LongEvent event, long sequence, ByteBuffer bb) {
                        System.out.println("translateTo " + Thread.currentThread());
                        event.set(bb.getLong(0));
                    }
                };

        public void onData(ByteBuffer bb) {
            System.out.println("onData " + Thread.currentThread());
            ringBuffer.publishEvent(TRANSLATOR, bb);
        }
    }

    public class LongEventProducer
    {
        private final RingBuffer<LongEvent> ringBuffer;

        public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        public void onData(ByteBuffer bb)
        {
            System.out.println("LongEventProducer onData " + Thread.currentThread());
            long sequence = ringBuffer.next();  // Grab the next sequence
            try {
                LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
                // for the sequence
                event.set(bb.getLong(0));  // Fill with data
            }
            finally {
                ringBuffer.publish(sequence);
            }
        }
    }
}
