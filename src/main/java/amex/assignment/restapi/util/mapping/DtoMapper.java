package amex.assignment.restapi.util.mapping;

import amex.assignment.restapi.controller.OrderDto;
import amex.assignment.restapi.controller.OrderListDto;
import amex.assignment.restapi.controller.OrderSummaryDto;
import amex.assignment.restapi.model.Order;
import amex.assignment.restapi.model.OrderList;
import amex.assignment.restapi.model.OrderSummary;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper implements IDtoMapper {

    public Order convertToEntity(OrderDto orderDTO) {
        return new Order(orderDTO.getId(), orderDTO.getItemArr());
    }

    public OrderSummaryDto converToDto(OrderSummary orderSummary){
        return new OrderSummaryDto(orderSummary.getOrderTotal(), orderSummary.getItemArr());
    }

    public OrderDto convertToDto(Order order){
        OrderDto orderDto = new OrderDto(order.getId(), order.getItemList());
        return new OrderDto(order.getId(), order.getItemList());
    }

    public OrderListDto converToDto(){
        OrderListDto orderListDto = new OrderListDto(OrderList.getOrderList());
        return orderListDto;
    }
}
