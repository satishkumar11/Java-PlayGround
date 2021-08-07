package CompletableFuture;

public class ThreadCreationRunnable {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.start();
        System.out.println(Thread.currentThread().getName());


        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread2.start();
    }
}
