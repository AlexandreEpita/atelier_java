package fr.epita.assistants.bankmanager;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {
    @Test
    public void testInitBank()
    {
        Bank b = new Bank();
        Assertions.assertNotEquals(null, b);
    }

    //========================================================================================
    @Test
    public void testGetClient1()
    {
        Bank b = new Bank();
        Assertions.assertEquals(0, b.getClients().size());
    }

    @Test
    public void testGetClient2()
    {
        Bank b = new Bank();
        Assertions.assertNotEquals(null, b.getClients());
    }

    //=================================================================================
    @Test
    public void testGetEmployee1()
    {
        Bank b = new Bank();
        Assertions.assertEquals(0, b.getEmployees().size());
    }

    @Test
    public void testGetEmployee2()
    {
        Bank b = new Bank();
        Assertions.assertNotEquals(null, b.getClients());
    }

    //==================================================================================

    @Test
    public void testHire1() throws Exception {
        Bank b = new Bank();
        Employee e1 = new Employee("name");

        b.hire(e1);
        Assertions.assertEquals(1, b.getEmployees().size());
    }
    @Test
    public void testHire2()
    {
        Bank b = new Bank();
        Employee e1 = null;
        try {
            b.hire(e1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(null, e1);
        }
        catch (Exception e)
        {
            Assertions.assertTrue(false);
        }
    }

    //=============================================================================

    @Test
    public void testFire1() throws Exception {
        Bank b = new Bank();
        Employee e1 = new Employee("name");
        b.hire(e1);

        b.fire(e1);
        Assertions.assertEquals(0, b.getEmployees().size());
    }

    @Test
    public void testFire2()
    {
        Bank b = new Bank();
        Employee e1 = null;

        try {
            b.fire(e1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(null, e1);
        }
        catch (Exception e)
        {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testFire3()
    {
        Bank b = new Bank();
        Employee e1 = new Employee("name");

        try {
            b.fire(e1);

        } catch (NoSuchElementException e) {
            Assertions.assertTrue(!b.getEmployees().contains(e1));
        }
        catch (Exception e)
        {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testFire4()
    {
        Bank b = new Bank();
        Employee e1 = new Employee("name");
        Client c = new Client("client");

        try {
            b.hire(e1);
            b.addClient(c, 100);
            b.fire(e1);

        } catch (IllegalStateException e) {
            Assertions.assertTrue(b.getEmployees().size() == 1 && !b.getEmployees().get(0).getManagesClient().isEmpty());
        }
        catch (Exception e)
        {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testFire5() throws Exception {
        Bank b = new Bank();
        Employee e1 = new Employee("name");
        b.hire(e1);
        b.fire(e1);
        Assertions.assertEquals(0, b.getEmployees().size());
    }

    //====================================================

    @Test
    public void testAddClient1(){
        Bank b = new Bank();
        Client client = new Client("client");

        try {
            b.addClient(client, 100);
        } catch (Exception e) {
            Assertions.assertEquals(0, b.getEmployees().size());
        }
    }

    @Test
    public void testAddClient2(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = null;

        try {
            b.addClient(client, 100);
        }
        catch (IllegalArgumentException ex)
        {
            Assertions.assertEquals(null, client);
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    @Test
    public void testAddClient3(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = new Client("client");
        try {
            b.addClient(client, 100);
            b.addClient(client, 1000);
        }
        catch (IllegalArgumentException ex)
        {
            Assertions.assertTrue(b.getClients().contains(client));
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    @Test
    public void testAddClient4(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = new Client("client");
        int saving = -1;
        try {
            b.addClient(client, saving);
        }
        catch (IllegalArgumentException ex)
        {
            Assertions.assertTrue(saving < 0);
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    @Test
    public void testAddClient5(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = new Client("client");
        int saving = 100;
        try {
            b.addClient(client, saving);
            assertTrue(1 == b.getClients().size() && 1 == b.getNbBankAccounts());
        }
        catch (IllegalArgumentException ex)
        {
            Assertions.assertTrue(saving < 0);
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    // ==========================================================================

    @Test
    public void testRemoveClient1(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = new Client("client");
        Client toRemove = null;
        int saving = 100;
        try {
            b.addClient(client, saving);
            b.removeClient(toRemove);
        }
        catch (IllegalArgumentException ex)
        {
            Assertions.assertTrue(toRemove == null);
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    @Test
    public void testRemoveClient2(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = new Client("client");
        Client toRemove = new Client("other");
        int saving = 100;
        try {
            b.addClient(client, saving);
            b.removeClient(toRemove);
        }
        catch (NoSuchElementException ex)
        {
            Assertions.assertNotEquals(toRemove, client);
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    @Test
    public void testRemoveClient3(){
        Bank b = new Bank();
        Employee e = new Employee("employee");
        try {
            b.hire(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Client client = new Client("client");
        int saving = 100;
        try {
            b.addClient(client, saving);
            b.removeClient(client);
            Assertions.assertTrue(0 == b.getNbBankAccounts());
        }
        catch (Exception ex) {
            Assertions.assertEquals(false,true);
        }
    }

    // =====================================================================

    @Test
    public void testGetNbBankAccount() {
        Bank b = new Bank();
        assertTrue(b.getNbBankAccounts() == 0);
    }

    // ==========================================================================

    @Test
    public void testAssignClientManager1(){
        Bank b = new Bank();
        Client client = new Client("client");

        try {
            b.assignClientManager(client);
        } catch (IllegalStateException e) {
            Assertions.assertTrue(b.getEmployees().isEmpty());
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testAssignClientManager2(){
        Bank b = new Bank();
        Client client = new Client("client");

        try {
            b.assignClientManager(client);
        } catch (IllegalStateException e) {
            Assertions.assertTrue(b.getEmployees().isEmpty());
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testAssignClientManager(){
        Bank b = new Bank();
        Employee e1 = new Employee("e1");
        Employee e2 = new Employee("e2");

        try {
            b.hire(e1);
            b.hire(e2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Client c1 = new Client("c1");
        Client c2 = new Client("c2");

        try {
            b.addClient(c1, 1000);
            b.addClient(c2, 100);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(b.getClients().get(0).getAccountManager().equals(e1) && b.getClients().get(1).getAccountManager().equals(e2));
    }
}
