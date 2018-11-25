package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.
 */
public class SingletonLazyApproach {
    private static SingletonLazyApproach singletonLazyApproach ;
    private static Object lock = new Object();

    private SingletonLazyApproach(){
    }
    public static SingletonLazyApproach getSingletonLazyApproach(){

        if(singletonLazyApproach == null){
            synchronized (lock){
                if(singletonLazyApproach == null){
                    singletonLazyApproach = new SingletonLazyApproach();
                }
            }
        }
        return singletonLazyApproach;
    }

}
