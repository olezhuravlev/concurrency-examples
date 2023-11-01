package com.baeldung.concurrent.mutex;

//import dev.mccue.guava.concurrent.Monitor;

import dev.mccue.guava.concurrent.Monitor;

public class SequenceGeneratorUsingMonitor extends SequenceGenerator {

    private Monitor mutex = new Monitor();

    @Override
    public int getNextSequence() {
        mutex.enter();
        try {
            return super.getNextSequence();
        } finally {
            mutex.leave();
        }
    }

}
