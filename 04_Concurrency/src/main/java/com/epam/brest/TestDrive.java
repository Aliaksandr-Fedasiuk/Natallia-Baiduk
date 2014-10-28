package com.epam.brest;

import com.epam.brest.thread.jobs.ReaderJob;
import com.epam.brest.thread.jobs.WriterJob;

/**
 * TestDrive class with a main method
 */
public class TestDrive {


    public static void main(String[] args) throws InterruptedException {

        Thread writerThread = new Thread(new WriterJob());
        Thread readerThread = new Thread(new ReaderJob());

        writerThread.start();
        Thread.sleep(10000);
        readerThread.start();
    }
}
