package advance.java.imran.e.optional;

import java.util.Optional;

public class OptionalMethods {
    private static BookRepo bookRepo;
    public static void main(String[] args)
            throws Exception {
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
            book1.buyIt();
        } else {
            Book.writeMessageToPublisher();
        }
        // Using ifPresentOrElse() we can write that if else condition.
        Book.findBookByName("Advanced Java Programming")
                .ifPresentOrElse(
                        book1 -> book1.buyIt(),
                        Book::writeMessageToPublisher
                );

        // =======================================
        // method #8 or()
        // If a book name is not found,
        // the or() method is used to check
        // if there is another book with different name.
        Optional<Book> optionalBook
                = Book.findBookByName("java programming")
                .or(() -> Book.findBookByName("java thread programming"));

        // =======================================
        // method #9 orElse()
        // If Optional may not contain value inside,
        // then we can set a default value using orElse() method.
        String myString = Optional.ofNullable(getNullableString()).orElse("Imran");

        // =======================================
        // method #10 orElseGet()
        // Whether return value of getNullableString() null or not,
        // calculateHaveyMethod() will be executed.
        // If we want to execute while the return value of getNullableString() is null,
        // then we need to use orElseGet() method.
        String string = Optional.ofNullable(getNullableString()).orElse(calculateHaveyMethod());
        String string1 = Optional.ofNullable(getNullableString()).orElseGet(OptionalMethods::calculateHaveyMethod);


        // =======================================
        // method #11 orElseThrow()
        Book book1 = bookRepo.findOne(1L).orElseThrow(BookNotFoundException::new);

        // =======================================
        // method #12 Optional<U> map(Function<? super T, ? extends U> mapper)
        // It's helps to convert one data type to another data type.
        Optional<Book> optionalBook1 = bookRepo.findById(1L);
        Optional<String> optionalString = optionalBook1.map(Book::buyIt);

        // =======================================
        // method #13 <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)

        Optional<Man> optionalMan = findByManById(1L);
        Optional<Optional<SmartPhone>> optionalSmartPhone
                = optionalMan.map(Man::getSmartPhone);

        // Now we want to separate smartPhone from that Optional...
        if (optionalSmartPhone.isPresent()) {
            Optional<SmartPhone> smartPhoneOptional
                    = optionalSmartPhone.get();
            if (smartPhoneOptional.isPresent()) {
                SmartPhone smartPhone = smartPhoneOptional.get();
                Optional<EWallet> optionalEWallet
                        = smartPhone.geteWallet();
            }
        }

        // Instead of this ugly code we can overwrite using flagMap() method
        Optional<Man> man2 = findByManById(1L);
        Optional<SmartPhone> optional
                = man2.flatMap(man4 -> man4.getSmartPhone());
    }

    public Optional<String> getEWalletAccountNumber(Man man) {
        return Optional.ofNullable(man)
                .flatMap(Man::getSmartPhone)
                .flatMap(SmartPhone::geteWallet)
                .flatMap(EWallet::getAccountNumber);
    }

    private static String calculateHaveyMethod() {
        return "Havey";
    }

    public static String getNullableString() {
        return null;
    }
    public static void doSomething(String string) {
        // Something
    }

    public static Optional<Man> findByManById(Long id) {
        return Optional.empty();
    }
}

interface BookRepo {
    Optional<Book> findOne(Long id);

    public Optional<Book> findById(Long id);
}

class Book {
    public static Optional<Book> findBookByName(String name) {
        return Optional.empty();
    }

    public String buyIt() {
        System.out.println("Book is bought");
        return "null";
    }

    public static void writeMessageToPublisher() {
        System.out.println("Book is not found");
    }
}
class Man {
    SmartPhone smartPhone;

    public Optional<SmartPhone> getSmartPhone() {
        return Optional.empty();
    }

    public static Man findMan() {
        return null;
    }
}

class SmartPhone {

    EWallet eWallet;

    public Optional<EWallet> geteWallet() {
        return Optional.empty();
    }
}

class EWallet {
    String accountNumber;

    public Optional<String> getAccountNumber() {
        return Optional.of("Account");
    }
}