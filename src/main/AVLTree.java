package main;

import main.Node;

public class AVLTree {
    private Node node;

    public AVLTree() {
        this.node = null;
    }

    private int heigth(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeigth();
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return heigth(node.getLeft()) - heigth(node.getRight());
    }

    public void insert(int value) {
        System.out.println("Nodo insertar");
        node = insertRec(node, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeigth(1);
            System.out.println("Nodo Insertado: " + newNode.getValue() + "Balance al insertar: " + getBalance(newNode));
            return newNode;
        }
        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node;
        }
        System.out.println("Nodo Actual: " + node.getValue());
        // Actualizar la altura de este ancestro node
        int altura = 1 + Math.max(heigth(node.getLeft()), heigth(node.getRight()));
        node.setHeigth(altura);
        System.out.println("\tAltura = " + node.getHeigth());

        int balance = getBalance(node);
        System.out.println("\tBalance = " + node.getBalance());

        // Caso Izquierda - Izquierda 
        if(balance > 1 && value < node.getLeft().getValue()){
          System.out.println("Rotacion Derecha");
        }
        // Caso Derecha - Derecha
        if(balance < -1 && value > node.getRight().getValue()){
          System.out.println("Rotacion Izquierda");
        }
        // Caso Izquierda - Derecha 
        if(balance > 1 && value > node.getLeft().getValue()){
          System.out.println("Cambio : ");

          System.out.println("Rotacion Izquierda - Derecha");
        }
        // Caso Derecha - Izquierda
        if(balance < -1 && value < node.getRight().getValue()) {
          System.out.println("Cambio : ");
          System.out.println("Rotacion Derecha -Izquierda");
        }
        return node;
    }
}