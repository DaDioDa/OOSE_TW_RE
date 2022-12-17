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
}
