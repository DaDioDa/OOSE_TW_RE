package com.nini.menu;

import org.junit.Test;
import static org.junit.Assert.*;

import Core.ChainofResponsibility.ChefHandler;
import Core.ChainofResponsibility.DessertHandler;
import Core.ChainofResponsibility.DrinkHandler;
import Core.Composite.Folder;
import Core.Composite.Item;
import Core.Decorator.OrderType;
import Core.Singleton.Controller;

public class ControllerTest {

    @Test
    public void test_MenuBtnClick_v() {
        Controller controller = Controller.getInstance();
        fragmentMain fragmentMain = new fragmentMain();

        controller.MenuBtnClick(fragmentMain,6);
        assertEquals(6,controller.getIndex());
        assertEquals(OrderType.MainDish,controller.getOrderType());
    }

    @Test
    public void test_MenuBtnClick_iv()
    {
        Controller controller = Controller.getInstance();
        fragmentNotyet fragmentNotyet = new fragmentNotyet();

        controller.MenuBtnClick(fragmentNotyet,6);
        assertEquals(999,controller.getIndex());
        assertNull(controller.getOrderType());
    }


    @Test
    public void test_getTableName()
    {
        Controller controller = Controller.getInstance();

        controller.GetTable(1);
        assertEquals("A1",controller.getTableName());
        controller.GetTable(-1);
        assertEquals("桌號不存在",controller.getTableName());
        controller.GetTable(999);
        assertEquals("桌號不存在",controller.getTableName());
    }

    @Test
    public void test_getMenu()
    {
        Controller controller = Controller.getInstance();
        Folder root = new Folder("root");
        Folder folder = new Folder("MainDish");
        Folder folder1 = new Folder("Soup");
        Folder folder2 = new Folder("Dessert");
        Folder folder3 = new Folder("Drink");
        root.add(folder);
        root.add(folder1);
        root.add(folder2);
        root.add(folder3);

        controller.setMenu(root);
        //path 1
        assertEquals(folder,controller.getMenu(OrderType.MainDish));
        //path 2
        assertEquals(folder1,controller.getMenu(OrderType.Soup));
        //path 3
        assertEquals(folder2,controller.getMenu(OrderType.Dessert));
        //path 4
        assertEquals(folder3,controller.getMenu(OrderType.Drink));
    }

    @Test
    public void test_PlaceOrder(){
        Folder root = new Folder("root");
        Folder folder = new Folder("MainDish");
        Folder folder1 = new Folder("Soup");
        Folder folder2 = new Folder("Dessert");
        Folder folder3 = new Folder("Drink");
        Core.Composite.Menu m1_It1 = new Item("唐揚雞",150.0f,OrderType.MainDish);
        Core.Composite.Menu m1_It2 = new Item("炙燒雞腿",180.0f,OrderType.MainDish);
        Core.Composite.Menu m2_It1 = new Item("玉米巧達濃湯",50.0f,OrderType.MainDish);
        Core.Composite.Menu m2_It2 = new Item("杏鮑菇南瓜濃湯",50.0f,OrderType.MainDish);
        Core.Composite.Menu m4_It1 = new Item("拿鐵",50.0f,OrderType.Drink);
        Core.Composite.Menu m4_It2 = new Item("纖盈香草茶",60.0f,OrderType.Drink);
        Core.Composite.Menu m3_It1 = new Item("經典提拉米蘇",60.0f,OrderType.Dessert);
        Core.Composite.Menu m3_It2 = new Item("草莓奶酪",80.0f,OrderType.Dessert);

        Controller controller = Controller.getInstance();
    }
}
