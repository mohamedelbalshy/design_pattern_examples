package CommandPattern;

import java.util.ArrayList;
import java.util.List;

interface Order {
    void execute();
}

class Stock {
    private String name = "ABC";
    private int quantity = 10;

    Stock() {

    }

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

class SellOrder implements Order {
    private Stock stock;

    SellOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();

    }
}

class BuyOrder implements Order {
    private Stock stock;

    BuyOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();

    }
}

class Broker {
    private List<Order> orders = new ArrayList<Order>();

    void takeOrder(Order order) {
        orders.add(order);
    }

    public void placeOrders() {
        for (Order order : orders) {
            order.execute();
        }
        orders.clear();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Stock abc = new Stock();
        Order sellOrder = new SellOrder(abc);
        Order buyOrder = new BuyOrder(abc);

        Broker broker = new Broker();
        broker.takeOrder(buyOrder);
        broker.takeOrder(buyOrder);
        broker.takeOrder(sellOrder);
        broker.placeOrders();
    }
}
