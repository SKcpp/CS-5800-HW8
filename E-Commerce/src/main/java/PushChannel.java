public class PushChannel implements NotificationChannel 
{
    @Override
    public String send(String recipient, String message) 
    {
        return "[PUSH to " + recipient + "] " + message;
    }
}