package SystemDesignNotes1;

/**
 * Created by hadoop on 8/3/18.
 */
public class FinalKeywords {
}

class finalTest{

    final Object object;
    finalTest(){
        // we can changes final's value in the constructor not in the methods (cOMPILE TIME)
        // allowed in constructore
        object = new Object();
    }
    void Test(){
        // but not allwoed in the function the final variables
        //object = new Object();
    }

}
/*
This is a very good interview question.
Sometimes they might even ask you what is the difference between
 a final object and immutable object.


1) When someone mentions a final object, it means that the reference cannot be changed, but its state(instance variables) can be changed.

2) An immutable object is one whose state can not be changed, but its reference can be changed. Ex:


    String x = new String("abc");
    x = "BCG";

ref variable x can be changed to point a different string, but value of "abc" cannot be changed.

3)Instance variables(non static fields) are initialized when a
 constructor is called.
So you can initialize values to you variables inside a constructor.

4) 4) "But i see that you can change the value in the constructor/methods of the class". --
 You cannot change it inside a method.

A static variable is initialized during class loading.
 So you cannot initialize inside a constructor,
 it has to be done even before it.
  So you need to assign values to a static variable
  during declaration itself.


 */

/*
Very imp




When you make it static final it should be initialized
 in a static initialization block

    private static final List foo;

    static {
        foo = new ArrayList();
    }

    public Test()
    {
//      foo = new ArrayList();
        foo.add("foo"); // Modification-1
    }





The final keyword can be interpreted in two different ways
depending on what it's used on:

Value types: For ints, doubles etc,
it will ensure that the value cannot change,

Reference types: For references to objects,
final ensures that the reference will never
 change, meaning that it will always refer to the same object.
 It makes no guarantees whatsoever about the values inside the object being referred to staying the same.

As such, final List<Whatever> foo; ensures that foo
always refers to the same list, but the contents of said list may change over time.


 */