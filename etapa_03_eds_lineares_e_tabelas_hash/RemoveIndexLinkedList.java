package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;

/**
 * LinkedList
 */
class RemoveIndexLinkedList {

    private No head;
    private No tail;
    private int size;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RemoveIndexLinkedList list = new RemoveIndexLinkedList();
        String[] seq = input.nextLine().split(" ");
        for (String str : seq)
            list.addLast(Integer.parseInt(str));
        list.remove(input.nextInt());
        System.out.println(list);
        input.close();
    }


    @Override
    public String toString() {
        String out = "";
        No aux = this.head;
        do {
            out += aux.value + " ";
            aux = aux.next;
        } while (aux != null);

        return out.trim();
    }


    public RemoveIndexLinkedList() {
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

        No newObj = new No(object);

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


    public Object removeFirst() {
        if (this.isEmpty())
            return null;

        Object value = this.head.value;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size --;

        return value;
    }


    public Object removeLast() {
        if (this.isEmpty())
            return null;

        Object value = this.tail.value;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size --;

        return value;
    }


    public Object remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0)
            return this.removeFirst();

        if (index == this.size - 1)
            return this.removeLast();

        No aux = this.head;
        for (int i=0; i<index; i++) {
            aux = aux.next;
        }

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        this.size--;
        return aux;
    }

}


/**
 * No
 */
class No {

    Object value;
    No next;
    No prev;

    public No(Object object) {
        this.value = object;
    }
}