package fr.epita.assistants.bankmanager;

import java.util.Objects;

public class Client {

    public String clientName;

    private Employee _accountManager = null;
    private BankAccount _bankAccount = null;

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public Employee getAccountManager() {
        return _accountManager;
    }

    public void setAccountManager(Employee _accountManager) {
        this._accountManager = _accountManager;
    }

    public BankAccount getBankAccount() {
        return _bankAccount;
    }

    public void setBankAccount(BankAccount _bankAccount) {
        this._bankAccount = _bankAccount;
    }

    public void depositMoney(double amount) throws Exception {
        if (_bankAccount == null) {
            throw new Exception("Cannot deposit money to a non-existent bank account.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount.");
        }
        _bankAccount.setTotalSavings(_bankAccount.getTotalSavings() + amount);
    }

    public void withdrawMoney(double amount) throws Exception {
        if (_bankAccount == null) {
            throw new Exception("Cannot deposit money to a non-existent bank account.");
        }
        if (amount > _bankAccount.getTotalSavings()) {
            throw new IllegalArgumentException("Cannot withdraw more than account's savings.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount.");
        }
        _bankAccount.setTotalSavings(_bankAccount.getTotalSavings() - amount);
    }

    public void transferMoney(Client clientToTransferTo, double amount) throws Exception {
        if (clientToTransferTo == null) {
            throw new IllegalArgumentException("Cannot transfer to a null client.");
        }

        this.withdrawMoney(amount);
        clientToTransferTo.depositMoney(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Client client)) {
            return false;
        }
        return Objects.equals(client.clientName, this.clientName) &&
            Objects.equals(client.getBankAccount().getIBAN(), this.getBankAccount().getIBAN());
    }
}
