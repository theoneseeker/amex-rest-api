package amex.assignment.restapi.controller;

import amex.assignment.restapi.model.Order;

import java.util.List;

public class OrderListDto {

    private List<Order> orderList;

    public OrderListDto(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
