public abstract class PaymentNotification 
{
    protected final NotificationChannel channel; 

    protected PaymentNotification(NotificationChannel channel) 
    {
        this.channel = channel;
    }

    public NotificationChannel getChannel() 
    {
        return channel;
    }

    public abstract String buildMessage(double amount);

    public String notify(String recipient, double amount) 
    {
        return channel.send(recipient, buildMessage(amount));
    }
}