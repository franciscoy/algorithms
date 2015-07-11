package datastructure.stack;

public class LinkedListStackTest extends StackTest {

    @Override
    public Stack getStack() {
        return new LinkedListStack();
    }
}