import java.util.ArrayList;
import java.util.List;

public class Order 
{
    private final List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) 
    {
        items.add(item);
    }

    public List<FoodItem> getItems() 
    {
        return items;
    }

    public double getTotal() 
    {
        double total = 0;
        for (FoodItem item : items) 
        {
            total += item.getCost();
        }
        return total;
    }

    public List<String> describe() 
    {
        List<String> lines = new ArrayList<>();
        for (FoodItem item : items) 
        {
            lines.add(String.format("%s: $%.2f", item.getDescription(), item.getCost()));
        }
        return lines;
    }
}