public class OnlinePaymentNotification extends PaymentNotification 
{
    private final String method; 

    public OnlinePaymentNotification(NotificationChannel channel) 
    {
        this(channel, "credit card");
    }

    public OnlinePaymentNotification(NotificationChannel channel, String method) 
    {
        super(channel);
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }

    @Override
    public String buildMessage(double amount) 
    {
        return String.format("Your online payment of $%.2f via %s was successful.", amount, method);
    }
}