package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.NoSuchElementException;

/**
 * LinkedList
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;


    public LinkedList() {
        this.size = 0;
    }


    public boolean isEmpty() {
        return this.size() == 0;
    }


    public int size() {
        return this.size;
    }


    public void addLast(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Null object");

        Node newObj = new Node(object);

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


    public void addFirst(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Null object");

        Node newObj = new Node(object);

        if (this.isEmpty()) {
            this.head = newObj;
            this.tail = newObj;
        } else {
            this.head.prev = newObj;
            newObj.next = this.head;
            this.head = newObj;
        }

        this.size ++;
    }


    public void add(int index, Object object) {
        if (index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException("Invalid index");

        if (object == null)
            throw new IllegalArgumentException("Null object");

        if (index == 0) {
            this.addFirst(object);

        } else if (index == this.size() - 1) {
            this.addLast(object);
            
        } else {
            Node newObj = new Node(object);
            Node aux = this.head;
            for (int i=0; i < index - 1; i++) {
                aux = aux.next;
            }
            newObj.prev = aux;
            newObj.next = aux.next;
            aux.next.prev = newObj;
            aux.next = newObj;
            this.size ++;
        }
    }


    public Object get(int index) {
        if (index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException("Invalid index");

        Node aux = this.head;
        for (int i=0; i < index; i++) {
            aux = aux.next;
        }
        return aux.value;
    }


    public Object getFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.head.value;
    }


    public Object getLast() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        return this.tail.value;
    }


    public int indexOf(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Null object");

        Node aux = this.head;
        int i = 0;
        while (aux != null) {
            if (aux.value.equals(object))
                return i;
            aux = aux.next;
            i++;
        }

        return -1;
    }


    public boolean contains(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Null object");

        return this.indexOf(object) != -1;
    }


    public Object removeFirst() {
        if (this.isEmpty())
            return null;

        Object value = this.head.value;

        if (this.size() == 1) {
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

        if (this.size() == 1) {
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
        if (index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0)
            return this.removeFirst();

        if (index == this.size() - 1)
            return this.removeLast();

        Node aux = this.head;
        for (int i=0; i<index; i++) {
            aux = aux.next;
        }

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        this.size--;
        return aux;
    }


    public boolean remove(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Null object");

        if (this.isEmpty())
            return false;

        Node aux = this.head;

        if (this.head.value.equals(object)) {
            this.removeFirst();
            return true;
        }

        if (this.tail.value.equals(object)) {
            this.removeLast();
            return true;
        }

        while (aux != null) {
            if (aux.value.equals(object)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                this.size --;
                return true;
            }
            aux = aux.next;
        }
        
        return false;
    }


}


/**
 * Node
 */
class Node {

    Object value;
    Node next;
    Node prev;

    public Node(Object object) {
        this.value = object;
    }
}