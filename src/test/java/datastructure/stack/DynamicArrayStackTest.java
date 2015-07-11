package datastructure.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicArrayStackTest extends StackTest{

    @Override
    public Stack getStack() {
        return new DynamicArrayStack();
    }

    @Test
    public void whenArrayIsBigResizeCorrectly() {
        Stack stack = getStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");
        stack.push("k");
        stack.push("l");
        stack.push("m");

        assertEquals("m", stack.pop());
        assertEquals("l", stack.pop());
        assertEquals("k", stack.pop());
        assertEquals("j", stack.pop());
        assertEquals("i", stack.pop());
        assertEquals("h", stack.pop());
        assertEquals("g", stack.pop());
        assertEquals("f", stack.pop());
        assertEquals("e", stack.pop());
        assertEquals("d", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
    }

    @Test
    public void whenResizingMultipleTimesThenShouldWorkCorrectly() {
        Stack stack = getStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");
        stack.push("k");
        stack.push("l");
        stack.push("m");

        assertEquals("m", stack.pop());
        assertEquals("l", stack.pop());
        assertEquals("k", stack.pop());
        assertEquals("j", stack.pop());
        assertEquals("i", stack.pop());
        assertEquals("h", stack.pop());
        assertEquals("g", stack.pop());
        assertEquals("f", stack.pop());
        assertEquals("e", stack.pop());
        assertEquals("d", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());

        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");
        stack.push("j");
        stack.push("k");
        stack.push("l");
        stack.push("m");

        assertEquals("m", stack.pop());
        assertEquals("l", stack.pop());
        assertEquals("k", stack.pop());
        assertEquals("j", stack.pop());
        assertEquals("i", stack.pop());
        assertEquals("h", stack.pop());
        assertEquals("g", stack.pop());
        assertEquals("f", stack.pop());
        assertEquals("e", stack.pop());
        assertEquals("d", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
    }
}