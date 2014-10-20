package com.epam.brest.heap;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Memory Management
 */
public class MemoryEaterFixed {
    static final Logger LOG = Logger.getLogger(MemoryEaterFixed.class);

    public static void main(String[] args) {
        List v = new ArrayList();
        byte b[] = new byte[1048576];
        while (true) {

            v.add(b);
            Runtime rt = Runtime.getRuntime();

            LOG.info("free memory: " + rt.freeMemory());
        }
    }
}
