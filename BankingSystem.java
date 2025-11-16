import java.util.Scanner;

class Account {
    int id;
    String name;
    double balance;

    Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    void update() {
        System.out.printf("%-5d     %-15s      %-10.2f\n", id, name, balance);
    }
}

class Bank {
    Account accounts[];
    int index = 0;

    Bank(int size) {
        accounts = new Account[size];
    }

    void addAccount(Account account) {
        accounts[index] = account;
        index++;
    }

    void displayAllUpdates() {
        System.out.println("\nUpdate: ");
        System.out.println("ID            Name               Balance($)\n");
        System.out.println("--------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            accounts[i].update();
        }
    }

    void desposit(double moneyDeposit, int id) {
        for(int i = 0; i < index; i++) {
            if (accounts[i].id == id) {
                accounts[i].balance += moneyDeposit;
                System.out.println("Deposit Successful!");
            }
        }
    }

    void wihtdraw(double moneyWithdraw, int id) {
        for(int i =0; i < index; i++) {
            if (accounts[i].id == id) {
                if (accounts[i].balance >= moneyWithdraw) {
                    accounts[i].balance -= moneyWithdraw;
                    System.out.println("Withdraw Successful!");
                } else {
                    System.out.println("Insufficient Balance!");
                }
            }
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        System.out.print("Input: ");
        Scanner accept = new Scanner(System.in);
        int n = accept.nextInt();
        Bank bank = new Bank(n);
        for(int i = 1; i <= n; i++) {
            System.out.println();
            System.out.print("Account Number: ");
            int id = accept.nextInt();
            accept.nextLine();
            System.out.print("Account Name: ");
            String name = accept.nextLine();
            System.out.print("Account Balance: ");
            double balance = accept.nextDouble();
            Account account = new Account(id, name, balance);
            bank.addAccount(new Account(id, name, balance));
        }

        while(true) {
            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int input = accept.nextInt();
            System.out.println();
            if (input == 1) {
                System.out.print("Account ID: ");
                int id = accept.nextInt();
                System.out.print("Deposit Amount: ");
                double depositAmount = accept.nextDouble();
                bank.desposit(depositAmount, id);
                bank.displayAllUpdates();
            } else if (input == 2) {
                System.out.print("Account ID: ");
                int id = accept.nextInt();
                System.out.print("Withdraw Amount: ");
                double withdrawAmount = accept.nextDouble();
                bank.wihtdraw(withdrawAmount, id);
                bank.displayAllUpdates();
            } else if (input == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid Option! Please try again.");
            }
            bank.displayAllUpdates();
        }
        accept.close();
    }
}    
