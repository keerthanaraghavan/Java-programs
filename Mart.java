package Activities;
import java.util.*;
class ShoppingCart {
    private List<Item> items;
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    public void addItem(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }
    public void removeItem(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.remove(item);
        }
    }
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
public class Mart{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        //adding items to the cart
        System.out.println("Enter item name to 'add' or'remove'to finish:");
        String itemName;
        while (!(itemName = scanner.nextLine()).equals("remove")) {
            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Item item = new Item(itemName, price);
            cart.addItem(item, quantity);
            System.out.println("Item added. Enter next item to 'add' or'remove'to finish:");
        }
        // Removing items from the cart
        System.out.println("Enter item name to 'remove' or 'remove' to finish :");
        while (!(itemName = scanner.nextLine()).equals("remove")) {
            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Item item = new Item(itemName, 0); 
            cart.removeItem(item, quantity);
            System.out.println("Item removed. Enter next item or'remove' to finish:");
        }
        // Calculate total price
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total Price: " + totalPrice);
        scanner.close();
    }
}


