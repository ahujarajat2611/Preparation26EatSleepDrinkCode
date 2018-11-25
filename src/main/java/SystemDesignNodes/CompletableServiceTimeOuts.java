package SystemDesignNodes;

/**
 * Created by hadoop on 25/2/18.
 */
/*
http://iteratrlearning.com/java9/2016/09/13/java9-timeouts-completablefutures.html
 */
public class CompletableServiceTimeOuts {
}
/*


Asynchronous timeouts with CompletableFutures in Java 8 and Java 9
Written on September 13, 2016

Java 8 introduced CompletableFuture<T> as an enhancement to Future<T>. It is a new class which lets you express the flow of information from different tasks using a callback driven style. A CompletableFuture is used for defining computations on singular events, which is a different use case than computations on streams of events (e.g. Observable using RxJava). In this article, you will learn about the problem with timeouts in Java 8’s CompletableFuture and the improvements that Java 9 brings.

Combining two services
For the purpose of this article, let’s say you’d like to combine the result of two services over the network:

A best price finder for a flight route
An exchange service that converts USD to GBP
Both of these services will introduce a certain delay before responding back with a result. This is due to the costs of network communication with the service.

You could solve this problem by making use of CompletableFuture as follows (by default a CompletableFuture uses the common thread pool but this can be parametrised with an Executor using an overload of supplyAsync):

BigDecimal amount =
    CompletableFuture.supplyAsync(() -> findBestPrice("LDN - NYC"))
                     .thenCombine(CompletableFuture.supplyAsync(() -> queryExchangeRateFor("GBP")),
                                                 this::convert)
                     .get();
In the code above, the method convert takes the two BigDecimal results from findBestPrice and queryExchangeRateFor and calculates the final amount. You can refer to the javadoc for a more detailed description of the methods available using CompletableFuture.

Timeout mechanism
However, there are a few problems associated with this code. First, get() is a blocking call. This means that the main thread will have to wait until the result is ready before it can progress. Ideally, you’d like the main thread to do other useful work while the result is calculated in the background. Second, the main thread could be blocking indefinitely because there isn’t a timeout specified. What if one of the service is overloaded and doesn’t respond? To add a timeout mechanism, you can use the other version of get inherited from Future which throws a TimeoutException when the overall pipeline takes longer than a certain amount of time to return the result:

BigDecimal result =
    CompletableFuture.supplyAsync(() -> findBestPrice("LDN - NYC"), executorService)
                     .thenCombine(CompletableFuture.supplyAsync(() -> queryExchangeRateFor("GBP")),
                                                 this::convert)
                     .get(1, TimeUnit.SECONDS);
Unfortunately this code is still blocking and prevents the main thread from doing useful work in the meantime! To tackle this issue, you can refactor the above code to use thenAccept and provide a callback which is executed when the result is finally available:

CompletableFuture.supplyAsync(() -> findBestPrice("LDN - NYC"), executorService)
                         .thenCombine(CompletableFuture.supplyAsync(() -> queryExchangeRateFor("GBP")),
                                                 this::convert)
                         .thenAccept(amount -> System.out.println("The price is: " + amount + "GBP"));
However, using this approach we lost the timeout functionality! Ideally we’d like to specify a timeout using a non-blocking method. Unfortunately there isn’t a built-in elegant support to solve this problem in Java 8. Solutions available include using acceptEither() or applyToEither together with the CompletableFuture you are waiting the result for and another CompletableFuture which wraps up a ScheduledThreadpoolExecutor that throws a TimeoutException after a certain time:

CompletableFuture.supplyAsync(() -> findBestPrice("LDN - NYC"), executorService)
                         .thenCombine(CompletableFuture.supplyAsync(() -> queryExchangeRateFor("GBP")),
                                                 this::convert)
                         .acceptEither(timeoutAfter(1, TimeUnit.SECONDS),
                                       amount -> System.out.println("The price is: " + amount + "GBP"));
A simple implementation of timeoutAfter is as follows where delayer is an instance of a ScheduledThreadPoolExecutor:

public <T> CompletableFuture<T> timeoutAfter(long timeout, TimeUnit unit) {
    CompletableFuture<T> result = new CompletableFuture<T>();
    delayer.schedule(() -> result.completeExceptionally(new TimeoutException()), timeout, unit);
    return result;
}
Java 9 improvements
Java 9’s CompletableFuture introduces several new methods amongst which are orTimeout and completeOnTimeOut that provide built-in support for dealing with timeouts.

The method orTimeout has the following signature:

public CompletableFuture<T> orTimeout(long timeout, TimeUnit unit)
It internally uses a ScheduledThreadExecutor and completes the CompletableFuture with a TimeoutException after the specified timeout has elapsed. It also returns another CompletableFuture, meaning you can further chain your computation pipeline and deal with the TimeoutException by providing a friendly message back. Note that whenComplete in the code below could report other exceptional completions that might occur before the timeout occurs.

For example:

CompletableFuture.supplyAsync(() -> findBestPrice("LDN - NYC"), executorService)
                         .thenCombine(CompletableFuture.supplyAsync(() -> queryExchangeRateFor("GBP")),
                                                 this::convert)
                         .orTimeout(1, TimeUnit.SECONDS)
                         .whenComplete((amount, error) -> {
                                        if (error == null) {
                                            System.out.println("The price is: " + amount + "GBP");
                                        } else {
                                            System.out.println("Sorry, we could not return you a result");
                                        }
                         });
The method completeOnTimeout has the following signature:

public CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit)
It also uses a ScheduledThreadExecutor internally but in contrast to orTimeout, it provides a default value in the case that the CompletableFuture pipeline times out. You can conceptually relate this method to orElse() using java.util.Optional.

CompletableFuture.supplyAsync(() -> findBestPrice("LDN - NYC"), executorService)
                         .thenCombine(CompletableFuture.supplyAsync(() -> queryExchangeRateFor("GBP")),
                                                 this::convert)
                         .completeOnTimeout(DEFAULT_PRICE, 1, TimeUnit.SECONDS)
                         .thenAccept(amount -> {
                             System.out.println("The price is: " + amount + "GBP");
                         });
 */
