package datastructure.stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Francisco Yllera.
 */
public abstract class StackTest {

    public abstract Stack getStack();

    @Test
    public void whenStackIsEmptyAndCallIsEmptyThenReturnTrue() {
        Stack stack = getStack();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void whenStackIsNotEmptyAndCallIsEmptyThenReturnFalse() {
        Stack stack = getStack();
        stack.push("Hello");

        assertFalse(stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenStackIsEmptyAndPopThenThrowException() {
        Stack stack = getStack();
        stack.pop();
    }

    @Test
    public void whenPopElementsAreInOrder() {
        Stack stack = getStack();
        stack.push("Hello");
        stack.push("world");
        stack.push("!");

        assertEquals("!", stack.pop());
        assertEquals("world", stack.pop());
        assertEquals("Hello", stack.pop());
    }
}