package com.hanoigame;

public class Node {
    private Integer value;
    private Node next;

    public Node() {
        this.value = null;
        this.next = null;
    }

    public Node(Integer info) {
        this.value = info;
        this.next = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer informacao) {
        this.value = informacao;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node proximo) {
        this.next = proximo;
    }
}