import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FoodItemTest 
{

    @Test
    void burger() 
    {
        assertEquals(5.00, new Burger().getCost(), 0.0001);
        assertEquals("Burger", new Burger().getDescription());
    }

    @Test
    void fries() 
    {
        assertEquals(2.50, new Fries().getCost(), 0.0001);
        assertEquals("Fries", new Fries().getDescription());
    }

    @Test
    void hotDog() 
    {
        assertEquals(3.50, new HotDog().getCost(), 0.0001);
        assertEquals("Hot Dog", new HotDog().getDescription());
    }
}