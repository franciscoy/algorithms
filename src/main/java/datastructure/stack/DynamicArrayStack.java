package datastructure.stack;

import java.util.NoSuchElementException;

/**
 * Created by Francisco Yllera.
 */
public class DynamicArrayStack<Item> implements Stack<Item> {

    private Item[] items = null;
    private int cursor = 0;
    private static final int DEFAULT_SIZE = 12;

    public DynamicArrayStack() {
        items = (Item[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    @Override
    public Item pop() {
        if (cursor == 0) {
            throw new NoSuchElementException("No elements in the stack");
        }

        Item item = items[cursor - 1];
        cursor--;

        if (cursor > 0 && cursor == items.length/4) {
            resize(items.length/2);
        }
        return item;
    }

    @Override
    public void push(Item item) {
        if (cursor == items.length) {
            resize(items.length * 2);
        }

        items[cursor] = item;
        cursor++;
    }

    private void resize(int size) {
        //if resize to bigger array, copy all elements from small array
        //if done to shrink the array, copy half of the new size
        int scanIndex = (size < items.length) ? size / 2 : items.length;
        Item[] newArray = (Item[]) new Object[size];

        for (int i = 0; i < scanIndex; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }
}