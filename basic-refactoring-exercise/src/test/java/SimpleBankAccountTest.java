import example.model.AccountHolder;
import example.model.BankAccount;
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
    void testWithdraw() {
        final int withdrawAmount = 70;

        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);
        assertEquals(INITIAL_DEPOSIT - withdrawAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        final int differentUserId = 2;
        final int withdrawAmount = 70;

        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT);
        bankAccount.withdraw(differentUserId, withdrawAmount);
        assertEquals(INITIAL_DEPOSIT, bankAccount.getBalance());
    }
}
