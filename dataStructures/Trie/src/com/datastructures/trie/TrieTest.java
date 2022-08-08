package com.datastructures.trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        
        System.out.println("prefix valid 'ca'? : " + trie.isPrefixValid("ca"));
        System.out.println("prefix valid 'da'? : " + trie.isPrefixValid("da"));
        System.out.println("----------");
        
        System.out.println("word vaild 'card'? : " + trie.isWordValid("card"));
        System.out.println("word valid 'carb'? : " + trie.isWordValid("carb"));
        System.out.println("----------");
        
        trie.printAllKeys();
    }
}

