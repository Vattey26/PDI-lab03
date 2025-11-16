import java.util.Scanner;

class Item{
    int id;
    String name;
    int amount;
    double price;
    double total;

    Item(int id, String name, int amount, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price =  price;
        total = price*amount;
    }

    void display() {
        System.out.printf("%-5d     %-15s      %-10d      %-10.2f      %-10.2f\n", id, name, amount, price, total);
    }
}

class Inventory{
    Item items[];
    int index = 0;

    Inventory(int size) {
        items = new Item[size];
    }

    void addItem(Item item) {
        items[index] = item;
        index++;
    }

    void displayAllItems() {
        System.out.println("\nID            Name               Amount     Price($)    Total($)\n");
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            items[i].display();
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        System.out.print("Input: ");
        Scanner accept = new Scanner(System.in);
        int n = accept.nextInt();
        Inventory inventory = new Inventory(n);
        for(int i = 1; i <= n; i++) {
            System.out.println();
            System.out.print("Item ID: ");
            int id = accept.nextInt();
            accept.nextLine();
            System.out.print("Item Name: ");
            String name = accept.nextLine();
            System.out.print("Item Amount: ");
            int amount = accept.nextInt();
            System.out.print("Item Price: ");
            double price = accept.nextDouble();
            inventory.addItem(new Item(id, name, amount, price));
        }
        accept.close();
        inventory.displayAllItems();
    }
    
}
