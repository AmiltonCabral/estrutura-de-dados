package etapa_03_eds_lineares_e_tabelas_hash;

/**
 * Fila
 */
public class Fila {

    private int[] fila;
    private int head, tail, capacidade;


    public Fila(int capacidade) {
        this.head = -1;
        this.tail = -1;
        this.fila = new int[capacidade];
        this.capacidade = capacidade;
    }


    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }


    public boolean isFull() {
        return this.head == (this.tail + 1) % this.capacidade;
    }


    public void add(int n) {
        if (this.isFull())
            throw new RuntimeException("Queue is full");

        if (this.isEmpty()) {
            this.head = 0;
            this.tail = 0;
            this.fila[0] = n;
        } else {
            this.tail = (this.tail + 1) % this.capacidade;
            this.fila[tail] = n;
        }
    }


    public int remove() {
        if (this.isEmpty())
            throw new RuntimeException("Queue is empty");

        int value = this.fila[this.head];
        
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.capacidade;
        }
        
        return value;
    }


    public int head() {
        if (this.isEmpty())
            throw new RuntimeException("Queue is empty");

        return fila[this.head];
    }


    public static void main(String[] args) {
        Fila fila = new Fila(10);
        assert fila.isEmpty();
        fila.add(2);
        fila.add(5);
        fila.add(7);
        assert fila.head() == 2;
        assert fila.remove() == 2;
        assert fila.head() == 5;
        fila.add(3);
        fila.add(1);
        fila.add(10);
        fila.add(9);
        fila.add(4);
        fila.add(6);
        
        assert fila.remove() == 5;
        assert fila.head() == 7;

        fila.add(2);
        assert !fila.isFull();

        fila.add(14);
        fila.add(29);
        assert fila.isFull();
    }
}