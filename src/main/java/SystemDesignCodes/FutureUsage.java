package SystemDesignCodes;

/**
 * Created by hadoop on 8/10/17.
 */
public class FutureUsage {
}
/*
final Future<String> contentsFuture = startDownloading(new URL("http://www.example.com"));
while (!contentsFuture.isDone()) {
    askUserToWait();
    doSomeComputationInTheMeantime();
}
contentsFuture.get();

we can use This as reference for future object
//https://dzone.com/articles/javautilconcurrentfuture


 */