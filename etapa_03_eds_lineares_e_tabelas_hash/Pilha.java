package etapa_03_eds_lineares_e_tabelas_hash;


/**
 * Implementation of Stack using array as base.
 */
public class Pilha {

    private int[] arrStack;
    private int size;
    private int capacity;


    public Pilha(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.arrStack = new int[capacity];
    }


    public boolean isEmpty() {
        return this.size == 0;
    }


    public boolean isFull() {
        return this.size == this.capacity;
    }


    public void push(int n) {
        if(this.isFull())
            throw new RuntimeException("FullStackException");
        this.arrStack[size] = n;
        this.size++;
    }
    
    
    public int peek() {
        if(this.isEmpty())
        throw new RuntimeException("EmptyStackException");
        return this.arrStack[this.size-1];
    }
    
    
    public int size() {
        return this.size;
    }
    
    
    public int pop() {
        if(this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        this.size--;
        return this.arrStack[this.size];
    }
    
    
    public int pop(int index) {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        Pilha pAux = new Pilha(index);
        for(int i=0; i<index -1; i++) {
            pAux.push(this.pop());
        }
        int outputValue = this.pop();
        while(!pAux.isEmpty()) {
            this.push(pAux.pop());
        }
        return outputValue;
    }


    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0;
    
        pilha.push(10);
        assert pilha.peek() == 10;
        assert pilha.size() == 1;
        assert !pilha.isEmpty();
    
        pilha.push(5);
        assert pilha.size() == 2;

        assert pilha.pop() == 5;

        pilha.push(7);
        assert pilha.peek() == 7;
        pilha.pop();

        assert !pilha.isEmpty();
        pilha.pop();

        assert pilha.isEmpty();
        pilha.push(3);
        pilha.push(8);
        pilha.push(4);
        pilha.push(1);
        pilha.push(7);
        assert pilha.size() == 5;

        assert pilha.pop(3) == 4;
        assert pilha.size() == 4;
        pilha.push(2);
        assert pilha.size() == 5;
    }
}