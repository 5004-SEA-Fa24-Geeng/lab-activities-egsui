import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public static Book createFromString(String line) {

        String[] parts = line.split(","); // assumes no , in the title or author
        if (parts.length != 3)
            throw new IllegalArgumentException("Invalid input");
        int year;
        try {
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }
        return new Book(parts[0], parts[1], year);

    }

    @Override
    public String toString() {
        return title + " by " + author + " published in " + year;
    }

    @Override
    public int compareTo(Book other) {
        return this.getTitle().compareTo(other.getTitle());
    }

    public static void main(String[] args) {
        List<String> bookStrings = Arrays.asList("The Great Gatsby,F. Scott Fitzgerald,1925",
                "To Kill a Mockingbird,Harper Lee,1960",
                "1984,George Orwell,1949",
                "The Catcher in the Rye,J.D. Salinger,1951",
                "Beloved,Toni Morrison,1987");
        // stream to_list
        List<Book> books = bookStrings.stream().map(Book::createFromString).collect(Collectors.toList());
        System.out.println(books);

        // Find out the books published before "the certain year", and sorted the books by ascending year
        List<Book> books2 = books.stream().filter(book -> book.getYear() <= 2000)
                .sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
        System.out.println(books2);

    }
}
