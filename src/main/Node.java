package main;

public class Node {
    private int value;
    private int heigth;
    private Node left, right;

    public Node(int value) {
        this.value = value;
        this.heigth = 1;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}