package com.appsflyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DebugLogQueue {
    private static DebugLogQueue ourInstance = new DebugLogQueue();
    List<Item> queue = new ArrayList();

    public static class Item {
        private String msg;
        private long timestamp = new Date().getTime();

        public Item(String str) {
            this.msg = str;
        }

        public String getMsg() {
            return this.msg;
        }

        public long getTimestamp() {
            return this.timestamp;
        }
    }

    private DebugLogQueue() {
    }

    public static DebugLogQueue getInstance() {
        return ourInstance;
    }

    public Item pop() {
        if (this.queue.size() == 0) {
            return null;
        }
        Item item = (Item) this.queue.get(0);
        this.queue.remove(0);
        return item;
    }

    public void push(String str) {
        this.queue.add(new Item(str));
    }
}
