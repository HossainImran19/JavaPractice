package advance.java.imran.e.optional;


import java.util.Optional;

public class Person {
    public static void main(String[] args) {
        Optional<SmartPhoneUsingOptional> smartPhone
                = Optional.of(new SmartPhoneUsingOptional());
        Optional<PersonWithoutOptional> person
                = Optional.ofNullable(findPerson());
    }

    public static PersonWithoutOptional findPerson() {
        return null;
    }
}

// It may be that a PersonWithoutOptional may not have a SmartPhoneWithoutOptional.
// Even if a PersonWithoutOptional have SmartPhoneWithoutOptional,
// SmartPhoneWithoutOptional/PersonWithoutOptional may not have a EWalletWithoutOptional.
// In this scenario it may throw a NullPointerException Exception.
class PersonWithoutOptional {
    private SmartPhoneWithoutOptional smartphone;
    public SmartPhoneWithoutOptional getSmartphone() {
        return smartphone;
    }

    // It may throw an Exception.
//    public String getEWalletAccountNumber(PersonWithoutOptional person) {
//        return person
//                .smartphone
//                .getWallet()
//                .getAccountNumber();
//    }

    // The NullPointerException is handled by defensive checking.
    public String getEWalletAccountNumber(PersonWithoutOptional person) {
        if (person != null) {
            var smartPhone = person.getSmartphone();
            if (smartPhone != null) {
                var wallet = smartPhone.getWallet();

                return wallet.getAccountNumber();
            }
        }
        // User or Caller need to check whether return value is null or not.
        // This problem can be solved by java.util.Optional<T> class.
        return "Unknown";
    }
}

class SmartPhoneWithoutOptional {
    private EWalletWithoutOptional wallet;
    public EWalletWithoutOptional getWallet() {
        return wallet;
    }
}

class EWalletWithoutOptional {
    private String accountNumber;
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Optional<T> class is a container..
// In this container may or may not contain object.
class PersonUsingOptional {
    private Optional<SmartPhoneUsingOptional> smartPhone;
    public Optional<SmartPhoneUsingOptional> getSmartPhone() {
        return smartPhone;
    }
}
class SmartPhoneUsingOptional {
    private Optional<EWalletUsingOptional> eWallet;
    private Optional<EWalletUsingOptional> geteWallet() {
        return eWallet;
    }
}

class EWalletUsingOptional {
    private Optional<String> accountNumber;
    public Optional<String> getAccountNumber() {
        return accountNumber;
    }
}
