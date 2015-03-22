package datastructure.bst;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnbalancedBinarySearchTreeTest {

    @Test
    public void whenInsertingNewValueInEmptyRootThenTheRootIsThatNode() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        unbalancedBinarySearchTree.insert(new Node(10));

        assertEquals(10, unbalancedBinarySearchTree.rootNode.getValue());
    }

    @Test
    public void whenInsertingNewValueInNonEmptyRootThenTheValueIsCorrectlyInserted() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        unbalancedBinarySearchTree.insert(new Node(10));
        unbalancedBinarySearchTree.insert(new Node(11));
        unbalancedBinarySearchTree.insert(new Node(31));
        unbalancedBinarySearchTree.insert(new Node(7));
        unbalancedBinarySearchTree.insert(new Node(9));
        unbalancedBinarySearchTree.insert(new Node(8));

        assertEquals(8, unbalancedBinarySearchTree.rootNode.getLeft().getRight().getLeft().getValue());
    }

    @Test
    public void whenInsertingAnExistingValueThenReplaceThatNode() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node = new Node(8);
        Node sameValueNode = new Node(8);

        unbalancedBinarySearchTree.insert(new Node(10));
        unbalancedBinarySearchTree.insert(new Node(11));
        unbalancedBinarySearchTree.insert(new Node(31));
        unbalancedBinarySearchTree.insert(new Node(7));
        unbalancedBinarySearchTree.insert(new Node(9));
        unbalancedBinarySearchTree.insert(node);
        unbalancedBinarySearchTree.insert(sameValueNode);

        assertEquals(sameValueNode.getValue(), unbalancedBinarySearchTree.rootNode.getLeft().getRight().getLeft().getValue());
    }

    @Test
    public void whenSearchingAnElementInRootThenReturnRoot() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node = new Node(10);
        unbalancedBinarySearchTree.insert(node);

        assertEquals(node, unbalancedBinarySearchTree.search(10));
    }


    @Test
    public void whenSearchingAnElementInThenReturnCorrectNode() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node31 = new Node(31);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node8 = new Node(8);

        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node31);
        unbalancedBinarySearchTree.insert(node7);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node8);

        assertEquals(node8, unbalancedBinarySearchTree.search(8));
    }

    @Test
    public void whenSearchingANonExistingElementInThenReturnNull() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node31 = new Node(31);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node8 = new Node(8);

        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node31);
        unbalancedBinarySearchTree.insert(node7);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node8);

        assertEquals(null, unbalancedBinarySearchTree.search(14));
    }

    @Test
    public void whenDeletingNonExistingValueThenReturnFalse() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        unbalancedBinarySearchTree.insert(node10);

        assertEquals(false, unbalancedBinarySearchTree.delete(11));
    }

    @Test
    public void whenDeletingARootWithNoSubtreesThenRootNodeShouldBeNull() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        unbalancedBinarySearchTree.insert(node10);

        assertEquals(true, unbalancedBinarySearchTree.delete(10));
        assertEquals(null, unbalancedBinarySearchTree.rootNode);
    }

    @Test
    public void whenDeletingARootWithLeftSubtreeThenRootNodeShouldBeTheSubtree() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node7);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node8);

        assertEquals(true, unbalancedBinarySearchTree.delete(10));
        assertEquals(node7, unbalancedBinarySearchTree.rootNode);
    }

    @Test
    public void whenDeletingARootWithRightSubtreeThenRootNodeShouldBeTheSubtree() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node13 = new Node(13);
        Node node12 = new Node(12);
        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node13);
        unbalancedBinarySearchTree.insert(node12);

        assertEquals(true, unbalancedBinarySearchTree.delete(10));
        assertEquals(node11, unbalancedBinarySearchTree.rootNode);
    }

    @Test
    public void whenDeletingARootWithTwoSubtreesThenRootNodeShouldBeBiggestElementInLeftSubtreeAndBiggestSubtreeParentHasItsChildren() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node7);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node8);
        Node node11 = new Node(11);
        Node node13 = new Node(13);
        Node node12 = new Node(12);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node13);
        unbalancedBinarySearchTree.insert(node12);

        assertEquals(true, unbalancedBinarySearchTree.delete(10));
        assertEquals(9, unbalancedBinarySearchTree.rootNode.getValue());
        assertEquals(node8, unbalancedBinarySearchTree.rootNode.getLeft().getRight());
    }

    @Test
    public void whenDeletingANodeWithNoSubtreesThenTheirParentsReferenceToItShouldBeNull() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node10 = new Node(10);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node7);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node8);

        assertEquals(true, unbalancedBinarySearchTree.delete(8));
        assertEquals(null, unbalancedBinarySearchTree.rootNode.getLeft().getRight().getLeft());
    }

    @Test
    public void whenDeletingANodeWithOneSubtreeThenTheirParentsReferenceToItShouldBeTheChildOfTheDeletedNode() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();
        Node node15 = new Node(15);
        Node node12 = new Node(12);
        Node node9 = new Node(9);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        unbalancedBinarySearchTree.insert(node15);
        unbalancedBinarySearchTree.insert(node12);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node10);

        assertEquals(true, unbalancedBinarySearchTree.delete(11));
        assertEquals(node10, unbalancedBinarySearchTree.rootNode.getLeft().getLeft().getRight());
    }

    @Test
    public void whenDeletingANodeWithTwoSubtreesThenTheirParentsReferenceToItShouldBeBiggestElementInLeftSubtreeAndBiggestSubtreeParentHasItsChildren() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();

        Node node20 = new Node(20);
        Node node22 = new Node(22);
        Node node15 = new Node(15);
        Node node16 = new Node(16);
        Node node18 = new Node(18);
        Node node8 = new Node(8);
        Node node10 = new Node(10);
        Node node4 = new Node(4);
        Node node9 = new Node(9);
        Node node12 = new Node(12);
        Node node11 = new Node(11);
        Node node2 = new Node(2);

        unbalancedBinarySearchTree.insert(node20);
        unbalancedBinarySearchTree.insert(node22);
        unbalancedBinarySearchTree.insert(node15);
        unbalancedBinarySearchTree.insert(node16);
        unbalancedBinarySearchTree.insert(node18);
        unbalancedBinarySearchTree.insert(node8);
        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node4);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node12);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node2);

        //current position of 12 is rightly inserted
        assertEquals(12, unbalancedBinarySearchTree.rootNode.getLeft().getLeft().getRight().getRight().getValue());

        assertEquals(true, unbalancedBinarySearchTree.delete(15));
        assertEquals(12, unbalancedBinarySearchTree.rootNode.getLeft().getValue());
    }

    @Test
    public void whenPrintingElementsOrderedThenReturnCorrectString() {
        UnbalancedBinarySearchTree unbalancedBinarySearchTree = new UnbalancedBinarySearchTree();

        Node node20 = new Node(20);
        Node node22 = new Node(22);
        Node node15 = new Node(15);
        Node node16 = new Node(16);
        Node node18 = new Node(18);
        Node node8 = new Node(8);
        Node node10 = new Node(10);
        Node node4 = new Node(4);
        Node node9 = new Node(9);
        Node node12 = new Node(12);
        Node node11 = new Node(11);
        Node node2 = new Node(2);

        unbalancedBinarySearchTree.insert(node20);
        unbalancedBinarySearchTree.insert(node22);
        unbalancedBinarySearchTree.insert(node15);
        unbalancedBinarySearchTree.insert(node16);
        unbalancedBinarySearchTree.insert(node18);
        unbalancedBinarySearchTree.insert(node8);
        unbalancedBinarySearchTree.insert(node10);
        unbalancedBinarySearchTree.insert(node4);
        unbalancedBinarySearchTree.insert(node9);
        unbalancedBinarySearchTree.insert(node12);
        unbalancedBinarySearchTree.insert(node11);
        unbalancedBinarySearchTree.insert(node2);

        assertEquals("2,4,8,9,10,11,12,15,16,18,20,22,", unbalancedBinarySearchTree.printElementsOrdered());
    }
}