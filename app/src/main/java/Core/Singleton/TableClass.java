package Core.Singleton;

import java.util.ArrayList;

import Core.Builder.Product;
import Core.Decorator.Order;

public class TableClass {
    ArrayList<Order> order = new ArrayList<Order>();

    public float getTotalPrice()
    {
        float total = 0;
        for(int i = 0; i < order.size(); i++)
        {
            total += order.get(i).getCost();
        }
        return total;
    }

    public void AddOrder(Order product) {
        order.add(product);
    }
}
