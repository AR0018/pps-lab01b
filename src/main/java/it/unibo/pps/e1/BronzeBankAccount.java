package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {
    private final BankAccount base;

    public BronzeBankAccount(BankAccount baseAccount) {
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
        if(this.base.getBalance() < amount) {
            throw new IllegalStateException("Cannot withdraw more than available.");
        }
        this.base.withdraw(amount < 100 ? amount : amount + 1);
    }
}
