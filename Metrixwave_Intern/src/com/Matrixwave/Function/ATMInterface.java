package com.Matrixwave.Function;

import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean authenticate(int inputPin) {
        return this.pin == inputPin;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Successfully withdraw: $" + amount);
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    public void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ATM atm = new ATM(scan.nextDouble(), scan.nextInt()); // Example initial balance and PIN

        System.out.print("Enter your PIN: ");
        int inputPin = scan.nextInt();

        if (atm.authenticate(inputPin)) {
            int option;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                option = scan.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Your balance is: $" + atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scan.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scan.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        atm.exit();
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } while (option != 4);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        scan.close();
    }
}
