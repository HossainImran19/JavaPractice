package advance.java.imran.e.optional;

import java.util.Optional;

public class OptionalMethods {
    public static void main(String[] args) {
        // =======================================
        // method #1 of()
        // Optional.of()
        // Note that the argument of of() method must be non-null
        Optional<Man> man = Optional.of(new Man());

        // =======================================
        // method #2 ofNullable()
        // If we are not sure whether the reference is null or not
        // then we can use ofNullable() method instead of of()
        Optional<Man> man1 = Optional.ofNullable(Man.findMan());

        // =======================================
        // method #3 empty()
        // By declaring a variable it is better to declare Optional.empty() as given below
        // without assigning null to it
        Optional<String> myName = Optional.empty(); // It is better
        String youName = null; // It is not better

        // =======================================
        // method #4 get() #5 isPresent()
        // It returns the value of object which wrapped inside the Optional.
        Optional<String> myStr
                = Optional.ofNullable(getNullableString());
        if (myStr.isPresent()) {
            doSomething(myStr.get());
        }

        // =======================================
        // method #6 ifPresent()
        // We can write in this way using the override method ifPresent() of isPresent()
        myStr.ifPresent(string -> doSomething(string));

        // =======================================
        // method #7 ifPresentOrElse()
        // Some time we need to take decisions based on return value of the Optional.
        Optional<Book> book
                = Book.findBookByName("Java Programming Book");
        if (book.isPresent()) {
            Book book1 = book.get();
            book1.buyIt(book);
        } else {
            Book.writeMessageToPublisher();
        }
        // Using ifPresentOrElse() we can write that if else condition.
        Book.findBookByName("Advanced Java Programming")
                .ifPresentOrElse(
                        book1 -> book1.buyIt(Optional.of(book1)),
                        Book::writeMessageToPublisher
                );
    }

    public static String getNullableString() {
        return null;
    }
    public static void doSomething(String string) {
        // Something
    }
}

class Book {
    public static Optional<Book> findBookByName(String name) {
        return Optional.empty();
    }

    public void buyIt(Optional<Book> book) {
        System.out.println("Book is bought");
    }

    public static void writeMessageToPublisher() {
        System.out.println("Book is not found");
    }
}
class Man {
    public static Man findMan() {
        return null;
    }
}