package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender {

    private boolean parSdrErr;

    public ShellNotifier(final boolean parStdErr) {
        this.parSdrErr = parStdErr;
    }

    @Override
    public void notify(String parSender, String parReceiver, String parMessage) {
        if (this.parSdrErr)
            System.err.println("Notification from " + parSender + " to " + parReceiver + " received: " + parMessage);
        else
            System.out.println("Notification from " + parSender + " to " + parReceiver + " received: " + parMessage);
    }
}
