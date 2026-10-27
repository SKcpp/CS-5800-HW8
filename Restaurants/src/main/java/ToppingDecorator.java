public abstract class ToppingDecorator implements FoodItem 
{
    protected final FoodItem item;

    protected ToppingDecorator(FoodItem item) 
    {
        this.item = item;
    }

    public FoodItem getItem() 
    {
        return item;
    }

    protected abstract String getToppingName();

    protected abstract double getToppingPrice();

    @Override
    public double getCost() 
    {
        return item.getCost() + getToppingPrice();
    }

    @Override
    public String getDescription() 
    {
        return item.getDescription() + " + " + getToppingName();
    }
}