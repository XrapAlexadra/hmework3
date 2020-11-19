package com.github.xrapalexandra.util;

public class Indexing {

    private int idCount = 0;

    public int getId() {
        return idCount++;
    }
}
