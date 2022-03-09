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
    

    //height() +recursiva
    
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
    

    //busca
      //busca em profundidade
        //preOrder() - maximo a esquerda dps direita
        //inOrder() - esquerda, nó, direita
        //posOrder() - esquerda, direita, nó
      //busca em largura
        //printBFS() - explora todos os filhos antes de seguir


    //change to printBFS(), delete, made by teatcher
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<NodeBST> queue = new LinkedList<NodeBST>();
        
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                NodeBST current = queue.removeFirst();
                
                list.add(current.value);
                
                if(current.left != null) 
                    queue.addLast(current.left);
                if(current.right != null) 
                    queue.addLast(current.right);   
            }
        }
        return list;
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