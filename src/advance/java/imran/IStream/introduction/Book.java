package advance.java.imran.IStream.introduction;

public class Book {
    private Double price;
    private String language;

    private String name;

    public Book(Double price, String language, String name) {
        this.price = price;
        this.language = language;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
