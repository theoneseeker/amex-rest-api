package amex.assignment.restapi.model;

public class Order {
    private int id;

    private Item[] itemList;

    public Order(int id, Item[] itemList) {
        this.id = id;
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public void setItemList(Item[] itemList) {
        this.itemList = itemList;
    }
}
