package amex.assignment.restapi.controller;


import amex.assignment.restapi.model.Order;
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

}
