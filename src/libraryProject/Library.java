package libraryProject;

import java.util.ArrayList;

public class Library {
    //Instance variables

    private String address;
    private ArrayList<Book> catalog = new ArrayList();
    //Constructors

    public Library(String libraryAddress) {
        this.address = libraryAddress;
    }
    //Getters & Setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }
    //Class Methods

    public void addBook(Book bookToAdd) {
        getCatalog().add(bookToAdd);
    }
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }
    public void printAddress() {
        System.out.println(this.getAddress());
    }
    public void borrowBook(String titleOfBookToBorrow) {
        Book bookToFind = null;
        for (Book bookInCatalog : this.getCatalog()) {
            if(bookInCatalog.getTitle().equalsIgnoreCase(titleOfBookToBorrow)){
                bookToFind = bookInCatalog;
            }
        }
        if(bookToFind == null) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else {
            if(bookToFind.isBorrowed()) {
                System.out.println("Sorry, this book is already borrowed.");
            } else {
                bookToFind.borrowed();
                System.out.println("You successfully borrowed The Lord of the Rings");
            }
        }
    }
    public void printAvailableBooks() {
        if(this.getCatalog().size() == 0) {
            System.out.println("No book in catalog ");
        } else {
            for(Book bookInCatalog : this.getCatalog()) {
                System.out.println(bookInCatalog.getTitle());
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
//
//        // Return The Lords of the Rings to the first library
//        System.out.println("Returning The Lord of the Rings:");
//        firstLibrary.returnBook("The Lord of the Rings");
//        System.out.println();
//
//        // Print the titles of available from the first library
//        System.out.println("Books available in the first library:");
//        firstLibrary.printAvailableBooks();
   }
}
