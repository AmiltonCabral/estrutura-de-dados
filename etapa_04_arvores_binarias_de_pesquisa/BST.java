package etapa_04_arvores_binarias_de_pesquisa;

/**
 * BST
 */
public class BST {

    private NodeBST root;


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
            return;
        }

        NodeBST aux = this.root;

        while (aux != null) {

            if (toAdd.value < aux.value) {
                if (aux.left == null) {
                    aux.left = toAdd;
                    toAdd.parent = aux;
                    return;
                }
                aux = aux.left;

            } else {
                if (aux.right == null) {
                    aux.right = toAdd;
                    toAdd.parent = aux;
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
            return;
        }
        addRecursive(toAdd, this.root);
    }

    private void addRecursive(NodeBST toAdd, NodeBST aux) {
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
        while (!aux.isLeaf()) {
            //do something
        }

        return null;
    }

    //max() +recursiva +iterativa

    //sucessor()

    //predecessor()

    //height() +recursiva

    //remove() *3 casos
    
    //busca
      //busca em profundidade
        //preOrder() - maximo a esquerda dps direita
        //inOrder() - esquerda, nó, direita
        //posOrder() - esquerda, direita, nó
      //busca em largura
        //printBFS() - explora todos os filhos antes de seguir

    

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
}