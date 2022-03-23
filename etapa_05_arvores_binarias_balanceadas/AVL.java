package etapa_05_arvores_binarias_balanceadas;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * AVL
 * 
 * balance = right - left
 * 
 * Dúvidas:
 * - custo é O(log n)
 * - Quando usar heap ou arvore AVL, vi mais vantagem em usar heap já que 
 *   trabalha com array.
 * - rotate_left ou rotate_right no root, tem que atualizar o root, qual a melhor forma
 */
public class AVL {

    private NodeAVL root;
    private int size;
    private String order;  //output to depth search


    public boolean isEmpty() {
        return this.root == null;
    }


    /**
     * To change
     */
    public void add(int element) {
        NodeAVL toAdd = new NodeAVL(element);
        if(isEmpty()) {
            this.root = toAdd;
            this.size ++;
            return;
        }
        addRecursive(toAdd, this.root);
    }

    private void addRecursive(NodeAVL toAdd, NodeAVL aux) {
        if (toAdd.value < aux.value) {
            if (aux.left == null) {
                aux.left = toAdd;
                toAdd.parent = aux;
                this.size ++;
                return;
            }
            addRecursive(toAdd, aux.left);
            rebalance(aux);
        } else {
            if (aux.right == null) {
                aux.right = toAdd;
                toAdd.parent = aux;
                this.size ++;
                return;
            }
            addRecursive(toAdd, aux.right);
            rebalance(aux);
        }
    }


    public NodeAVL search(int toFind) {
        if (isEmpty()) return null;

        NodeAVL aux = this.root;

        while (aux != null) {
            if (toFind == aux.value) return aux;
            if (toFind < aux.value) aux = aux.left;
            if (toFind > aux.value) aux = aux.right;
        }

        return null;
    }


    public NodeAVL recursiveSearch(int toFind) {
        return recursiveSearch(toFind, this.root);
    }

    private NodeAVL recursiveSearch(int toFind, NodeAVL aux) {
        if (aux == null) return null;
        if (toFind == aux.value) return aux;
        if (toFind < aux.value) return recursiveSearch(toFind, aux.left);
        return recursiveSearch(toFind, aux.right);
    }


    public NodeAVL min(NodeAVL node) {
        NodeAVL aux = node;
        while (aux.left != null) {
            aux = aux.left;
        }
        return aux;
    }


    public NodeAVL max(NodeAVL node) {
        NodeAVL aux = node;
        while (aux.right != null) {
            aux = aux.right;
        }
        return aux;
    }


    public NodeAVL sucessor(NodeAVL node) {
        if (node.right != null) return min(node.right);

        NodeAVL aux = node;
        while (aux.parent != null) {
            if (aux.parent.value > node.value) return aux.parent;
            aux = aux.parent;
        }
        return null;
    }


    public NodeAVL predecessor(NodeAVL node) {
        if (node.left != null) return max(node.left);
        
        NodeAVL aux = node;
        while (aux.parent != null) {
            if (aux.parent.value < node.value) return aux.parent;
            aux = aux.parent;
        }
        return null;
    }
    

    public int height() {
        return height(this.root);
    }

    private int height(NodeAVL node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }
    

    // 3 casos
    public NodeAVL remove(int valueToRemove) {
        NodeAVL toRemove = search(valueToRemove);
        if (toRemove != null) {
            remove(toRemove);
            this.size --;
        }
        return toRemove;
    }

