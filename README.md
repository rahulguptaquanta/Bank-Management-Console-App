# Bank Management Console App (Java)

A beginner-friendly, menu-driven Java mini project for **Week 1 – Java Fundamentals**.

## Features
- Create a demo account using the account holder's name
- Deposit money
- Withdraw money (prevents withdrawal when the balance is insufficient)
- Check balance
- View transaction history
- View account details
- Input validation for menu choices and amounts

## Java concepts used
- Variables and data types
- `Scanner` for user input
- `while` loop
- `switch` and `if-else`
- Methods
- `ArrayList`
- Exception handling (`try-catch`)
- Basic arithmetic and formatted output

## Requirements
- JDK 8 or newer
- Command Prompt / Terminal, VS Code, IntelliJ IDEA, or Eclipse

## Run using Command Prompt / Terminal
1. Extract the ZIP file.
2. Open a terminal inside the project folder.
3. Compile the program:

   ```bash
   javac BankManagementApp.java
   ```

4. Run it:

   ```bash
   java BankManagementApp
   ```

## Run in VS Code
1. Install a JDK and the **Extension Pack for Java**.
2. Open the extracted project folder in VS Code.
3. Open `BankManagementApp.java`.
4. Click **Run** above the `main` method, or use the terminal commands above.

## How to test
1. Enter an account holder name.
2. Select `1` and deposit `1000`.
3. Select `3` to verify the balance.
4. Select `2` and withdraw `250`.
5. Select `4` to view the transaction history.
6. Try withdrawing more than the available balance to test validation.
7. Select `6` to exit.

## Important note
This is an educational console project. It stores data only while the program is running. It is **not** connected to a real bank, database, or payment system.
