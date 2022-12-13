package Core.Decorator;

import Core.ChainofResponsibility.Handler;

public class BaseOrder implements Order{
    Order order;
    private String name; //什麼主餐 or 甜點 or 湯 or 飲料 or 加麵 or 蛋
    private float price;

    public BaseOrder(Order order)
    {
        this.order = order;
    }
    public float getCost()
    {
        return price;
    }
    public String getName()
    {
        return name;
    }

    @Override
    public void CallChain(Handler handler) {
        if (order == null) return;
        handler.CheckType(this.type, name);
    }


}
