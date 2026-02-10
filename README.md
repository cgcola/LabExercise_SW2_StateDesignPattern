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
  <li><strong>Define Account States:</strong> Create separate classes representing different account states: <code>ActiveState</code>, <code>SuspendedState</code>, and <code>ClosedState</code>.</li>
  <li><strong>Implement State Interface: </li>
</ol>

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
