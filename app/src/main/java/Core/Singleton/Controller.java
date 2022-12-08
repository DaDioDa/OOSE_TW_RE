package Core.Singleton;

public class Controller {

    private static Controller instance = new Controller();

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
}
