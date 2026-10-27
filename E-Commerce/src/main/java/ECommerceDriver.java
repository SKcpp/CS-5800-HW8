public class ECommerceDriver 
{
    public static void main(String[] args) 
    {
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();
        NotificationChannel push = new PushChannel();

        System.out.println("=== Part 1: Online / Cash on delivery with Email and SMS ===");
        System.out.println(new OnlinePaymentNotification(email, "credit card").notify("alice@example.com", 49.99));
        System.out.println(new OnlinePaymentNotification(sms, "paypal").notify("555-0101", 49.99));
        System.out.println(new CashOnDeliveryPayment(email).notify("bob@example.com", 20.00));
        System.out.println(new CashOnDeliveryPayment(sms).notify("555-0102", 20.00));

        System.out.println("\n=== Part 2: BitcoinPayment ===");
        System.out.println(new BitcoinPayment(email).notify("carol@example.com", 120.00));
        System.out.println(new BitcoinPayment(sms).notify("555-0103", 120.00));

        System.out.println("\n=== Part 3: PushChannel ===");
        System.out.println(new OnlinePaymentNotification(push, "credit card").notify("device-42", 15.00));
        System.out.println(new BitcoinPayment(push).notify("device-43", 75.00));
    }
}