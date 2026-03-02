package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void TestOverdraftUpTo500 () {
        int withdraw_amount = DEPOSIT_AMOUNT + 500;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdraw_amount);
        assertEquals(DEPOSIT_AMOUNT - withdraw_amount, this.account.getBalance());
    }

    @Test
    public void TestOverdraftCannotBeHigherThan500 () {
        int withdraw_amount = DEPOSIT_AMOUNT + 501;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw_amount));
    }
}
