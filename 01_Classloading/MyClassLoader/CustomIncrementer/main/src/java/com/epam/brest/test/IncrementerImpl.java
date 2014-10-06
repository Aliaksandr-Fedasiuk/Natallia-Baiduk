package com.epam.brest.test;

/**
 * An implementation, with will be loaded by MyClassLoader.
 */
public class IncrementerImpl implements Incrementer {

    public static Integer count2 = new Integer(0);

    /**
     * Increment a count1 value.
     *
     * @return incremented value of count1
     */
    @Override
    public StringBuffer incCount1() {
        return count1.append("1");
    }

    /**
     * Increment a count2 value.
     *
     * @return incremented value of count2
     */
    public int incCount2() {
        return ++count2;
    }

    public String toString() {

        return "Hi, I'm incrementer! I'm loaded by " + this.getClass().getClassLoader();
    }
}
