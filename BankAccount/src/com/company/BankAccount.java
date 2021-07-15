package com.company;

class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

  /*  public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }*/

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }
    }

        public void withdraw ( double amount){
            synchronized (this) {
                balance -= amount;
            }
        }
}
