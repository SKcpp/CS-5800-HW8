public class Cheese extends ToppingDecorator 
{
    public Cheese(FoodItem item) 
    {
        super(item);
    }

    @Override
    protected String getToppingName() 
    {
        return "Cheese";
    }

    @Override
    protected double getToppingPrice() 
    {
        return 0.75;
    }
}