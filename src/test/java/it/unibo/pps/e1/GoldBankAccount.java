package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    public static final int MAXIMUM_OVERDRAFT = 500;

    private final BankAccount base;

    public GoldBankAccount(BankAccount baseAccount) {
        this.base = baseAccount;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(this.base.getBalance() - amount < -MAXIMUM_OVERDRAFT) {
            throw new IllegalStateException("Exceeded maximum overdraft of 500.");
        }
        this.base.withdraw(amount);
    }
}
