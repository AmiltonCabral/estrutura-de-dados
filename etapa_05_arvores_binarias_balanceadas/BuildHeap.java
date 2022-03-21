package etapa_05_arvores_binarias_balanceadas;

import java.util.Arrays;
import java.util.Scanner;


public class BuildHeap {

    int[] heap;
    int tail;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] seq = input.nextLine().split(" ");
        BuildHeap hp = new BuildHeap(convStr(seq));
        System.out.println(hp);
        input.close();
    }


    private static int[] convStr(String[] seq) {
        int[] newSeq = new int[seq.length];
        for (int i=0; i<seq.length; i++)
            newSeq[i] = Integer.parseInt(seq[i]);
        return newSeq;
    }


    public BuildHeap(int[] heap) {
        this.heap = heap;
        this.tail = heap.length - 1;
        buildHeap();
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
}