package fr.epita.assistants.bankmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Bank {

    private final List<Employee> _employees;
    private final List<Client> _clients;
    private int _nbBankAccounts;

    public Bank() {
        this._employees = new ArrayList<>();
        this._clients = new ArrayList<>();
        this._nbBankAccounts = 0;
    }

    public List<Client> getClients() {
        return _clients;
    }

    public List<Employee> getEmployees() {
        return _employees;
    }

    public void hire(Employee employee) throws Exception {
        if (employee == null) {
            throw new IllegalArgumentException("Cannot hire a null employee.");
        }
        _employees.add(employee);
    }

    public void fire(Employee employee) throws Exception {
        if (employee == null) {
            throw new IllegalArgumentException("Cannot fire a null employee.");
        }

        if (!_employees.contains(employee)) {
            throw new NoSuchElementException("Cannot fire an employee that was not hired.");
        }

        if (_employees.size() == 1 && !_employees.get(0).getManagesClient().isEmpty()) {
            throw new IllegalStateException("This is not yet the future, automated banks do not exist, please come back later");
        }

        _employees.remove(employee);
        for (var client : employee.getManagesClient()) {
            employee.unmanageClient(client);
            assignClientManager(client);
        }
    }

    public void addClient(Client client, double savings) throws Exception {
        if (_employees.isEmpty()) {
            throw new Exception("Cannot add a client if no employee exists.");
        }

        if (client == null) {
            throw new IllegalArgumentException("Cannot add a null client.");
        }

        if (_clients.contains(client)) {
            throw new IllegalArgumentException("Cannot add a client that is already registered.");
        }

        if (savings < 0) {
            throw new IllegalArgumentException("Cannot add a client with negative savings.");
        }

        _clients.add(client);
        client.setBankAccount(new BankAccount(this, client, savings));
        _nbBankAccounts++;
        assignClientManager(client);
    }

    public void removeClient(Client client) throws Exception {
        if (client == null) {
            throw new IllegalArgumentException("Cannot remove a null client.");
        }

        if (!_clients.contains(client)) {
            throw new NoSuchElementException("Cannot remove a client that was not added.");
        }

        _clients.remove(client);
        client.getAccountManager().unmanageClient(client);
    }

    public int getNbBankAccounts() {
        return _nbBankAccounts;
    }

    public void assignClientManager(Client client) throws Exception {
        if (_employees.isEmpty())
            throw new IllegalStateException("Cannot assign a client a manager if no employee exists.");

        List<Integer> nbClientsManaged = _employees.stream()
            .map(employee -> employee.getManagesClient().size()).toList();
        int leastManagedIndex = nbClientsManaged.indexOf(Collections.min(nbClientsManaged));
        _employees.get(leastManagedIndex).manageClient(client);
    }
}
