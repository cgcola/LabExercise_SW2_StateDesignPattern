public class Account {
    private String accountNumber;
    private double balance;
    private AccountState currentState;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.currentState = new ActiveState();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AccountState currentState) {
        this.currentState = currentState;
    }

    public void deposit(double amount) {
        currentState.deposit(this, amount);
    }

    public void withdraw(double amount) {
        currentState.withdraw(this, amount);
    }

    public void activate() {
        currentState.activate(this);
    }

    public void suspend(){
        currentState.suspend(this);
    }

    public void close() {
        currentState.close(this);
    }

    public void viewAccountInfo() {
        currentState.viewAccountInfo(this);
    }

    @Override
    public String toString() {
        return "\nAccount Number: " + accountNumber + "\nBalance: PHP " + String.format("%.2f", balance) + "\n";
    }
}