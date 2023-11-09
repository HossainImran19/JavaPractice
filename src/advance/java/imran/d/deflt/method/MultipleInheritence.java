package advance.java.imran.d.deflt.method;


interface Conversable {
    default void hi() {
        System.out.println("hi from Conversable");
    }
}

interface ConversablePlus {
    default void hi() {
        System.out.println("hi from ConversablePlus");
    }
}

interface A {
    default void sayHi() {
        System.out.println("From interface A");
        sayNotHi();
    }

    // Here we will use private method to reduce duplicate code
    // When a default method becomes too large,
    // private methods are used to break it down into smaller private methods.
    private void sayNotHi() {
        System.out.println("private form A");
    }
}

interface B extends A {
    default void sayHi() {
        System.out.println("From interface B");
    }
}

// Rule: #1
// Here class C is implementing to A.
// And both C and A have same signature methods
// But in this case class C's obj will call it own method sayHi()
class C implements A {
    public void sayHi() {
        System.out.println("From class C");
    }
}

// Rule: #2
// Here sub-interface B will get more priority..
// So object of class D will call the default method of interface B
// which is sub-interface of A.
class D implements A, B {

}

interface E {
    default void sayHell() {
        System.out.println("Hello from E");
    }
}

interface F {
    default void sayHell() {
        System.out.println("Hello from F");
    }
}

// Rule: #3
// Here sayHello() method creates ambiguity
// So to remove the ambiguity we need to Override
// to implement which method will be called by the obj of G.
class G implements E, F {
    @Override
    public void sayHell() {
        E.super.sayHell();
    }
}

// This code will not work or compiler will not compile.
// Because MultipleInheritence implements two interfaces
// which have same signature methods that is hi().
//public class MultipleInheritence implements Conversable, ConversablePlus, A{
//
//    public static void main(String[] args) {
//        G obj = new G();
//        obj.sayHell();
//    }
//}
