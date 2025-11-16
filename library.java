
import java.awt.print.Book;

public class library {

    class book {
        String title;
        String author;
        int ID;
        double price;

        Book(String title, String author, int ID, double price) {
            this.title = title;
            this.author = author;
            this.ID = ID;
            this.price = price;
        }

        public void display(){
            System.out.printf("title: %s\nauthor: %s\nID: %d\nprice: %.2f\n", title, author, ID, price);
        }

    }

    class Library {
        List<Book> books;

        Library() {
            books = new ArrayList<Book>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void displayBooks() {
            for (Book book : books) {
                book.display();
                System.out.println("-----");
            }
        }
    }

    public static void main(String[] args) {
        library lib = new library();
        Library myLibrary = lib.new Library();

        Book book1 = lib.new Book("The Great Gatsby", "F. Scott Fitzgerald", 1, 10.99);
        Book book2 = lib.new Book("1984", "George Orwell", 2, 8.99);
        Book book3 = lib.new Book("To Kill a Mockingbird", "Harper Lee", 3, 12.49);

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        myLibrary.displayBooks();
    }
}