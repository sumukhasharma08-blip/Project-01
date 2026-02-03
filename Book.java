public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor with full details
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Constructor overloading
    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.author = "Unknown";
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    public void displayBookDetails() {
        System.out.println(
                "ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Available: " + isAvailable
        );
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
