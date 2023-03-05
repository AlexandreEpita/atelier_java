package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;

import java.util.ArrayList;
import java.util.List;

public class User implements IMultiNotificationSender {

    private String username;
    private List<INotificationSender> parNotificationList;
    public User(final String username, final List<INotificationSender> parNotificationList)
    {
        this.username = username;
        this.parNotificationList = parNotificationList;
    }

    public User(final String username) // Equivalent to User(myUsername, new ArrayList<>())
    {
        this.username = username;
        this.parNotificationList = new ArrayList<INotificationSender>();
    }

    public String getUsername()// Returns the username
    {
        return this.username;
    }


    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
         for (INotificationSender sender : this.parNotificationList)
             sender.notify(this.username, parRecipient, parMessage);
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        if (parNotifier == null)
            return;
        this.parNotificationList.add(parNotifier);
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return this.parNotificationList;
    }
}
