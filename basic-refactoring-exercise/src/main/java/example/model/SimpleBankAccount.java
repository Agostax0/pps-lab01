package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount,
 * additionally a withdrawal fee is detracted
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    public static final int WITHDRAW_FEE = 1;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if(!isWithdrawAllowed(amount)) throw new IllegalTransactionException();

        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= (amount + WITHDRAW_FEE);
        }

    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount + WITHDRAW_FEE;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
