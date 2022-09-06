package amex.assignment.restapi.service;

import amex.assignment.restapi.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Override
    public OrderSummary createSummary(Order order){
        float totalCost = 0;
        Item[] itemArr = order.getItemList();
        for(int i = 0; i < itemArr.length; i++){
            totalCost += itemArr[i].calcCost();
        }
        return new OrderSummary(totalCost, itemArr);
    }
    @Override
    public void createOrder(Order order){
        if(OrderList.getOrderList().isEmpty()){
            order.setId(0);
        }
        else order.setId(OrderList.getOrderList().size()-1);
        OrderList.getOrderList().add(order);

    }
    @Override
    public Order getOrder(int orderId){
        for(Order order : OrderList.getOrderList()){
            if(order.getId() == orderId) return order;
        }
        return OrderList.getOrderList().get(0);
    }

    @Override
    public void initializeData() {
        Apple apple = new Apple("apple",5);
        Orange orange = new Orange("orange",3);

        Item items[] = new Item[1];
        items[0] = apple;

        Item items2[] = new Item[2];
        items2[0] = apple;
        items2[1] = orange;

        Order order = new Order(0,items);
        Order order2 = new Order(1, items2);

        List<Order> list = new ArrayList<>();
        list.add(order);
        list.add(order2);
        OrderList.setOrderList(list);
    }
}
