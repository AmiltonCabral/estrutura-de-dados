package etapa_05_arvores_binarias_balanceadas;

import java.util.Arrays;

/**
 * Every node must be highter or equals to yours
 * childrens.
 * 
 * Dúvidas para aula:
 * - Necessidade do 'i > 0' no while do add()
 * 
 * 
 */
public class Heap {

    int[] heap;
    int tail;


    public Heap(int capacity) {
        this.heap = new int[capacity];
        this.tail = -1;        
    }


    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = heap.length - 1;
        buildHeap();
    }


    public boolean isEmpty() {
        return this.tail == -1;
    }
    
    
    public int parent(int index) {
        return (index - 1) / 2;
    }


    public int left(int index) {
        return index * 2 + 1;
    }


    public int right(int index) {
        return (index + 1) * 2;
    }


    public void add(int toAdd) {
        if (this.tail >= this.heap.length - 1)
            resize();

        this.heap[++this.tail] = toAdd;

        int i = this.tail;
        while (heap[i] > heap[parent(i)]) { // && i > 0
            swap(i, parent(i));
            i = parent(i);
        }
    }


    private void resize() {
        // newCapacity = oldCapacity + 75%
        int newCapacity = heap.length + (int) (heap.length * (0.75));
        int[] newHeap = new int[newCapacity];
        for (int i=0; i<=this.tail; i++)
            newHeap[i] = this.heap[i];
        
        this.heap = newHeap;
    }


    // also known as extractMax()
    public int remove() {
        if (this.isEmpty()) throw new 
            RuntimeException("Can not remove element from Empty Heap");

        int removed = this.heap[0];
        this.heap[0] = this.heap[this.tail--];

        this.heapify(0);
        
        return removed;
    }


    private void heapify(int index) {
        if (!isLeaf(index) && isValidIndex(index)) {       
            int indexMax = maxIndex(index, left(index), right(index));

            if (index < indexMax) {
                swap(index, indexMax);
                heapify(indexMax);
            }
        }
    }


    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }


    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }


    /**
     * can't be a leaf
     * @return max index from three values
     */
    private int maxIndex(int index, int left, int right) {
        if (heap[index] > heap[left]) {
            if (isValidIndex(right)) {
                if (heap[index] < heap[right])
                    return right;
            }
            return index;
        } else {
            if (isValidIndex(right)) {
                if (heap[left] < heap[right])
                    return right;
            }
            return left;
        }   
    }


    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--)
            heapify(i);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }


    public static void main(String[] args) {

        // test left
		Heap heap = new Heap(15);
		heap.add(100);
		heap.add(90);
		heap.add(85);
		heap.add(30);
		heap.add(45);
		heap.add(60);
		heap.add(70);
		heap.add(20);
		assert heap.left(0) == 1;
		assert heap.left(2) == 5;
		assert heap.left(1) == 3;

        
        // test right
        heap = new Heap(15);
		heap.add(100);
		heap.add(90);
		heap.add(85);
		heap.add(30);
		heap.add(45);
		heap.add(60);
		heap.add(70);
		heap.add(20);
		heap.add(113);
		assert heap.right(0) == 2;
		assert heap.right(2) == 6;
		assert heap.right(1) == 4;


        // test parent
        heap = new Heap(15);
		heap.add(100);
		heap.add(90);
		heap.add(85);
		heap.add(30);
		heap.add(45);
		heap.add(60);
		heap.add(70);
		heap.add(20);
		assert heap.parent(5) == 2;
		assert heap.parent(3) == 1;
		assert heap.parent(4) == 1;


        // test removed
        int[] expected = new int[]{82, 65, 62, 45, 56, 52, 43, 30, 33, 38,
                0, 0, 0, 0, 0};
    
        heap = new Heap(15);
        for (int i = 0; i <= 9; i++)
            heap.add(expected[i]);
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 82 == heap.remove();
        expected = new int[]{65, 56, 62, 45, 38, 52, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 65 == heap.remove();
        expected = new int[]{62, 56, 52, 45, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 62 == heap.remove();
        expected = new int[]{56, 45, 52, 30, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 56 == heap.remove();
        expected = new int[]{52, 45, 43, 30, 38, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 52 == heap.remove();
        expected = new int[]{45, 38, 43, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 45 == heap.remove();
        expected = new int[]{43, 38, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 43 == heap.remove();
        expected = new int[]{38, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 38 == heap.remove();
        expected = new int[]{33, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 33 == heap.remove();
        expected = new int[]{30, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
        
        assert 30 == heap.remove();
        expected = new int[]{30, 30, 33, 30, 33, 33, 43, 30, 33, 38, 0, 0, 0, 0, 0};
        assert Arrays.toString(expected).equals(heap.toString());
    }
}