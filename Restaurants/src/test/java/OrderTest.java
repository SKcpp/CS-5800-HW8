import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderTest 
{

    @Test
    void emptyOrderTotalIsZero() 
    {
        assertEquals(0.0, new Order().getTotal(), 0.0001);
    }

    @Test
    void addItemAndGetItems() 
    {
        Order order = new Order();
        order.addItem(new Burger());
        assertEquals(1, order.getItems().size());
    }

    @Test
    void getTotalSumsItemsAndToppings() 
    {
        Order order = new Order();
        order.addItem(new Cheese(new Burger()));
        order.addItem(new Fries());
        assertEquals(8.25, order.getTotal(), 0.0001);
    }

    @Test
    void describeListsEachItemWithCost() 
    {
        Order order = new Order();
        order.addItem(new Fries());
        List<String> lines = order.describe();
        assertEquals(List.of("Fries: $2.50"), lines);
    }
}