package etapa_04_arvores_binarias_de_pesquisa;

import java.util.Scanner;

/**
 * SomaFolhas
 */
public class SomaFolhas {

    private NodeSF root;
    private int leafSum;


    public boolean isEmpty() {
        return this.root == null;
    }

    
    /**
     * Add a int to the tree with iteration
     */
    public void add(int element) {
        NodeSF toAdd = new NodeSF(element);

        if(isEmpty()) {
            this.root = toAdd;
            return;
        }

        NodeSF aux = this.root;

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


    //depth search
    public int sumLeafs() {
        this.leafSum = 0;
        sumLeafs(this.root);
        return this.leafSum;
    }

    private void sumLeafs(NodeSF node) {
        if (node != null) {
            sumLeafs(node.left);
            sumLeafs(node.right);
            if (node.isLeaf())
                this.leafSum += node.value;
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SomaFolhas tree = new SomaFolhas();
        for (String str : input.nextLine().split(" "))
            tree.add(Integer.parseInt(str));

        System.out.println(tree.sumLeafs());
        
        input.close();
    }

}


/**
 * NodeSF
 * Node can take a int value
 */
class NodeSF {

    int value;
    NodeSF parent;
    NodeSF left;
    NodeSF right;

    public NodeSF(int value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
