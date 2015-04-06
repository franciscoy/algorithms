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
     * Decode a string with a Huffman tree, traversing the tree.
     * If the char is 1 go right, 0 go left until find a leaf with its value.
     * O(n log m), n = number of chars, m = number of nodes in the tree
     *
     * @param encodedString input to decode
     * @param tree Huffman tree
     * @return
     */
    public String decodeString(String encodedString, HuffmanNode tree) {
        try {
            StringBuilder decodedString = new StringBuilder();
            HuffmanNode currentNode = tree;

            for (char c : encodedString.toCharArray()) {
                currentNode = (c=='1') ? currentNode.getRight() : currentNode.getLeft();
                if (currentNode.getName() != HuffmanNode.EMPTY_CHAR) {
                    decodedString.append(currentNode.getName());
                    currentNode = tree;
                }
            }

            return decodedString.toString();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("The encoded string is invalid or does not match the huffman tree.");
        }
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
     * InOrder Traversal to generate an encoding map,
     * The lowest node go to the right, with 1, the bigger one goes in the left with 0.
     *
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
