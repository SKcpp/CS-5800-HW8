public class RestaurantDriver 
{
    public static void main(String[] args) 
    {
        Order order = new Order();
        order.addItem(new Cheese(new Ketchup(new Burger())));
        order.addItem(new Onions(new HotDog()));
        order.addItem(new Fries());

        System.out.println("=== Order ===");
        for (String line : order.describe()) 
        {
            System.out.println(line);
        }
        double total = order.getTotal();
        System.out.printf("Subtotal: $%.2f%n", total);

        System.out.println("\n=== Loyalty discounts ===");
        for (LoyaltyStatus.Level level : LoyaltyStatus.Level.values()) 
        {
            double discounted = new LoyaltyStatus(level).applyDiscount(total);
            System.out.printf("%s member total: $%.2f%n", level, discounted);
        }
    }
}