package com.hanoigame;

public class Stack {
    private Node top;
    private String name;
    private int size;

    public String toString() {
        Node current = this.top;
        if (current == null) {
            return "empty";
        }
        String str = "";
        while (current.getNext() != null) {
            str = " <- " + current.getValue() + str;
            current = current.getNext();
        }
        str = current.getValue() + str;
        return str;
    }

    public void show() {
        System.out.println(name + ": " + this);
    }

    public int getTopValue() {
        return this.top.getValue();
    }

    public int count() {
        int count = 0;
        Node curr = this.top;
        while(curr != null) {
            count++;
            curr = curr.getNext();
        }

        return count;
    }

    public boolean full() {
        return this.size == this.count();
    }

    public boolean ascending() {
        Node current = this.top;
        while(current.getNext() != null) {
            if(current.getValue() > current.getNext().getValue()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public boolean descending() {
        Node current = this.top;
        while(current.getNext() != null) {
            if(current.getValue() < current.getNext().getValue()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public Stack(String name, int size) {
        this.name = name;
        this.top  = null;
        this.size = size;
    }

    public void push(Integer value) {
        if(this.full()) {return;}
        Node added = new Node(value);
        if (this.top == null) {
            this.top = added;
        } else {
            added.setNext(this.top);
            this.top = added;
        }
    }

    public Node pop() {
        if(this.count() == 0) {return null;}
        Node removed = this.top;
        this.top = this.top.getNext();
        removed.setNext(null);
        return removed;
    }
}
