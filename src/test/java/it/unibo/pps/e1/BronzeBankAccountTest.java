package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBankAccountTest extends SilverBankAccountTest {

    @BeforeEach
    void init() {
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
            "80, " + (DEPOSIT_AMOUNT - 80),
            "100, " + (DEPOSIT_AMOUNT - 100 - 1)
    })
    public void testWithdrawFee(final int withdrawAmount, final int expectedResult) {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawAmount);
        assertEquals(expectedResult, this.account.getBalance());
    }
}
