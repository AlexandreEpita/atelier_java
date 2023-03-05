package fr.epita.assistants.notifyme;

import fr.epita.assistants.notifyme.notify.ShellNotifier;
import fr.epita.assistants.notifyme.user.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*final User user = new User("John Doe", List.of(new ShellNotifier(false), new ShellNotifier(true)));
        user.sendNotifications("ING1", "Hello World!");*/

        final User user1 = new User("John Doe");
        user1.addNotifier(new ShellNotifier(false));
        user1.addNotifier(new ShellNotifier(true));
        user1.sendNotifications("ING1", "Hello World!");
    }
}
