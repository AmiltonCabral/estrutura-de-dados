package etapa_04_arvores_binarias_de_pesquisa;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * BFSDireita
 */
public class BFSDireita {

    private NodeBFSD root;


    public boolean isEmpty() {
        return this.root == null;
    }

    
    /**
     * Add a int to the tree with iteration
     */
    public void add(int element) {
        NodeBFSD toAdd = new NodeBFSD(element);

        if(isEmpty()) {
            this.root = toAdd;
            return;
        }

        NodeBFSD aux = this.root;

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


    //breadth search
    public ArrayList<Integer> bfsDireita() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<NodeBFSD> queue = new LinkedList<>();

        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                NodeBFSD aux = queue.removeFirst();
                
                list.add(aux.value);
                
                if (aux.right != null)
                    queue.addLast(aux.right);
                if (aux.left != null)
                    queue.addLast(aux.left);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BFSDireita tree = new BFSDireita();
        for (String str : input.nextLine().split(" "))
            tree.add(Integer.parseInt(str));

        ArrayList<Integer> bfsR = tree.bfsDireita();
        String output = "";
        for (Integer num : bfsR)
            output += num + " ";
        
        System.out.println(output.trim());
        input.close();
    }

}


/**
 * NodeBFSD
 * Node can take a int value
 */
class NodeBFSD {

    int value;
    NodeBFSD parent;
    NodeBFSD left;
    NodeBFSD right;

    public NodeBFSD(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
