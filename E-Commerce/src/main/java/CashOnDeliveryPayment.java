public class CashOnDeliveryPayment extends PaymentNotification 
{
    public CashOnDeliveryPayment(NotificationChannel channel) 
    {
        super(channel);
    }

    @Override
    public String buildMessage(double amount) 
    {
        return String.format("Please have $%.2f in cash ready when your order is delivered.", amount);
    }
}