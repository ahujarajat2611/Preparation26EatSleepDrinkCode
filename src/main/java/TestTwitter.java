/**
 * Created by hadoop on 31/1/18.
 */
public class TestTwitter {
    public static void main(String[] args) throws Exception {
        System.out.println(" Lets Do it ");
        TestTwitter testTwitter = new TestTwitter();
        testTwitter.function(3);
    }

    void function(int x) throws Exception{
        if(x <1){
            System.out.println("Enter exception");
            throw new Exception("ille");
        }
        System.out.println("Enter function");
    }
}

