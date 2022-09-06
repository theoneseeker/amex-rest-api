package amex.assignment.restapi.controller;


import amex.assignment.restapi.model.Order;
import amex.assignment.restapi.model.OrderList;
import amex.assignment.restapi.model.OrderSummary;
import amex.assignment.restapi.service.IOrderService;
import amex.assignment.restapi.util.mapping.IDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class OrderController {

    private final IOrderService orderService;
    private final IDtoMapper dtoMapper;


    public OrderController(IOrderService orderService,IDtoMapper dtoMapper) {
        this.orderService = orderService;
        this.dtoMapper = dtoMapper;
    }

    /**
     * Endpoint for getting order summary information
     * @return the order summary reflecting the incoming order
     */
    @ResponseStatus
    @PostMapping("/orders")
    public ResponseEntity<OrderSummaryDto> create(@RequestBody OrderDto orderDTO){
        Order order = dtoMapper.convertToEntity(orderDTO);
        OrderSummary summary = orderService.createSummary(order);
        OrderSummaryDto summaryDto = dtoMapper.converToDto(summary);
        return new ResponseEntity<>(summaryDto, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving an order
     * @param orderId of the order
     * @return orderDto reflecting the order
     */
    @GetMapping("/orders/{orderId}/order")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("orderId") int orderId) {
        orderService.initializeData();
        Order order = orderService.getOrder(orderId);
        OrderDto orderDto = dtoMapper.convertToDto(order);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving all orders
     * @return returns an orderListDto with a list of all orders
     */
    @GetMapping("orders")
    public ResponseEntity<OrderListDto> getOrders(){
        orderService.initializeData();
        OrderListDto orderListDto = dtoMapper.converToDto();
        return new ResponseEntity<>(orderListDto, HttpStatus.OK);
    }

}
