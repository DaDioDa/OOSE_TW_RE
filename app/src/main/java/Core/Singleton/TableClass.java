package Core.Singleton;

import java.util.ArrayList;

import Core.Builder.Product;

public class TableClass {
    ArrayList<Product> order = new ArrayList<Product>();

    public float getTotalPrice()
    {
        float total = 0;
        for(int i = 0; i < order.size(); i++)
        {
            total += order.get(i).getCost();
        }
        return total;
    }
}
