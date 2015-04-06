package algorithm.compression.huffman;

/**
 * Created by Francisco Yllera.
 */
public class HuffmanNode implements Comparable<HuffmanNode>{

    public static final char EMPTY_CHAR = '*';
    private char name;
    private int frequency;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(char name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getName() {
        return name;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public int compareTo(HuffmanNode tree) {
        return frequency - tree.getFrequency();
    }
}
