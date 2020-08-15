public class BasicBankAccountJava {

    public static void main(String[] args) {
        // create account object and set variables
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        
        // create checkingaccount object and set variables
        CheckingAccount checking = new CheckingAccount(1122, 20000);
        checking.setAnnualInterestRate(4.5);
        
        // create savings account object and set variables
        SavingsAccount savings = new SavingsAccount(1122, 20000);
        savings.setAnnualInterestRate(4.5);
        
        // invoke toString() methods
        account.toString();
        checking.toString();
        savings.toString();
    }
    
}

// account class
class Account {
    // data fields
    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 0.0;
    private java.util.Date dateCreated;
    private String name;
    
    // constructs default account object
    public Account() {
        dateCreated = new java.util.Date();
    }
    
    // constructs account object with id and balance
    public Account(int id, double balance) {
        this();
        this.name = "Account";
        this.id = id;
        this.balance = balance;
    }
    
    // return id
    public int getId() {
        return this.id;
    }
    
    // return balance
    public double getBalance() {
        return this.balance;
    }
    
    // return annual interest rate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    // return date account created
    public String getDateCreated() {
        return this.dateCreated.toString();
    }
    
    // set id
    public void setId(int id) {
        this.id = id;
    }
    
    // set balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    // set annual interest rate
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    // calculate and return monthly interest rate
    public double getMonthlyInterestRate() {
        return ((annualInterestRate / 100)/12);
    }
    
    // calculate and return monthyl interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }
    
    // withdraw method
    public void withdraw(double amount) {
        this.balance -= amount;
    }
    
    // deposit method
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public String getName() {
        return this.name;
    }
    
    // print balance, monthly interest, and the date created
    public String toString() {
        System.out.println(this.getName() +":");
        System.out.println("Balance: $" + this.getBalance());
        System.out.println("Monthly Interest: $" + this.getMonthlyInterest());
        System.out.println("Date Created: " + this.getDateCreated());
        System.out.println();
        return "";
    }
}

// checking account class that has an overdraft limit
class CheckingAccount extends Account {
    double overdraftLimit = 100;
    private final String name;
    
    // constructs checking object
    public CheckingAccount(int id, double balance) {
        this.name = "Checking";
        this.setId(id);
        this.setBalance(balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (this.getBalance() - amount < overdraftLimit) {
            System.out.println("You have insufficient funds to complete this withdraw.");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}

// savings account class that has no overdraft
class SavingsAccount extends Account {
    double overdraftLimit = 0;
    private final String name;
    
    // constructs savings object
    public SavingsAccount(int id, double balance) {
        this.name = "Savings";
        this.setId(id);
        this.setBalance(balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (this.getBalance() - amount < overdraftLimit) {
            System.out.println("You have insufficient funds to complete this withdraw.");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}
