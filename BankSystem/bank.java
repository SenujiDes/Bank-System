import java.util.ArrayList;
import java.util.Scanner;

public class bank {
    private int accountNumberCounter = 1000;

    //Dynamic Array
    private ArrayList<account> accountList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public int search(int accNum) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccount() == accNum) {
                return i; // returning the current index of the account
            }
        }
        return -1;
    }

    public void createAccount() {
        System.out.println("\n*******************************************************************");
        System.out.println("*                   SUB MENU OPTIONS                              *");
        System.out.println("*******************************************************************");
        System.out.println("1)Gold account");
        System.out.println("2)General account");
        System.out.println();
        System.out.print("Choose the account category: ");
        int accCatergry = input.nextInt();
        input.nextLine();
        int accNum = accountNumberCounter++;
        System.out.print("Please enter the name of the account holder: ");
        String holder_name = input.nextLine();
        System.out.println("Your account number is: " + accNum);
        if (search(accNum) == -1) {
            if (accCatergry == 1) {
                goldAccount newGoldAcc = new goldAccount(accNum, holder_name, 2000);
                accountList.add(newGoldAcc);
            } 
            else {
                account newAccount = new account(accNum, holder_name);
                accountList.add(newAccount);
            }
            System.out.println("Your account is created successfully!");
            System.out.println();
        } 
        else {
            System.out.println("Sorry, The given account number already exist");
            System.out.println();
        }
    }

    

    public void deleteAccount() {
        System.out.println("If you wish to delete your account please enter your account number:");
        int accNum = input.nextInt();
        int remove_index = search(accNum);
        if (remove_index != -1) { // We need to get the index of the
            accountList.remove(remove_index); // In the remove method you need to remove an element by it's index
            System.out.println("Your account has been removed successfuly");
            System.out.println();
        } else {
            System.out.println("Sorry, The account number you have provided does not exist");
            System.out.println();
        }
    }

    public int total_accounts() {
        return accountList.size();
    }

    public void depositMoney() {
        System.out.print("Please enter you account number: ");
        int accNum = input.nextInt();
        int accountNumIndex = search(accNum);
        if (accountNumIndex != -1) {
            System.out.print("Please enter the amount of cash you want to deposit: $");
            double deposit_amount = input.nextDouble();
            //double new_balance = accountList.get(accountNumIndex).getBalance() + deposit_amount;
            accountList.get(accountNumIndex).deposit(deposit_amount);
            System.out.println("Successfuly deposited");
            System.out.println("Your account balance is: $" + accountList.get(accountNumIndex).getBalance());

        } else {
            System.out.println("Sorry, The account number you have provided does not exist");
            System.out.println();
        }

    }

    public void withdrawMoney() {
        System.out.print("Please enter your account number: ");
        int accNum = input.nextInt();
        int AccountIndex = search(accNum);

        if (AccountIndex != -1) {
            System.out.print("Please enter the amount of cash you want to withdraw: $");
            double withdraw_amount = input.nextDouble();
            accountList.get(AccountIndex).withdraw(withdraw_amount); // The withdrawal of money is setted
            System.out.println("Successfuly withdrawd");
            System.out.println("Your account balance is: " + accountList.get(AccountIndex).getBalance());
            }

         else {
            System.out.println("Sorry, The account number you have provided does not exist");
            System.out.println();
        }

    }

    public void showAccounts() {

        System.out.println("Display Accounts");
        System.out.println();

        if (accountList.isEmpty()) {
            System.out.println("No Account available");
            System.out.println();
            return;
        }
        for (int j = 0; j < accountList.size(); j++) {
            accountList.get(j).account_details();
            System.out.println("_________________________________________");
            System.out.println();
        }
    }

}
