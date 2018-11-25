package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.
 */
public class SingletonEagerRelyOnJvm {
    private static SingletonEagerRelyOnJvm singletonEagerRelyOnJvm = new SingletonEagerRelyOnJvm();
    private SingletonEagerRelyOnJvm(){

    }
    SingletonEagerRelyOnJvm getSingletonEagerRelyOnJvm(){
        return singletonEagerRelyOnJvm;
    }
}
