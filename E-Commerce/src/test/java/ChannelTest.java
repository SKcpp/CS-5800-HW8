import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ChannelTest 
{

    @Test
    void emailChannelSend() 
    {
        assertEquals("[EMAIL to a@x.com] hi", new EmailChannel().send("a@x.com", "hi"));
    }

    @Test
    void smsChannelSend() 
    {
        assertEquals("[SMS to 555] hi", new SmsChannel().send("555", "hi"));
    }

    @Test
    void pushChannelSend() 
    {
        assertEquals("[PUSH to dev1] hi", new PushChannel().send("dev1", "hi"));
    }
}