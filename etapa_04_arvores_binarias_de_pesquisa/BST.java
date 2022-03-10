package etapa_04_arvores_binarias_de_pesquisa;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * BST
 */
public class BST {

    private NodeBST root;
    private int size;
    private String order;  //output to depth search


    public boolean isEmpty() {
        return this.root == null;
    }

    
    /**
     * Add a int to the tree with iteration
     */
    public void add(int element) {
        NodeBST toAdd = new NodeBST(element);

        if(isEmpty()) {
            this.root = toAdd;
            this.size ++;
            return;
        }

        NodeBST aux = this.root;

        while (aux != null) {

            if (toAdd.value < aux.value) {
                if (aux.left == null) {
                    aux.left = toAdd;
                    toAdd.parent = aux;
                    this.size ++;
                    return;
                }
                aux = aux.left;

            } else {
                if (aux.right == null) {
                    aux.right = toAdd;
                    toAdd.parent = aux;
                    this.size ++;
                    return;
                }
                aux = aux.right;
            }
        }
    }


    /**
     * Add a int to the tree with recursion
     */
    public void addRecursive(int element) {
        NodeBST toAdd = new NodeBST(element);
        if(isEmpty()) {
            this.root = toAdd;
            this.size ++;
            return;
        }
        addRecursive(toAdd, this.root);
    }

    private void addRecursive(NodeBST toAdd, NodeBST aux) {
        if (toAdd.value < aux.value) {
            if (aux.left == null) {
                aux.left = toAdd;
                toAdd.parent = aux;
                this.size ++;
                return;
            }
            addRecursive(toAdd, aux.left);
        } else {
            if (aux.right == null) {
                aux.right = toAdd;
                toAdd.parent = aux;
                this.size ++;
                return;
            }
            addRecursive(toAdd, aux.right);
        }
    }


    public NodeBST search(int toFind) {
        if (isEmpty()) return null;

        NodeBST aux = this.root;

        while (aux != null) {
            if (toFind == aux.value) return aux;
            if (toFind < aux.value) aux = aux.left;
            if (toFind > aux.value) aux = aux.right;
        }

        return null;
    }


    public NodeBST recursiveSearch(int toFind) {
        return recursiveSearch(toFind, this.root);
    }

    private NodeBST recursiveSearch(int toFind, NodeBST aux) {
        if (aux == null) return null;
        if (toFind == aux.value) return aux;
        if (toFind < aux.value) return recursiveSearch(toFind, aux.left);
        return recursiveSearch(toFind, aux.right);
    }


    public NodeBST min(NodeBST node) {
        NodeBST aux = node;
        while (aux.left != null) {
            aux = aux.left;
        }
        return aux;
    }


    public NodeBST max(NodeBST node) {
        NodeBST aux = node;
        while (aux.right != null) {
            aux = aux.right;
        }
        return aux;
    }


    public NodeBST sucessor(NodeBST node) {
        if (node.right != null) return min(node.right);

        NodeBST aux = node;
        while (aux.parent != null) {
            if (aux.parent.value > node.value) return aux.parent;
            aux = aux.parent;
        }
        return null;
    }


    public NodeBST predecessor(NodeBST node) {
        if (node.left != null) return max(node.left);
        
        NodeBST aux = node;
        while (aux.parent != null) {
            if (aux.parent.value < node.value) return aux.parent;
            aux = aux.parent;
        }
        return null;
    }
    

    public int height() {
        return height(this.root);
    }

    private int height(NodeBST node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }
    

    // 3 casos
    public NodeBST remove(int valueToRemove) {
        NodeBST toRemove = search(valueToRemove);
        if (toRemove != null) {
            remove(toRemove);
            this.size --;
        }
        return toRemove;
    }

    private void remove(NodeBST toRemove) {
        // Case 1: is Leaf
        if (toRemove.isLeaf()) {
            if (toRemove == this.root) {
                this.root = null;
            } else if (toRemove.value < toRemove.parent.value) {
                toRemove.parent.left = null;
            } else {
                toRemove.parent.right = null;
            }

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

        // Case 3: as two childs
        } else {
            NodeBST sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }


    public int size() {
        return this.size;
    }


    //busca em profundidade
    public String preOrder() {
        this.order = "";
        preOrder(this.root);
        return this.order.trim();
    }

    private void preOrder(NodeBST node) {
        if (node != null) {
            this.order += node + " ";
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    //busca em profundidade
    public String inOrder() {
        this.order = "";
        inOrder(this.root);
        return this.order.trim();
    }

    private void inOrder(NodeBST node) {
        if (node != null) {
            inOrder(node.left);
            this.order += node + " ";
            inOrder(node.right);
        }
    }


    //busca em profundidade
    public String posOrder() {
        this.order = "";
        posOrder(this.root);
        return this.order.trim();
    }

    private void posOrder(NodeBST node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            this.order += node + " ";
        }
    }


    //Not finished
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<NodeBST> queue = new LinkedList<>();

        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                //System.out.print(queue.getFirst() + " ");
                NodeBST aux = queue.removeFirst();
                
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
        BST tst = new BST();
        tst.add(52);
        tst.add(22);
        tst.add(85);
        tst.add(8);
        tst.add(43);
        tst.add(81);
        tst.add(96);
        tst.add(11);
        tst.add(26);
        tst.add(69);
        tst.add(74);
        assert tst.preOrder().equals("52 22 8 11 43 26 85 81 69 74 96");
        assert tst.inOrder().equals("8 11 22 26 43 52 69 74 81 85 96");
        assert tst.posOrder().equals("11 8 26 43 22 74 69 81 96 85 52");
        ArrayList<Integer> expectedBFS = new ArrayList<Integer>();
        expectedBFS.add(52);
        expectedBFS.add(22);
        expectedBFS.add(85);
        expectedBFS.add(8);
        expectedBFS.add(43);
        expectedBFS.add(81);
        expectedBFS.add(96);
        expectedBFS.add(11);
        expectedBFS.add(26);
        expectedBFS.add(69);
        expectedBFS.add(74);
        assert tst.bfs().equals(expectedBFS);
    }

}


/**
 * NodeBST
 * Node can take a int value
 */
class NodeBST {

    int value;
    NodeBST parent;
    NodeBST left;
    NodeBST right;

    public NodeBST(int value) {
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