package com.epam.brest.thread.jobs;

import com.epam.brest.service.FileReaderWriter;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Job for writer thread.
 */
public class WriterJob implements Runnable {
    public static final Logger LOG = Logger.getLogger(WriterJob.class);
    private FileReaderWriter fileReaderWriter = new FileReaderWriter();
    private boolean flag = true;
    @Override
    public void run() {

        while (flag){
            LOG.info("Would you like to create new account?");
            LOG.info("0 - No, thanks.");
            LOG.info("1 - Let's do it!");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            switch (Integer.valueOf(input)) {
                case 0: {
                    LOG.info("Bye! Have a nice day :)");
                    flag = false;
                    break;
                }
                case 1: {
                    LOG.info("Please, enter an account owner full name: ");
                    input = scanner.next();
                    fileReaderWriter.write(input);
                    break;
                }
                default: {
                    LOG.info("Your choice isn't correct! Try one more time.");
                    break;
                }
            }
        }
    }
}
