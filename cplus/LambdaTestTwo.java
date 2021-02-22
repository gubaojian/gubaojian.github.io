public class LambdaTestTwo{

    final static String salutation = "Hello! ";

    public static void main(String args[]){

        int num = 5;

        GreetingService greetingService = message -> { System.out.println(salutation + message
          + num);
        };

        greetingService.sayMessage("Runoob");

    }

    interface GreetingService{
        void sayMessage(String message);
    }

}