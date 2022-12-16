package Core.Singleton;

import java.util.ArrayList;

import Core.Builder.Product;
import Core.Decorator.Order;

public class TableClass {
    ArrayList<Order> order = new ArrayList<Order>();
    String TableName;
    public TableClass(String name)
    {
        TableName = name;
    }
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

    public String getFullOrder() {
        String fullOrder = "";
        for(int i = 0; i < order.size(); i++) {
            fullOrder += order.get(i).getName() + "\n" + order.get(i).getCost() + "\n";
        }
        return fullOrder;
    }

    public void Clear() {
        order.clear();
    }
}