    private void remove(NodeAVL toRemove) {
        // Case 1: is Leaf
        if (toRemove.isLeaf()) {
            if (toRemove == this.root) {
                this.root = null;
            } else if (toRemove.value < toRemove.parent.value) {
                toRemove.parent.left = null;
            } else {
                toRemove.parent.right = null;
            }
            rebalanceUp(toRemove);

        // Case 2: as only one child
        // - Case 2.1: left
        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.left;
                } else {
                    toRemove.parent.right = toRemove.left;
                }
            }
            rebalanceUp(toRemove);
        // - Case 2.2: right
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.right;
                } else {
                    toRemove.parent.right = toRemove.right;
                }
            }
            rebalanceUp(toRemove);

        // Case 3: as two childs
        } else {
            NodeAVL sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }


    //to do...
    private void rebalanceUp(NodeAVL node) {
        NodeAVL parent = node.parent;
        while (parent != null) {
            rebalance(parent);
            parent = parent.parent;
        }
    }


    //to do...
    private void rebalance(NodeAVL node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.right) < 0) {
                // double left rotation
                rotate_right(node.right);
                rotate_left(node);
            } else {
                // simple left rotation
                rotate_left(node);
            }
        } else if (balance < -1) {
            if (balance(node.left) > 0) {
                // double right rotation
                rotate_left(node.left);
                rotate_right(node);
            } else {
                // simple right rotation
                rotate_right(node);
            }
        }
    }
    
    
    private void rotate_left(NodeAVL node) {
        NodeAVL aux = node.right;
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
    }


    private void rotate_right(NodeAVL node) {
        NodeAVL aux = node.left;
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
    }    


    private int balance(NodeAVL node) {
        if (node != null)
            // right - left
            return height(node.right) - height(node.left);
        return 0;
    }


    public int size() {
        return this.size;
    }


    //depth search
    public String preOrder() {
        this.order = "";
        preOrder(this.root);
        return this.order.trim();
    }

    private void preOrder(NodeAVL node) {
        if (node != null) {
            this.order += node + " ";
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    //depth search
    public String inOrder() {
        this.order = "";
        inOrder(this.root);
        return this.order.trim();
    }

    private void inOrder(NodeAVL node) {
        if (node != null) {
            inOrder(node.left);
            this.order += node + " ";
            inOrder(node.right);
        }
    }


    //depth search
    public String posOrder() {
        this.order = "";
        posOrder(this.root);
        return this.order.trim();
    }

    private void posOrder(NodeAVL node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            this.order += node + " ";
        }
    }


    //breadth search
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<NodeAVL> queue = new LinkedList<>();

        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                //System.out.print(queue.getFirst() + " ");
                NodeAVL aux = queue.removeFirst();
                
                list.add(aux.value);
                
                if (aux.left != null)
                    queue.addLast(aux.left);
                if (aux.right != null)
                    queue.addLast(aux.right);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        AVL tst = new AVL();
        // add: 52,22,85,8,43,81,96,11,26,69,74
        int[] arr = new int[]{52,22,85,8,43,81,96,11,26,69,74};
        for (int v : arr) tst.add(v);
        assert tst.preOrder().equals("52 22 8 11 43 26 85 74 69 81 96");
        assert tst.inOrder().equals("8 11 22 26 43 52 69 74 81 85 96");
        assert tst.posOrder().equals("11 8 26 43 22 69 81 74 96 85 52");

        // remove: 96,85,52,22,74
        tst.remove(96);
        assert tst.posOrder().equals("11 8 26 43 22 69 81 85 74 52");
        tst.remove(85);
        assert tst.posOrder().equals("11 8 26 43 22 69 81 74 52");
        tst.remove(52);
        assert tst.posOrder().equals("11 8 26 43 22 81 74 69");
        tst.remove(22);
        assert tst.posOrder().equals("11 8 43 26 81 74 69");
        tst.remove(74);
        assert tst.posOrder().equals("11 8 43 81 69 26");

        AVL tst2 = new AVL();
        arr = new int[]{1,2,3,4,5,6,7,8,9};
        for (int v : arr)
            tst2.add(v);
        
    }

}


/**
 * NodeAVL
 * Node can take a int value
 */
class NodeAVL {

    int value;
    NodeAVL parent;
    NodeAVL left;
    NodeAVL right;

    public NodeAVL(int value) {
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
