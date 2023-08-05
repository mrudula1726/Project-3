package com.data;

import java.util.Scanner;

public class Atm {
    private BankAccount bankAccount;
    private Scanner scanner;

    public Atm() {
        bankAccount = new BankAccount();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM Machine!");
        displayMenu();
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit amount must be greater than 0.");
        } else {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: Rs " + bankAccount.getBalance());
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be greater than 0.");
        } else if (amount > bankAccount.getBalance()) {
            System.out.println("Insufficient balance. Withdrawal amount exceeds your account balance.");
        } else {
            bankAccount.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: Rs " + bankAccount.getBalance());
        }
    }

    private void checkBalance() {
        System.out.println("Your account balance is: Rs " + bankAccount.getBalance());
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.start();
    }
    
}

class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
    
}