package CompletableFuture;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureCombine {

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

    public static CompletableFuture<String> getLastName() {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                sleep(5000);
                return "Kumar";
            }
        }).exceptionally(e -> {
            System.out.println("Exception occurred");
            return "Exception!!";
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> response = getFirstName().thenCombine(getLastName(), (a, b) -> {
            return a + b;
        });
        System.out.println(response.get());
        System.out.println("Program Completed");
    }
}
