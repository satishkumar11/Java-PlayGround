package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureCompose {


    public static void sleep(int val) {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getFirstName() {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                sleep(3000);
                return "Satish";
            }
        });
    }

    public static CompletableFuture<String> getLastName(String name) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                sleep(5000);
                return name + "Kumar";
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /* thenCompose */
        CompletableFuture<String> response = getFirstName().thenComposeAsync(result ->
                getLastName(result)
        );
        System.out.println(response.get());

        /* thenApply */
        CompletableFuture<CompletableFuture<String>> response1 = getFirstName().thenApplyAsync(result ->
                getLastName(result)
        );
        System.out.println(response1.get().get());
        System.out.println("Program Completed");
    }
}
