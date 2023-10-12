package advance.java.imran.lamda.expression;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    public List<Contact> findCAB18and25(List<Contact> contacts,
                                        FilterCriteria filterCriteria) {
        List<Contact> matchC
                = new ArrayList<>();

        for (Contact contact : contacts) {
            if (filterCriteria.match(contact))
                matchC.add(contact);
        }
        return matchC;
    }


}
