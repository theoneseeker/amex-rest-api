package amex.assignment.restapi.util.mapping;

import amex.assignment.restapi.controller.OrderDto;
import amex.assignment.restapi.controller.OrderListDto;
import amex.assignment.restapi.controller.OrderSummaryDto;
import amex.assignment.restapi.model.Order;
import amex.assignment.restapi.model.OrderSummary;

public interface IDtoMapper{

    Order convertToEntity(OrderDto orderDTO);

    OrderSummaryDto converToDto(OrderSummary orderSummary);

    OrderDto convertToDto(Order order);

    OrderListDto converToDto();
}
