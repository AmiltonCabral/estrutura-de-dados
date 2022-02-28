package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;


/**
 * LinkedList
 */
class TrocaVizinhosLinkedList {

    private NodeAux head;
    private NodeAux tail;
    private int size;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TrocaVizinhosLinkedList list = new TrocaVizinhosLinkedList();
        String[] seq = input.nextLine().split(" ");
        for (String str : seq)
            list.addLast(Integer.parseInt(str));
        list.swapNext(input.nextInt());
        System.out.println(list);
        input.close();
    }


    private void swapNext(int indice) {
        if (indice == 0) {
            // a <- c
            this.head.next.prev = this.head.next;
            // b <- a
            this.head.prev = this.head.next;
            // a -> c
            this.head.next = this.head.next.next;
            // b -> a
            this.head.prev.next = this.head;
            // set new head
            this.head = this.head.prev;
            // null <- b
            this.head.prev = null;
        
        } else if (indice == this.size - 2) {
            // c -> b
            this.tail.next = this.tail.prev;
            // a -> c
            this.tail.prev.prev.next = this.tail;
            // a <- c
            this.tail.prev = this.tail.prev.prev;
            // c <- b
            this.tail.next.prev = this.tail;
            // set new tail
            this.tail = this.tail.next;            
            // b -> null
            this.tail.next = null;

        } else {
            NodeAux aux = this.head;
            for (int i=0; i<indice; i++) {
                aux = aux.next;
            }
            
            // a <- c
            aux.next.prev = aux.prev;
            // a -> c
            aux.prev.next = aux.next;
            // c <- b
            aux.prev = aux.next;
            // b <- d
            aux.next.next.prev = aux;
            // b -> d
            aux.next = aux.next.next;
            // c -> b
            aux.prev.next = aux;
        }
    }


    @Override
    public String toString() {
        String out = "";
        NodeAux aux = this.head;
        do {
            out += aux.value + " ";
            aux = aux.next;    
        } while (aux != null);

        return out.trim();
    }


    public TrocaVizinhosLinkedList() {
        this.size = 0;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }


    public int size() {
        return this.size;
    }


    public void addLast(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Null object");

        NodeAux newObj = new NodeAux(object);

        if (this.isEmpty()) {
            this.head = newObj;
            this.tail = newObj;
        } else {
            this.tail.next = newObj;
            newObj.prev = this.tail;
            this.tail = newObj;
        }

        this.size ++;
    }
}


/**
 * NodeAux
 */
class NodeAux {

    Object value;
    NodeAux next;
    NodeAux prev;

    public NodeAux(Object object) {
        this.value = object;
    }
}