import java.util.Scanner;

class Book {
    String title;
    String author;
    int id;
    double price;

    Book(String title, String author, int id, double price) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.price = price;
    }

    public void displayInfo() {
        System.out.printf("%-5d     %-5.2f      %-15s     %-15s\n", id, price, title, author);
    }
}

class Library{
    Book books[];
    int index = 0;
    Library(int size) {
        books = new Book[size];
    }

    void addBook(Book book) {
        books[index] = book;
        index++;
    }

    void displayAllBooks() {
        System.out.print("ID            Price($)            Title                 Author\n");
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            books[i].displayInfo();
        }
    }

    void findExpensiveBook() {
        double max = books[0].price;
        for(int i = 1; i < index; i++) {
            if(books[i].price > max) {
                max = books[i].price;
            }
        }
        System.out.println("The most expensive books: ");
        System.out.print("ID            Price($)            Title                 Author\n");
        for(int i = 0; i < index; i++) {
            if(books[i].price == max) {
                books[i].displayInfo();
            }
        }
    }

    void findCheapBook() {
        double min = books[0].price;
        for(int i = 1; i < index; i++) {
            if(books[i].price < min){
                min = books[i].price;
            }
        }
        System.out.println("The cheapest books: ");
        System.out.print("ID            Price($)            Title                 Author\n");
        for(int i = 0; i < index; i++) {
            if(books[i].price == min) {
                books[i].displayInfo();
            }
        }
    }

    void findAvgPrice() {
        double sum = 0;
        for(int i = 0; i < index; i++) {
            sum += books[i].price;
        }
        System.out.println("\n\tThe average price of books: " + (sum / index));
    }
}

public class libraryManagement {
    public static void main(String[] args) {
        Scanner accept = new Scanner(System.in);
        System.out.println("How many books fo you want to add?");
        System.out.print("Enter number of books: ");
        int n = accept.nextInt();
        Library mybooks = new Library(n);
        for(int i = 1; i <= n; i++) {
            System.out.println();
            System.out.print("ID: ");
            int id = accept.nextInt();
            accept.nextLine();            
            System.out.print("Title: ");
            String title = accept.nextLine();
            System.out.print("Author: ");
            String author = accept.nextLine();
            System.out.print("Price: ");
            double price = accept.nextDouble();
            mybooks.addBook(new Book(title, author, id, price));
        }

        accept.close();
        mybooks.displayAllBooks();
        mybooks.findExpensiveBook();
        mybooks.findCheapBook();
        mybooks.findAvgPrice();
    }
}