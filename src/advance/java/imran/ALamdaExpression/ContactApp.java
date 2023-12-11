package advance.java.imran.ALamdaExpression;

import java.util.List;

public class ContactApp {
    List<Contact> list
            = List.of(
                    new Contact("Imran",
                            "irman@gmail.com",
                            25,
                            Contact.Gender.MALE
                    ),
            new Contact("Mizan",
                    "mizan@gmail.com",
                    32,
                    Contact.Gender.MALE
            ),
            new Contact("Jui",
                    "jui@gmail.com",
                    17,
                    Contact.Gender.FEMALE
            )
    );

    ContactService contactService
            = new ContactService();


}
