package amex.assignment.restapi.model;

import java.util.List;

public class OrderList {
    private static List<Order> orderList;

    public OrderList() {
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(List<Order> list) {
        orderList = list;
    }
}
