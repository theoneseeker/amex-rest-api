package amex.assignment.restapi.service;

import amex.assignment.restapi.model.Item;
import amex.assignment.restapi.model.Order;
import amex.assignment.restapi.model.OrderSummary;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    public OrderSummary createSummary(Order order){
        float totalCost = 0;
        Item[] itemArr = order.getItemList();
        for(int i = 0; i < itemArr.length; i++){
            totalCost += itemArr[i].calcCost();
        }
        return new OrderSummary(totalCost, itemArr);
    }
}
