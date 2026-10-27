public class BitcoinPayment extends PaymentNotification 
{
    public BitcoinPayment(NotificationChannel channel) 
    {
        super(channel);
    }

    @Override
    public String buildMessage(double amount) 
    {
        return String.format("Your Bitcoin payment equal to $%.2f has been received and confirmed.", amount);
    }
}