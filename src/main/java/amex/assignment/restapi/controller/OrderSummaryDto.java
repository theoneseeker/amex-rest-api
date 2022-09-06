package amex.assignment.restapi.controller;

import amex.assignment.restapi.model.Item;

public class OrderSummaryDto {
    private float orderTotal;
    private Item[] itemArr;

    public OrderSummaryDto(float orderTotal, Item[] itemArr){
        this.orderTotal = orderTotal;
        this.itemArr = itemArr;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Item[] getItemArr() {
        return itemArr;
    }

    public void setItemArr(Item[] itemArr) {
        this.itemArr = itemArr;
    }
}
