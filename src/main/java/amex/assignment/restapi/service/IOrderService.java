package amex.assignment.restapi.service;

import amex.assignment.restapi.model.Order;
import amex.assignment.restapi.model.OrderSummary;

public interface IOrderService {
    public OrderSummary createSummary(Order order);
    public void createOrder(Order order);
    public Order getOrder(int orderId);
    void initializeData();
}
