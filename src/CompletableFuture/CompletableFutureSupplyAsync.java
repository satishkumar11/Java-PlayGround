package CompletableFuture;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureSupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "task is completed";
            }
        }, executor).thenApply(result -> {
            return "Hello Admin, " + result;
        });

        System.out.println(completableFuture.get());
        System.out.println("Program Completed");
    }
}
