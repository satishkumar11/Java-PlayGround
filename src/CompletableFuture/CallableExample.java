package CompletableFuture;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " executing task1");
                Thread.sleep(5000);
                return "some response";
            }
        });
        System.out.println(future.get());
        System.out.println("response returned");
        executorService.shutdownNow();
    }
}
