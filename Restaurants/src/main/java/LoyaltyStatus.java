import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoyaltyStatus 
{
    public enum Level 
    {
        NONE(0.00), 
        SILVER(0.05), 
        GOLD(0.10);

        private final double rate;

        Level(double rate) 
        {
            this.rate = rate;
        }

        public double getRate() 
        {
            return rate;
        }
    }

    private final Level level;

    public LoyaltyStatus() {
        this(Level.NONE);
    }

    public LoyaltyStatus(Level level) {
        this.level = level;
    }

    public static LoyaltyStatus fromName(String name) 
    {
        try 
        {
            return new LoyaltyStatus(Level.valueOf(name.trim().toUpperCase()));
        } 
        catch (IllegalArgumentException e) 
        {
            throw new IllegalArgumentException("Unknown loyalty status: " + name);
        }
    }

    public Level getLevel() 
    {
        return level;
    }

    public double getDiscountRate() 
    {
        return level.getRate();
    }

    public double applyDiscount(double total) 
    {
        BigDecimal factor = BigDecimal.ONE.subtract(BigDecimal.valueOf(level.getRate()));
        return BigDecimal.valueOf(total).multiply(factor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}