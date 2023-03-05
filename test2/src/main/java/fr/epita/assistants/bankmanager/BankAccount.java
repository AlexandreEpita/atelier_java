package fr.epita.assistants.bankmanager;

import java.util.Objects;

public class BankAccount {

    private final Bank _bank;
    private final Client _accountOwner;
    private final String _IBAN;
    private double _totalSavings;

    public BankAccount(Bank bank, Client accountOwner, double savings) {
        this._bank = bank;
        this._accountOwner = accountOwner;
        this._totalSavings = savings;
        this._IBAN = generateIBAN();
    }

    public Client getAccountOwner() {
        return _accountOwner;
    }

    public String getIBAN() {
        return _IBAN;
    }

    public double getTotalSavings() {
        return _totalSavings;
    }

    public void setTotalSavings(double _totalSavings) {
        this._totalSavings = _totalSavings;
    }

    public String generateIBAN() {
        if (!Objects.equals(_IBAN, null)) {
            return _IBAN;
        }

        String uniqueNumber = String.format("%04d", _bank.getNbBankAccounts());
        return "EPITA 2025 " + uniqueNumber;
    }
}
