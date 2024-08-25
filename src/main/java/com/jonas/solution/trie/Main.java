package com.jonas.solution.trie;

import java.util.PriorityQueue;

/**
 * Main
 *
 * @author shenjy
 * @version 1.0
 * @date 2024-08-25
 */
public class Main {

    public static void main(String[] args) {
        String[] names = {"张伟", "王伟伟", "王芳", "李伟", "李娜"};
        int k = 100; //找到前100个重名人数最多的姓名
        Trie trie = new Trie();
        for (String name : names) {
            trie.insert(name);
        }

        PriorityQueue<NameCount> topKNames = trie.getTopNames(k);
        while (!topKNames.isEmpty()) {
            System.out.println(topKNames.poll());
        }
    }
}
