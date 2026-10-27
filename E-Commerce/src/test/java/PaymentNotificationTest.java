import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PaymentNotificationTest 
{

    // ---------- OnlinePaymentNotification ----------
    @Test
    void onlineBuildMessage() 
    {
        OnlinePaymentNotification n = new OnlinePaymentNotification(new EmailChannel(), "paypal");
        assertEquals("Your online payment of $10.00 via paypal was successful.", n.buildMessage(10));
    }

    @Test
    void onlineGetMethodAndDefault() 
    {
        assertEquals("paypal", new OnlinePaymentNotification(new EmailChannel(), "paypal").getMethod());
        assertEquals("credit card", new OnlinePaymentNotification(new SmsChannel()).getMethod());
    }

    @Test
    void onlineNotifyViaEmail() 
    {
        String out = new OnlinePaymentNotification(new EmailChannel()).notify("a@x.com", 5);
        assertTrue(out.startsWith("[EMAIL to a@x.com]"));
        assertTrue(out.contains("credit card"));
    }

    @Test
    void onlineNotifyViaSmsAndPush() 
    {
        assertTrue(new OnlinePaymentNotification(new SmsChannel(), "paypal").notify("555", 5).startsWith("[SMS"));
        assertTrue(new OnlinePaymentNotification(new PushChannel()).notify("d", 5).startsWith("[PUSH"));
    }

    // ---------- CashOnDeliveryPayment ----------
    @Test
    void cashBuildMessage() 
    {
        assertTrue(new CashOnDeliveryPayment(new SmsChannel()).buildMessage(20).contains("cash"));
    }

    @Test
    void cashNotifyViaSmsAndEmail() 
    {
        String sms = new CashOnDeliveryPayment(new SmsChannel()).notify("555", 20);
        assertTrue(sms.startsWith("[SMS to 555]"));
        assertTrue(sms.contains("$20.00"));
        assertTrue(new CashOnDeliveryPayment(new EmailChannel()).notify("b", 20).startsWith("[EMAIL"));
    }

    // ---------- BitcoinPayment ----------
    @Test
    void bitcoinBuildMessage() 
    {
        assertTrue(new BitcoinPayment(new EmailChannel()).buildMessage(1).contains("Bitcoin"));
    }

    @Test
    void bitcoinNotifyViaEmailSmsAndPush() 
    {
        assertTrue(new BitcoinPayment(new EmailChannel()).notify("a", 1).startsWith("[EMAIL"));
        assertTrue(new BitcoinPayment(new SmsChannel()).notify("a", 1).startsWith("[SMS"));
        assertTrue(new BitcoinPayment(new PushChannel()).notify("d", 1).startsWith("[PUSH"));
    }

    // ---------- The bridge ----------
    @Test
    void getChannelReturnsTheBridge() 
    {
        NotificationChannel ch = new EmailChannel();
        assertSame(ch, new CashOnDeliveryPayment(ch).getChannel());
    }
}