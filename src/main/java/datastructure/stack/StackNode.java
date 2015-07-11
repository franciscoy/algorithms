package datastructure.stack;

/**
 * Created by Francisco Yllera.
 */
public class StackNode<Item> {
    StackNode prev;
    Item item;

    public StackNode getPrev() {
        return prev;
    }

    public void setPrev(StackNode prev) {
        this.prev = prev;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}