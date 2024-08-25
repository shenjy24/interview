package com.jonas.solution.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 *
 * @author shenjy
 * @version 1.0
 * @date 2024-08-25
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    int count;

    public TrieNode() {
        children = new HashMap<>();
        count = 0;
    }


}
