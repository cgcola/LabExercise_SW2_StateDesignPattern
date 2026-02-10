<h1>State Design Pattern Lab Exercise</h1>

<p>A bank needs to manage different states of customer accounts, including active, suspended, and closed. Each state has specific rules and restrictions regarding allowed operations, and accounts have associated attributes like account number and balance.</p>

<ul>
  <li><strong>Active Accounts:</strong> Allow deposits and withdrawals.</li>
  <li><strong>Suspended Accounts:</strong> Disallow deposits and withdrawals transactions, but allow viewing account information.</li>
  <li><strong>Closed Accounts:</strong> Disallow all transactions and viewing of account information.</li>
</ul>

<p>Currently, the system relies on conditional statements within the Account class to check the account state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.</p>

<p>Implement the State pattern to improve code maintainability and flexibility:</p>

<ol>
  <li><strong>Define Account States:</strong> Create separate classes representing different account states: 
    <code>ActiveState</code>, <code>SuspendedState</code>, and <code>ClosedState</code>.</li>

  <li><strong>Implement State Interface:</strong> Define an interface called 
    <code>AccountState</code> with methods for common actions like 
    <code>deposit</code>, <code>withdraw</code>, <code>activate</code>, 
    <code>suspend</code>, and <code>close</code>.</li>

  <li><strong>Implement State Behaviors:</strong> Each concrete state class implements the 
    <code>AccountState</code> interface and provides specific behavior for its respective state.  
    For example, the <code>ActiveState</code> class allows deposits and withdrawals, while the 
    <code>ClosedState</code> does not allow any transactions.</li>

  <li><strong>Update Account Class:</strong>
    <ul>
      <li>Include attributes for <code>accountNumber</code> and <code>balance</code>.</li>
      <li>Remove state-specific logic from the <code>Account</code> class.</li>
      <li>Introduce a reference to the current <code>AccountState</code> object.</li>
      <li>Delegate actions like <code>deposit</code>, <code>withdraw</code>, 
          <code>activate</code>, <code>suspend</code>, and <code>close</code> 
          to the current state object through its corresponding methods.</li>
    </ul>
  </li>
</ol>
<hr>
<p>Logic:</p>

<p>If the account is active:</p>
<ul><li>You can either suspend it or close it.</li></ul>

<p>If the account is suspended:</p>
<ul>
  <li>You can either activate or close it./li>
  <li>No deposits and withdrawals allowed.</li>
</ul>

<p>If the account is closed:</p>
<ul>
  <li>You can neither suspend nor activate it.</li>
  <li>No deposits and withdrawals allowed.</li>
</ul>

<p>Composition of Account:</p>
<ul>
  <li>accountNumber : String</li>
  <li>balance:  Double</li>
  <li>accountState:  AccountState</li>
</ul>

<p>Methods:</p>
<ul>
  <li>deposit(Double depositAmount): void</li>
  <li>withdraw(Double withdrawAmount): voidDouble</li>
  <li>suspend(): void</li>
  <li>activate(): void</li>
  <li>close() : void</li>
  <li>toString()   // displays account number and balance</li>
</ul>

<p><strong>Note:</strong> No if-else, switch will be used</p>
<hr>
<p>Create AccountTest() class to test the Account:</p>

```java
public class AccountTest {

    public static void main(String[] args) {

        // Create account (active state)
        Account myAccount = new Account("1234", 10000.0);

        // Activate the account
        myAccount.activate(); 
        // Displays: "Account is already activated!"

        // Suspend the account
        myAccount.suspend(); 
        // Displays: "Account is suspended!"

        // Activate the account again
        myAccount.activate(); 
        // Displays: "Account is activated!"

        // Deposit to the account
        myAccount.deposit(1000.0);
        // Updates balance and displays account number + current balance

        // Withdraw from the account
        myAccount.withdraw(100.0);
        // Updates balance and displays account number + current balance

        // Close the account
        myAccount.close(); 
        // Displays: "Account is closed!"

        // Try to activate a closed account
        myAccount.activate(); 
        // Displays: "You cannot activate a closed account!"

        // Try to suspend a closed account
        myAccount.suspend(); 
        // Displays: "You cannot suspend a closed account!"

        // Try to withdraw from a closed account
        myAccount.withdraw(500.0);
        // Displays: "You cannot withdraw on a closed account!"
        // Calls toString() to show current balance + account number

        // Try to deposit into a closed account
        myAccount.deposit(1000.0);
        // Displays: "You cannot deposit on a closed account!"
        // Calls toString() to show current balance + account number
    }
}
```
