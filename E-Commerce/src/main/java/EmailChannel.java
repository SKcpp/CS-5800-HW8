public class EmailChannel implements NotificationChannel 
{
    @Override
    public String send(String recipient, String message) 
    {
        return "[EMAIL to " + recipient + "] " + message;
    }
}