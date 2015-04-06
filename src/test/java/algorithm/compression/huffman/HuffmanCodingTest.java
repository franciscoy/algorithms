package algorithm.compression.huffman;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanCodingTest {

    @Test
    public void whenGeneratingCharFrequencyArrayThenReturnCorrect() {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        int[] charFrequency = huffmanCoding.generateCharFrequency("abcdaba");
        int[] expectedCharFrequency = new int[256];
        expectedCharFrequency[97] = 3;
        expectedCharFrequency[98] = 2;
        expectedCharFrequency[99] = 1;
        expectedCharFrequency[100] = 1;

        assertArrayEquals(expectedCharFrequency, charFrequency);
    }

    @Test
    public void whenGeneratingAHuffmanTreeThenReturnCorrect() {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        int[] charFrequency = new int[256];
        charFrequency[97] = 3;//a
        charFrequency[98] = 2;//b
        charFrequency[99] = 1;//c
        charFrequency[100] = 1;//d
        HuffmanNode tree = huffmanCoding.generateHuffmanTree(charFrequency);

        assertEquals(7,tree.getFrequency());
        assertEquals('a',tree.getRight().getName());
        assertEquals('b',tree.getLeft().getRight().getName());
        assertEquals('c',tree.getLeft().getLeft().getRight().getName());
        assertEquals('d', tree.getLeft().getLeft().getLeft().getName());
    }

    @Test
    public void whenEncodingStringThenReturnCorrect() {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        String encodedString = huffmanCoding.encodeString("the cat is under the table");
        assertEquals("00100010101101110011000111000011000011100110101011010100011100100010101100101100111100000010", encodedString);
    }

    @Test
    public void whenDecodingEncodedStringThenReturnCorrect() {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        String stringToEncode = "the cat is under the table";
        String encodedString = huffmanCoding.encodeString(stringToEncode);

        int[] charFrequency = huffmanCoding.generateCharFrequency(stringToEncode);
        HuffmanNode tree = huffmanCoding.generateHuffmanTree(charFrequency);

        String decoded = huffmanCoding.decodeString(encodedString, tree);
        assertEquals(stringToEncode, decoded);
    }
}