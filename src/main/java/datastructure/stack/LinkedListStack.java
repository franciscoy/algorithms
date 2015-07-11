package datastructure.stack;

import java.util.NoSuchElementException;

/**
 * Created by Francisco Yllera.
 */
public class LinkedListStack<Item> implements Stack<Item> {

    private StackNode lastElement = null;

    @Override
    public boolean isEmpty() {
        return lastElement == null;
    }

    public void push(Item item) {
        StackNode prevNode = lastElement;
        lastElement = new StackNode();
        lastElement.setItem(item);
        lastElement.setPrev(prevNode);
    }

    public Item pop() {
        if (lastElement == null) {
            throw new NoSuchElementException("No elements in the stack");
        }

        Item item = (Item) lastElement.getItem();
        lastElement = lastElement.getPrev();
        return item;
    }
}