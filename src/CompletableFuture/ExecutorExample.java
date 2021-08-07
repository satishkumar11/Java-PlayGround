package CompletableFuture;

import java.util.Date;
import java.util.concurrent.*;

public class ExecutorExample {

    private static int count = 1;

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " executing task1");
            }
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " executing task2");
        });

//        scheduleExecutor();
    }

    public static void scheduleExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task" + count++ + " Running at Time : " + new Date());
            }
        }, 0, 3, TimeUnit.SECONDS);
    }
}
