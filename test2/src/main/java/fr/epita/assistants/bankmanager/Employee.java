package fr.epita.assistants.bankmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private final List<Client> _managesClient;
    public String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
        this._managesClient = new ArrayList<>();
    }

    public List<Client> getManagesClient() {
        return _managesClient;
    }

    public void manageClient(Client client) throws Exception {
        if (client.getAccountManager() != null) {
            throw new Exception("Cannot manage a client who is already managed.");
        }
        _managesClient.add(client);
        client.setAccountManager(this);
    }

    public void unmanageClient(Client client) throws Exception {
        if (client.getAccountManager() == null) {
            throw new Exception("Cannot unmanage a client who is not managed.");
        }
        _managesClient.remove(client);
        client.setAccountManager(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee employee)) {
            return false;
        }
        return Objects.equals(employee.employeeName, this.employeeName) &&
            employee.getManagesClient() == this.getManagesClient();
    }
}
