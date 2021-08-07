package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureCompose {

    public static CompletableFuture<String> getDetail1() {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello ";
            }
        });
    }

    public static CompletableFuture<String> getDetail2(String name) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return name + "Satish";
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> response = getDetail1().thenCompose(result -> getDetail2(result));
        System.out.println(response.get());
    }
}
