package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    public static final int DEPOSIT_AMOUNT = 1000;
    private BankAccount account;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int withdraw_amount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdraw_amount);
        assertEquals(DEPOSIT_AMOUNT - withdraw_amount - 1, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int withdraw_amount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw_amount));
    }

}
