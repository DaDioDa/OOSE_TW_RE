package Core.Singleton;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.nini.menu.fragmentAlready;
import com.nini.menu.fragmentDessert;
import com.nini.menu.fragmentDrinks;
import com.nini.menu.fragmentMain;
import com.nini.menu.fragmentNotyet;
import com.nini.menu.fragmentSoup;

import java.text.ParseException;
import java.util.Objects;

import Core.Builder.CreamNoodleBuilder;
import Core.Builder.Director;
import Core.Builder.MMBuilder;
import Core.Builder.PestoNoodleBuilder;
import Core.Builder.TomatoNoodleBuilder;
import Core.ChainofResponsibility.ChefHandler;
import Core.ChainofResponsibility.DessertHandler;
import Core.ChainofResponsibility.DrinkHandler;
import Core.ChainofResponsibility.Handler;
import Core.Composite.Menu;
import Core.Decorator.AddOrder;
import Core.Decorator.Order;
import Core.Decorator.OrderType;
import Core.Strategy.Timer;

public final class Controller {

    private final static Controller instance = new Controller();
    Core.Composite.Menu menu;
    public boolean DB_OK = false;
    Order product;
    int i_main = 999, i_soup = 999, i_drink = 999, i_dessert = 999;
    TableClass[] table = {new TableClass("B1"), new TableClass("A1"), new TableClass("A2"), new TableClass("B2"), new TableClass("A3"), new TableClass("A4"), new TableClass("C1"), new TableClass("A5"), new TableClass("A6")};
    int tmpTable = 0;
    public boolean isSet = false;

    String sauce;

    //refactor
    public fragmentNotyet notyet;
    public fragmentAlready already;
    public com.nini.menu.Menu menuActivity;
    //refactor

    int index = 999;
    OrderType orderType;

    public void setSauce(String s)
    {
        sauce = s;
    }
    public String getTableName()
    {
        return table[tmpTable].TableName;
    }
    public float getTablePrice()
    {
        return table[tmpTable].getTotalPrice();
    }
    private Controller(){}
    public static Controller getInstance()
    {
        return instance;
    }
    public void MenuBtnClick(Fragment fragment,int i)
    {
        if(isSet)
        {
            if(fragment instanceof fragmentMain)
            {
                i_main = i;
            }
            else if(fragment instanceof fragmentSoup)
            {
                i_soup = i;
            }
            else if(fragment instanceof fragmentDrinks)
            {
                i_drink = i;
            }
            else if(fragment instanceof fragmentDessert)
            {
                i_dessert = i;
            }
            notyet.SetName();
        }
        else
        {
            if(fragment instanceof fragmentMain)
            {
                index = i;
                orderType = OrderType.MainDish;
            }
            else if(fragment instanceof fragmentSoup)
            {
                index = i;
                orderType = OrderType.Soup;
            }
            else if(fragment instanceof fragmentDrinks)
            {
                index = i;
                orderType = OrderType.Drink;
            }
            else if(fragment instanceof fragmentDessert)
            {
                index = i;
                orderType = OrderType.Dessert;
            }
            notyet.SingleName();
        }
    }

    public int[] getSetIndex()
    {
        int[] index = {i_main, i_soup, i_drink, i_dessert};
        return index;
    }

    public int getIndex()
    {
        return index;
    }
    public OrderType getOrderType()
    {
        return orderType;
    }

    public void PlaceOrder()
    {
        if(!isSet)
        {
            if(index == 999)
            {
                menuActivity.badToast();
                return;
            }
            if(sauce != null && orderType == OrderType.MainDish)
            {
                buildSause();
            }
            product = new AddOrder(product, menu.getChildren().get(orderType.ordinal()).getChildren().get(index).getName(),
                                            menu.getChildren().get(orderType.ordinal()).getChildren().get(index).getPrice(),
                                            orderType);
        }
        else
        {
            if(i_main == 999 || i_soup == 999 || i_drink == 999 || i_dessert == 999)
            {
                menuActivity.badToast();
                return;
            }
            buildSause();
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
        }
        System.out.println(product.getName());
        System.out.print(product.getCost() + "$\n");
        menuActivity.goodToast();
        table[tmpTable].AddOrder(product);
        SendCOR(product);
        product = null;
        ResetIndex();
        notyet.Clear();
        already.setText(table[tmpTable].getFullOrder());
    }

    private void buildSause() {
        if(sauce == null)
        {
            return;
        }
        if(Objects.equals(sauce, "??????"))
        {
            MMBuilder tomatonoodle = new TomatoNoodleBuilder();
            Director director = new Director(tomatonoodle);
            director.makeProduct();
            product = director.getProduct();
        }
        else if(Objects.equals(sauce, "??????"))
        {
            MMBuilder pestoSause = new PestoNoodleBuilder();
            Director director = new Director(pestoSause);
            director.makeProduct();
            product = director.getProduct();
        }
        else if(Objects.equals(sauce, "??????"))
        {
            MMBuilder whiteSause = new CreamNoodleBuilder();
            Director director = new Director(whiteSause);
            director.makeProduct();
            product = director.getProduct();
        }
        sauce = null;
    }

    public void SendCOR(Order product)
    {
        Handler handler = new ChefHandler(
                new DessertHandler(
                        new DrinkHandler(null)
                )
        );

        handler.execute(product);
    }


    public void ResetIndex()
    {
        index = 999;
        i_main = 999;
        i_soup = 999;
        i_dessert = 999;
        i_drink = 999;
    }

    public void getMenuFromDB() {
        final Timer t = new Timer();
        try
        {
            t.check();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public void CheckOut()
    {
        System.out.println(table[tmpTable].getTotalPrice());
    }

    public void setMenu(Core.Composite.Menu m)
    {
        menu = m;
    }
    public void GetTable(int i)
    {
        tmpTable = i;
    }
    public Menu getMenu(OrderType type) {
        switch (type) {
            case MainDish:
                return menu.getChildren().get(type.ordinal());
            case Soup:
                return menu.getChildren().get(type.ordinal());
            case Dessert:
                return menu.getChildren().get(type.ordinal());
            case Drink:
                return menu.getChildren().get(type.ordinal());
            default:
                return null;
        }
    }

    public void ClearTable()
    {
        table[tmpTable].Clear();
    }

    public boolean isGetDataDone() {
        return DB_OK;
    }

    public void setAlreadyText()
    {
        already.setText(table[tmpTable].getFullOrder());
    }
}
