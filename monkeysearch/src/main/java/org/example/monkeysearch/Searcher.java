package org.example.monkeysearch;

import java.util.concurrent.TimeUnit;

public class Searcher {
    private Thread searchThread;

    public Thread getSearchThread() {
        return searchThread;
    }

    public void start() {
        searchThread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("searching...");
            }
        });
        System.out.println("Searcher is start");
        searchThread.start();
    }

    public void stop() {
        searchThread.stop();
        System.out.println("Searcher is stop");
    }

}
