package surya;

public class ThreadsLearning{

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            for ( int i = 1; i <= 5; i++ ){

                System.out.println("Hi");
    
                try {
                    
                    Thread.sleep(500);
    
                } catch (InterruptedException e) {
    
                    System.err.println(e.getMessage());
    
                }
    
            }

        }, "Hi Thread");

        thread1.start();

        Thread thread2 = new Thread(() -> {

            for ( int i = 1; i <= 5; i++ ){

                System.out.println("Hello");
    
                try {
                    
                    Thread.sleep(500);
    
                } catch (InterruptedException e) {
    
                    System.err.println(e.getMessage());
    
                }
    
            }

        }, "Hello Thread");

        thread2.start();

        try {

            thread1.join();

            thread2.join();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println("Bye");

    }

}