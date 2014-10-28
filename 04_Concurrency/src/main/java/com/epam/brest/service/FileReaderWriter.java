package com.epam.brest.service;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

/**
 * Service to read/to write from/to a file.
 */
public class FileReaderWriter {
    public static final Logger LOG = Logger.getLogger(FileReaderWriter.class);
    public static final String FILE_NAME = "heap.txt";
    public static final Path filePath = Paths.get(System.getProperty("java.io.tmpdir") + File.separator + FILE_NAME);
    public static final File file  = new File(filePath.toString());

    public void read() {
        synchronized (file) {
            if(!file.exists()) {
                try {
                    Files.createFile(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (InputStream in = Files.newInputStream(filePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String line = null;
                LOG.info("---------------- start reading ----------------");
                while ((line = reader.readLine()) != null) {
                    LOG.info(">> reading: " + line);
                }
                LOG.info("---------------- end reading ----------------");
                Thread.sleep(10000);
            } catch (IOException x) {
                LOG.info(x.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String strToWrite) {
        synchronized (file) {
            if(!file.exists()) {
                try {
                    Files.createFile(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            LOG.info(">> writing: " + strToWrite);
            byte data[] = (strToWrite + "\n").getBytes();
            try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(filePath, APPEND))) {
                out.write(data, 0, data.length);
            } catch (IOException x) {
                LOG.info(x.getMessage());
            }
        }
    }
}
