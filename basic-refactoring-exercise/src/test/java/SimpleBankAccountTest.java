import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.IllegalTransactionException;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final static int INITIAL_DEPOSIT = 100;
    private final static int INITIAL_BALANCE = 0;


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        final int differentUserId = 2;
        final int differentDeposit = 50;

        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        bankAccount.deposit(differentUserId, differentDeposit);
        assertEquals(INITIAL_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee(){
        final int withdrawAmount = 50;

        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);

        final int expectedBalance = INITIAL_BALANCE + INITIAL_DEPOSIT - withdrawAmount - SimpleBankAccount.WITHDRAW_FEE;

        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testFailedWithdraw(){
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        assertThrows(IllegalTransactionException.class, () -> bankAccount.withdraw(accountHolder.getId(), INITIAL_DEPOSIT));
    }

    @Test
    void testWrongWithdrawWithFee(){
        final int wrongUserId = 2;
        final int withdrawAmount = 50;

        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        bankAccount.withdraw(wrongUserId, withdrawAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);

        final int expectedBalance = INITIAL_BALANCE + INITIAL_DEPOSIT - withdrawAmount - SimpleBankAccount.WITHDRAW_FEE;

        assertEquals(expectedBalance, bankAccount.getBalance());
    }
}
