package com.jonas.solution.trie;

import lombok.Data;

/**
 * NameCount
 *
 * @author shenjy
 * @version 1.0
 * @date 2024-08-25
 */
@Data
public class NameCount implements Comparable<NameCount> {

    private String name;
    private int count;

    public NameCount(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public int compareTo(NameCount o) {
        return Integer.compare(this.count, o.count);
    }

    @Override
    public String toString() {
        return name + ": " + count;
    }
}
