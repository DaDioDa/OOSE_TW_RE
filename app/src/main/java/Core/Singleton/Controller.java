package Core.Singleton;

import com.nini.menu.Menu;

import java.text.ParseException;

import Core.Strategy.Timer;

public class Controller {

    private static Controller instance = new Controller();
    Menu menu;

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
    }
    public void DessertBtnClick(int i) {
        System.out.println("Dessert Button " + i);
    }
    public void DrinkBtnClick(int i) {
        System.out.println("Drink Button " + i);
    }
    public void SoupBtnClick(int i) {
        System.out.println("Soup Button " + i);
    }

    public void getMenuFromDB() {
        final Timer t = new Timer();
        try
        {
            //change 這邊改成retrun menu
            t.check();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
