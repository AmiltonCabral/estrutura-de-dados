package etapa_05_arvores_binarias_balanceadas;

import java.util.Scanner;

/**
 * Balance
 */
class Balance {

    private NodeBal root;
    private String order;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Balance avl = new Balance();
        String[] seqS = input.nextLine().split(" ");
        input.close();
        for (String num : seqS)
            avl.add(Integer.parseInt(num));
        System.out.println(avl.preOrder());
    }


    public String preOrder() {
        this.order = "";
        preOrder(this.root);
        return this.order.trim();
    }

    private void preOrder(NodeBal node) {
        if (node != null) {
            this.order += node + "," + balance(node) + " ";
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public void add(int element) {
        NodeBal toAdd = new NodeBal(element);
        if(isEmpty()) {
            this.root = toAdd;
            return;
        }
        addRecursive(toAdd, this.root);
    }

    private void addRecursive(NodeBal toAdd, NodeBal aux) {
        if (toAdd.value < aux.value) {
            if (aux.left == null) {
                aux.left = toAdd;
                toAdd.parent = aux;
                return;
            }
            addRecursive(toAdd, aux.left);
        } else {
            if (aux.right == null) {
                aux.right = toAdd;
                toAdd.parent = aux;
                return;
            }
            addRecursive(toAdd, aux.right);
        }
    }


    public boolean isEmpty() {
        return this.root == null;
    }


    private int balance(NodeBal node) {
        if (node != null)
            // left - right
            return height(node.left) - height(node.right);
        return 0;
    }


    public int height() {
        return height(this.root);
    }

    private int height(NodeBal node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }
}



class NodeBal {

    int value;
    NodeBal parent;
    NodeBal left;
    NodeBal right;

    public NodeBal(int value) {
        this.value = value;
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