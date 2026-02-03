import java.util.Scanner;

public class Library {

    static Book[] books = new Book[10]; // Array of objects
    static int count = 0; // number of books

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook(sc);
                    break;

                case 4:
                    borrowBook(sc);
                    break;

                case 5:
                    returnBook(sc);
                    break;

                case 6:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // Add book
    static void addBook(Scanner sc) {
        if (count >= books.length) {
            System.out.println("Library is full!");
            return;
        }

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books[count] = new Book(id, title, author);
        count++;

        System.out.println("Book added successfully.");
    }

    // Display all books
    static void displayBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            books[i].displayBookDetails();
        }
    }

    // Search book
    static void searchBook(Scanner sc) {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].displayBookDetails();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Borrow book
    static void borrowBook(Scanner sc) {
        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return book
    static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getBookId() == id) {
                books[i].returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
