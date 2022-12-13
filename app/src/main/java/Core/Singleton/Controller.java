package Core.Singleton;

import com.nini.menu.fragmentDessert;
import com.nini.menu.fragmentDrinks;
import com.nini.menu.fragmentMain;
import com.nini.menu.fragmentSoup;

import java.text.ParseException;

import Core.Builder.Director;
import Core.Builder.MMBuilder;
import Core.Builder.TomatoNoodleBuilder;
import Core.Composite.Menu;
import Core.Decorator.AddOrder;
import Core.Decorator.Order;
import Core.Decorator.OrderType;
import Core.Strategy.Timer;

public class Controller {

    private static Controller instance = new Controller();
    Core.Composite.Menu menu;
    public boolean DB_OK = false;
    Order product;
    int i_main, i_soup, i_drink, i_dessert;

    private Controller(){}
    public static Controller getInstance()
    {
        return instance;
    }
    public void Say()
    {
        System.out.println("This is my controller!");
    }
    public void MainBtnClick(int i) {
        System.out.println("Main Button " + i);
        i_main = i;
    }
    public void DessertBtnClick(int i) {
        System.out.println("Dessert Button " + i);
        i_dessert = i;
    }
    public void DrinkBtnClick(int i) {
        System.out.println("Drink Button " + i);
        i_drink = i;
    }
    public void SoupBtnClick(int i) {
        System.out.println("Soup Button " + i);
        i_soup = i;
    }

    public void PlaceOrder()
    {
        MMBuilder tomatonoodle = new TomatoNoodleBuilder();
        Director director = new Director(tomatonoodle);
        director.makeProduct();
        product = director.getProduct();
        product = new AddOrder(product, menu.getChildren().get(0).getChildren().get(i_main).getName(),
                                        menu.getChildren().get(0).getChildren().get(i_main).getPrice(),
                                        OrderType.MainDish);

        product = new AddOrder(product, menu.getChildren().get(1).getChildren().get(i_soup).getName(),
                                        menu.getChildren().get(1).getChildren().get(i_soup).getPrice(),
                                        OrderType.Soup);

        product = new AddOrder(product, menu.getChildren().get(2).getChildren().get(i_dessert).getName(),
                                        menu.getChildren().get(2).getChildren().get(i_dessert).getPrice(),
                                        OrderType.Dessert);

        product = new AddOrder(product, menu.getChildren().get(3).getChildren().get(i_drink).getName(),
                                        menu.getChildren().get(3).getChildren().get(i_drink).getPrice(),
                                        OrderType.Drink);

        System.out.println(product.getName());
        System.out.print(product.getCost() + "$\n");
    }

    public void getMenuFromDB() {
        final Timer t = new Timer();
        try
        {
            //change 這邊改成 retrun menu
            t.check();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public void setMenu(Core.Composite.Menu m)
    {
        menu = m;
    }

    public Menu getMenu(OrderType type) {
        switch (type) {
            case MainDish:
                return menu.getChildren().get(0);
            case Soup:
                return menu.getChildren().get(1);
            case Dessert:
                return menu.getChildren().get(2);
            case Drink:
                return menu.getChildren().get(3);
            default:
                return null;
        }
    }

    public boolean isGetDataDone() {
        return DB_OK;
    }
}
