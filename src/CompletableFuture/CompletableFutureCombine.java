package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureCombine {

    public static CompletableFuture<String> getDetail1() {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello ";
            }
        });
    }

    public static CompletableFuture<String> getDetail2() {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Satish";
            }
        }).exceptionally(e -> {
            System.out.println("Exception occurred");
            return "Exception";
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> response = getDetail1().thenCombine(getDetail2(), (a, b) -> {
            return a + b;
        });
        System.out.println(response.get());
    }
}
