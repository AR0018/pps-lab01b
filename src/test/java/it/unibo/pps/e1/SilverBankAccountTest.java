package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Override
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
