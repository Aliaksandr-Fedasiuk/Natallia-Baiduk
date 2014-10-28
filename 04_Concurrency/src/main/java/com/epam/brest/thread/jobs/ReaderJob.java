package com.epam.brest.thread.jobs;

import com.epam.brest.service.FileReaderWriter;

/**
 * Job for reader thread.
 */
public class ReaderJob implements Runnable {

    @Override
    public void run() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        while (true) {
            fileReaderWriter.read();
        }
    }
}
