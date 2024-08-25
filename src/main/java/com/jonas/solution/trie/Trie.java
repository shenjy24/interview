package com.jonas.solution.trie;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前缀树
 *
 * @author shenjy
 * @version 1.0
 * @date 2024-08-25
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String name) {
        TrieNode node = root;
        for (char ch : name.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.count++;
    }

    public void getAllNames(TrieNode node, StringBuilder prefix, PriorityQueue<NameCount> minHeap, int k) {
        if (node == null) return;
        if (node.count > 0) {
            if (minHeap.size() < k) {
                minHeap.offer(new NameCount(prefix.toString(), node.count));
            } else if (node.count > minHeap.size()) {
                minHeap.poll();
                minHeap.offer(new NameCount(prefix.toString(), node.count));
            }
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            prefix.append(entry.getKey());
            getAllNames(entry.getValue(), prefix, minHeap, k);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public PriorityQueue<NameCount> getTopNames(int k) {
        PriorityQueue<NameCount> minHeap = new PriorityQueue<>(k);
        getAllNames(root, new StringBuilder(), minHeap, k);
        return minHeap;
    }
}
