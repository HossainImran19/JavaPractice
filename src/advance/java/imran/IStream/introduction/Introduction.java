package advance.java.imran.IStream.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;

public class Introduction {

    public static void main(String[] args) {
        List<Book> list = List.of(
                new Book(232.33, "English", "atomic habit"),
                new Book(1000.00, "English", "Advacne java"),
                new Book(555.33, "English", "java practice"),
                new Book(555.33, "Bangla", "C programming"),
                new Book(555.33, "English", "C programming by subeen"),
                new Book(1000.32, "English", "Advacne java"),
                new Book(999.22, "Bangla", "Advacne java")
        );

        System.out.println(findEnglinshBooks(list));

        System.out.println("========================================");

        System.out.println(findEnglinshBooksWithSteam(list));
    }

    // Without using stream api we used some local variables to
    // perform some specific tasks.
    public static String findEnglinshBooks(List<Book> books) {
        List<Book> englishBooks = new ArrayList<>();

        for (var book : books) {
            if (book.getLanguage().equals("English")
                    && book.getPrice() >= 500
                    && book.getPrice() <= 1000)
                englishBooks.add(book);
        }

        Collections.sort(englishBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        final String newLine = "\n";
        StringBuilder bookBuilder = new StringBuilder();

        for (var englishBook : englishBooks)
            bookBuilder.append(englishBook.toString()).append(newLine);

        return bookBuilder.toString();
    }

    // Using Stream API.
    // Here we concentrate on what we need, not how we need it.
    public static String findEnglinshBooksWithSteam(List<Book> books) {
        final String Language = "English";
        final String comma = ",";

        return books
                .stream()
                .filter(book -> book.getLanguage().equals(Language))
                .filter(book -> 500 <= book.getPrice() && book.getPrice() <= 1000)
                .sorted(comparingDouble(Book::getPrice))
                .map(Book::toString)
                .collect(Collectors.joining(comma));
    }
}
