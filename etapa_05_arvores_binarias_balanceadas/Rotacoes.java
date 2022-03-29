package etapa_05_arvores_binarias_balanceadas;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Rotacoes
 */
class Rotacoes {

    private NodeRot root;
    private int size;
    private int[] order;
    private int index_order;
    private boolean rebalanced;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rotacoes avl = new Rotacoes();
        String[] seqS = input.nextLine().split(" ");
        input.close();
        for (String num : seqS)
            avl.add(Integer.parseInt(num));
        if (!avl.rebalanced)
            System.out.println("balanceada");
    }


    public void add(int element) {
        NodeRot toAdd = new NodeRot(element);
        if(isEmpty()) {
            this.root = toAdd;
            this.size ++;
            return;
        }
        addRecursive(toAdd, this.root);
    }

    private void addRecursive(NodeRot toAdd, NodeRot aux) {
        if (toAdd.value < aux.value) {
            if (aux.left == null) {
                aux.left = toAdd;
                toAdd.parent = aux;
                this.size ++;
                return;
            }
            addRecursive(toAdd, aux.left);
            rebalance(aux);
            this.rebalanced = true;
        } else {
            if (aux.right == null) {
                aux.right = toAdd;
                toAdd.parent = aux;
                this.size ++;
                return;
            }
            addRecursive(toAdd, aux.right);
            rebalance(aux);
            this.rebalanced = true;
        }
    }


    public boolean isEmpty() {
        return this.root == null;
    }


    private void rebalance(NodeRot node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.right) < 0) {
                // double left rotation
                rotateRight(node.right);
                rotateLeft(node);
            } else {
                // simple left rotation
                rotateLeft(node);
            }
        } else if (balance < -1) {
            if (balance(node.left) > 0) {
                // double right rotation
                rotateLeft(node.left);
                rotateRight(node);
            } else {
                // simple right rotation
                rotateRight(node);
            }
        }
    }
    
    
    private void rotateLeft(NodeRot node) {
        System.out.println("rot_esq(" + node.value + ")");
        NodeRot aux = node.right;
        node.right = aux.left;
        //if (node.right != null)
        //    node.right.parent = node;
        aux.left = node;
        aux.parent = node.parent;
        node.parent = aux;
        if (aux.parent != null) {
            if (aux.parent.left == node)
                aux.parent.left = aux;
            else
                aux.parent.right = aux;
        }
        if (this.root == node)
            this.root = aux;
        preOrder();
    }


    private void rotateRight(NodeRot node) {
        System.out.println("rot_dir(" + node.value + ")");
        NodeRot aux = node.left;
        node.left = aux.right;
        //if (node.left != null)
        //    node.left.parent = node;
        aux.right = node;
        aux.parent = node.parent;
        node.parent = aux;
        if (aux.parent != null) {
            if (aux.parent.left == node)
                aux.parent.left = aux;
            else
                aux.parent.right = aux;
        }
        if (this.root == node)
            this.root = aux;
        preOrder();
    }


    private int balance(NodeRot node) {
        if (node != null)
            // right - left
            return height(node.right) - height(node.left);
        return 0;
    }


    public int height() {
        return height(this.root);
    }

    private int height(NodeRot node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }


    public void preOrder() {
        this.order = new int[this.size];
        this.index_order = 0;
        preOrder(this.root);
        System.out.println(Arrays.toString(this.order));
    }

    private void preOrder(NodeRot node) {
        if (node != null) {
            this.order[index_order] = node.value;
            this.index_order++;
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}


class NodeRot {

    int value;
    NodeRot parent;
    NodeRot left;
    NodeRot right;

    public NodeRot(int value) {
        this.value = value;
    }

    public int height() {
        if (this.left == null && this.right == null)
            return 0;
        else if (this.left == null)
            return 1 + this.right.height();
        else if (this.right == null)
            return 1 + this.left.height();
        else
            return 1 + Math.max(this.left.height(),this.right.height());
    }

    public int balance() {
        int left = this.left == null ? -1 : this.left.height();
        int right = this.right == null ? -1 : this.right.height();
        return left - right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasOnlyLeftChild() {
        return this.left != null && this.right == null;
    }

    public boolean hasOnlyRightChild() {
        return this.left == null && this.right != null;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}