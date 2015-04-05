package algorithm.compression.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Francisco Yllera.
 */
public class HuffmanCoding {

    /**
     * Encode a string in binary code using Huffman greedy algorithm
     * @param inputString input to encode
     * @return
     */
    public String encodeString(String inputString) {
        int[] charFrequency = generateCharFrequency(inputString);
        HuffmanNode tree = generateHuffmanTree(charFrequency);
        Map<Character, String> encodingMap = generateEncodingMap(tree);

        return encodeString(inputString, encodingMap);
    }

    /**
     * Decode a string with a Huffman tree
     * @param encodedString input to decode
     * @param tree Huffman tree
     * @return
     */
    //WIP TODO
    public String decodeString(String encodedString, HuffmanNode tree) {
        StringBuilder decodedString = new StringBuilder();

        for (char c : encodedString.toCharArray()) {

        }

        return decodedString.toString();
    }

    /**
     * Generate a char frequency array based on the string
     * @param inputString
     * @return
     */
    public int[] generateCharFrequency(String inputString) {
        int[] charFrequency = new int[256];

        for (char c : inputString.toCharArray()) {
            charFrequency[c]++;
        }

        return charFrequency;
    }

    /**
     * Generate a Huffman tree with a greedy algorithm, bottom-up, merging the two
     * less frequent nodes with a parent node.
     * All the character nodes are leafs
     *
     * @param charFrequency
     * @return
     */
    public HuffmanNode generateHuffmanTree(int[] charFrequency) {
        PriorityQueue<HuffmanNode> huffmanNodePriorityQueue = new PriorityQueue<>();

        for (int i = 0; i < charFrequency.length; i++) {
            if (charFrequency[i] > 0) {
                huffmanNodePriorityQueue.add(new HuffmanNode((char) i, charFrequency[i]));
            }
        }

        while (huffmanNodePriorityQueue.size() > 1) {
            HuffmanNode lowestNode = huffmanNodePriorityQueue.remove();
            HuffmanNode secondNode = huffmanNodePriorityQueue.remove();

            HuffmanNode parentNode = new HuffmanNode(HuffmanNode.EMPTY_CHAR,
                    lowestNode.getFrequency() + secondNode.getFrequency());
            parentNode.setRight(lowestNode);
            parentNode.setLeft(secondNode);

            huffmanNodePriorityQueue.add(parentNode);
        }

        return huffmanNodePriorityQueue.remove();
    }

    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
//        int[] c = new int[6];
//        c[0] = 3;
//        c[1] = 2;
//        c[2] = 6;
//        c[3] = 8;
//        c[4] = 2;
//        c[5] = 6;
//
//        HuffmanNode h = huffmanCoding.generateHuffmanTree(c);
//        Map<Character, String> map = huffmanCoding.generateEncodingMap(h);
//        System.out.println("a");
        String a = huffmanCoding.encodeString("hola manola");
        System.out.println(a);
    }

    public String encodeString(String inputString, Map<Character, String> encodingMap) {
        StringBuilder encodedString = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            encodedString.append(encodingMap.get(c));
        }

        return encodedString.toString();
    }

    public Map<Character, String> generateEncodingMap(HuffmanNode tree) {
        Map<Character, String> encodingMap = new HashMap<>();
        traverseAndInsert(tree, "", encodingMap);

        return encodingMap;
    }

    /**
     * InOrder Traversal to generate an encoding map
     * @param node
     * @param currentPath
     * @param encodingMap
     */
    public void traverseAndInsert(HuffmanNode node, String currentPath, Map<Character, String> encodingMap) {
        if (node == null) {
            return;
        }

        traverseAndInsert(node.getLeft(), currentPath + "0", encodingMap);
        if (HuffmanNode.EMPTY_CHAR != node.getName()) {
            encodingMap.put(node.getName(), currentPath);
        }
        traverseAndInsert(node.getRight(), currentPath + "1", encodingMap);
    }
}
