package amex.assignment.restapi.controller;

import amex.assignment.restapi.model.Item;

public class OrderDto {
    private int id;
    private Item[] itemArr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item[] getItemArr() {
        return itemArr;
    }

    public void setItemArr(Item[] itemArr) {
        this.itemArr = itemArr;
    }
}
