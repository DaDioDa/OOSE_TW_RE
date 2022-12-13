package Core.Decorator;

import Core.ChainofResponsibility.Handler;

public class AddOrder extends BaseOrder {
    private String name; //什麼主餐 or 甜點 or 湯 or 飲料 or 加麵 or 蛋
    private float price;

    OrderType type = null;

    public AddOrder(Order order, String name, float price, OrderType type)
    {
        super(order);
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public float getCost() {
        if(order != null) return price + this.order.getCost();
        else return price;

    }

    public String getName() {
        if(order != null) return this.order.getName() + "\n佐" + name;
        else return name;
    }

    @Override
    public void CallChain(Handler handler) {
        handler.CheckType(this.type, name);
        if (order == null) return;
        this.order.CallChain(handler);
    }
}
