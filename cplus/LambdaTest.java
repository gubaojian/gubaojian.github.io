public class LambdaTest{

    public static void main(String[] args){

        LambdaTest test = new LambdaTest();

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (int a, int b) -> {return a * b;};
        MathOperation division = (int a, int b) -> a/b;

        System.out.println("10 - 5 = " +  subtraction.operation(10, 5));

        System.out.println("10 + 5 = " + test.operate(10,5, addition));
        System.out.println("10 - 5 = " + test.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + test.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + test.operate(10, 5, division));

        GreetingService greetingService = message -> System.out.println(message);
        GreetingService greetingServiceTwo = message -> System.out.println("Hello " + message);

        greetingService.sayMessage("World");
        greetingServiceTwo.sayMessage("World Google");



    }


    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    
}

