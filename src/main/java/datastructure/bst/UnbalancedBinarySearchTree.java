package datastructure.bst;


/**
 * Created by Francisco Yllera.
 */
public class UnbalancedBinarySearchTree {

    protected Node rootNode;

    /**
     * Insert a node to the tree without balancing it.
     * If node exists, update.
     * O(height of the tree) -> O(n)
     * @param node
     */
    public void insert(Node node) {
        if (rootNode == null) {
            rootNode = node;
            return;
        }

        insertInNodeSubtree(rootNode, node);
    }

    private void insertInNodeSubtree(Node node, Node nodeToInsert) {
        if (nodeToInsert.getValue() == node.getValue()) {
            node.setValue(nodeToInsert.getValue());
        } else if (nodeToInsert.getValue() < node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(nodeToInsert);
            } else {
                insertInNodeSubtree(node.getLeft(), nodeToInsert);
            }
        }else  if (nodeToInsert.getValue() > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(nodeToInsert);
            } else {
                insertInNodeSubtree(node.getRight(), nodeToInsert);
            }
        }
    }

    /**
     * Search a node by its key.
     * O(height of the tree) -> O(n)
     * @param valueToSearch
     * @return Node or null
     */
    public Node search(int valueToSearch) {
        if (rootNode == null) {
            return null;
        }

        return searchInNodeSubtree(rootNode, valueToSearch);
    }

    private Node searchInNodeSubtree(Node node, int valueToSearch) {
        if (node.getValue() == valueToSearch) {
            return node;
        }else if (valueToSearch < node.getValue() && node.getLeft() != null) {
            return searchInNodeSubtree(node.getLeft(), valueToSearch);
        } else if (valueToSearch > node.getValue() && node.getRight() != null) {
            return searchInNodeSubtree(node.getRight(), valueToSearch);
        }
        return null;
    }

    /**
     * Delete a node from the tree
     * O(height of the tree) -> O(n)
     * @param valueToDelete
     * @return true if node deleted, false if not found
     */
    public boolean delete(int valueToDelete) {
        if (rootNode == null) {
            return false;
        }

        return deleteInNodeSubtree(rootNode, null, true, valueToDelete);
    }

    private boolean deleteInNodeSubtree(Node node, Node nodeParent, boolean leftPosition, int valueToDelete) {
        if (valueToDelete == node.getValue()) {
            int subtreesCount = countSubtrees(node);

            //First case, the node does not have any subtrees, just remove the reference to it
            if (subtreesCount == 0){
                if (nodeParent == null) {
                    this.rootNode = null;
                } else if(leftPosition) {
                    nodeParent.setLeft(null);
                } else {
                    nodeParent.setRight(null);
                }
            //Second case, the node has one subtree, replace the reference in the node parent with the node child
            } else if (subtreesCount == 1) {
                if (nodeParent == null) {
                    this.rootNode = (node.getLeft() != null) ? node.getLeft() : node.getRight();
                } else if (node.getLeft() != null) {
                    setNodeInParentByPosition(nodeParent, node.getLeft(), leftPosition);
                } else {
                    setNodeInParentByPosition(nodeParent, node.getRight(), leftPosition);
                }
            //Third case, the node has two subtrees
            // find the biggest element in the left subtree, replace values and delete that biggest node object
            } else {
                Node biggestNodeInSubtree = findBiggestNodeInSubtree(node.getLeft());
                delete(biggestNodeInSubtree.getValue());
                node.setValue(biggestNodeInSubtree.getValue());
            }

            return true;
        } else if (valueToDelete < node.getValue() && node.getLeft() != null) {
            return deleteInNodeSubtree(node.getLeft(), node, true, valueToDelete);
        } else if (valueToDelete > node.getValue() && node.getRight() != null) {
            return deleteInNodeSubtree(node.getRight(), node, false, valueToDelete);
        }

        return false;
    }

    private Node findBiggestNodeInSubtree(Node node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return findBiggestNodeInSubtree(node.getRight());
        }
    }

    private int countSubtrees(Node node) {
        int subtreesCount = 0;
        if (node.getRight() != null) {
            subtreesCount++;
        }
        if (node.getLeft() != null) {
            subtreesCount++;
        }

        return subtreesCount;
    }

    private void setNodeInParentByPosition(Node nodeParent, Node nodeToSet, boolean leftPosition) {
        if (leftPosition) {
            nodeParent.setLeft(nodeToSet);
        } else {
            nodeParent.setRight(nodeToSet);
        }
    }

    /**
     * Prints the elements of the tree ordered
     * O(n)
     * @return String csv
     */
    public String printElementsOrdered() {
        StringBuilder sb = new StringBuilder();
        recursivelyTraverseAndPrintTree(rootNode, sb);

        return sb.toString();
    }

    private void recursivelyTraverseAndPrintTree(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        recursivelyTraverseAndPrintTree(node.getLeft(), sb);
        sb.append(node.getValue()).append(',');
        recursivelyTraverseAndPrintTree(node.getRight(), sb);
    }
}
