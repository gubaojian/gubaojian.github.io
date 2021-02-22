#include <iostream>
#include <mutex>
#include <vector>
#include <deque>
#include <thread>


std::mutex g_mutex;
std::condition_variable g_cv;
std::deque<int> g_data_deque;

const int MAX_NUM = 30;
int g_next_index = 0;

const int PRODUCER_THREAD_NUM = 3;
const int CONSUMER_THREAD_NUM = 3;

void producer_thread(int thread_id){
    while(true){
        std::this_thread::sleep_for(std::chrono::microseconds(500));
        std::unique_lock<std::mutex> lk(g_mutex);
        g_cv.wait(lk, [](){
            return g_data_deque.size() <= MAX_NUM;
        });
        g_next_index++;
        g_data_deque.push_back(g_next_index);
        std::cout << "producer_thread: " << thread_id << " producer data: " << g_next_index;
        std::cout << " queue size: " << g_data_deque.size() << std::endl;
        g_cv.notify_all();
    }
}


void consumer_thread(int thread_id){
    while (true){
        std::this_thread::sleep_for(std::chrono::microseconds(500));
        std::unique_lock<std::mutex> lk(g_mutex);
        g_cv.wait(lk, [](){
            return !g_data_deque.empty();
        });
        int data = g_data_deque.front();
        g_data_deque.pop_front();
        std::cout << "\t consumer thread: " << thread_id << " consumer data: ";
        std::cout << data << " deque size: " << g_data_deque.size() << std::endl;

        g_cv.notify_all();
    }
    
}

int main(){

    std::thread producerThreads[PRODUCER_THREAD_NUM];
    std::thread consumerThreads[CONSUMER_THREAD_NUM];

   

    for(int i=0; i< CONSUMER_THREAD_NUM; i++){
        consumerThreads[i] = std::thread(consumer_thread, i);
    }

     for(int i=0; i< PRODUCER_THREAD_NUM; i++){
        producerThreads[i] = std::thread(producer_thread, i);
    }

    for(int i=0; i<PRODUCER_THREAD_NUM; i++){
        producerThreads[i].join();
    }

    for(int i=0; i<CONSUMER_THREAD_NUM; i++){
        consumerThreads[i].join();
    }
    
}