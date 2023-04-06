package com.capgemini.tuto;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.LinkedList;

public class TestAppender extends AppenderBase<ILoggingEvent> {

    private static TestAppender INSTANCE;
    private final int limit;
    private final LinkedList<ILoggingEvent> queue = new LinkedList<>();


    public TestAppender() {
        this(100);
    }

    public TestAppender(int limit) {
        this.limit = limit;
        INSTANCE = this;
    }

    public static TestAppender getInstance() {
        return INSTANCE;
    }

    @Override
    protected synchronized void append(ILoggingEvent event) {
        queue.add(event);
        while (queue.size() > limit) {
            queue.remove();
        }
    }

    public synchronized boolean contains(String needle) {
        return contains(null, needle);
    }

    public synchronized boolean contains(Level level, String needle) {
        return queue
                .stream()
                .filter(item -> level == null || level == Level.ALL || level.equals(item.getLevel()))
                .anyMatch(item -> item.getFormattedMessage().contains(needle));
    }

    public long count(Level level, String needle) {
        return queue
                .stream()
                .filter(item -> level == null || level == Level.ALL || level.equals(item.getLevel()))
                .filter(item -> item.getFormattedMessage().contains(needle))
                .count();
    }

}
