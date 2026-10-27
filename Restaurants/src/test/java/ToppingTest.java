import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ToppingTest 
{

    @Test
    void ketchup() 
    {
        FoodItem item = new Ketchup(new Burger());
        assertEquals(5.25, item.getCost(), 0.0001);
        assertEquals("Burger + Ketchup", item.getDescription());
    }

    @Test
    void cheese() 
    {
        FoodItem item = new Cheese(new Fries());
        assertEquals(3.25, item.getCost(), 0.0001);
        assertEquals("Fries + Cheese", item.getDescription());
    }

    @Test
    void onions() 
    {
        FoodItem item = new Onions(new HotDog());
        assertEquals(4.00, item.getCost(), 0.0001);
        assertEquals("Hot Dog + Onions", item.getDescription());
    }

    @Test
    void stackedToppings() 
    {
        FoodItem item = new Onions(new Cheese(new Ketchup(new Burger())));
        assertEquals(6.50, item.getCost(), 0.0001);
        assertEquals("Burger + Ketchup + Cheese + Onions", item.getDescription());
    }

    @Test
    void getItemReturnsWrappedItem() 
    {
        FoodItem base = new Burger();
        assertSame(base, new Ketchup(base).getItem());
    }
}