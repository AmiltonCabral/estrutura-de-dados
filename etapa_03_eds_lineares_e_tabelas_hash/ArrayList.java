package etapa_03_eds_lineares_e_tabelas_hash;

/**
 * ArrayList
 * 
 * default capacity: 20
 * resize with 75% of previous capacity
 */
public class ArrayList {

    private Object[] list;
    private final static int DEFAULT_CAPACITY = 20;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    public ArrayList(int capacity) {
        this.list = new Object[capacity];
        this.size = 0;
    }


    public boolean add(Object object) {
        this.ensureCapacity(this.size + 1);
        this.list[this.size++] = object;
        return true;
    }

    
    public void add(Object object, int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
        
        this.ensureCapacity(this.size + 1);
        if (index <= this.size) {
            this.shitRight(index);
        }
        this.list[index] = object;
        this.size++;
    }


    public void set(Object object, int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();

        this.list[index] = object;
    }


    private void shitRight(int index) {
        if (index == this.list.length    - 1)
            throw new IndexOutOfBoundsException();

        for (int i = this.size; i>index; i--) {
            this.list[i] = this.list[i - 1];
        }
    }

    
    private void shiftLeft(int index) {
        for (int i = index; i<this.size - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
    }


    public void ensureCapacity(int intendedCapacity) {
        if (this.list.length < intendedCapacity) {
            // newCapacity = 75% + capacity
            resize(Math.max((int) (this.list.length * (1.5)),
                intendedCapacity));
        }
    }


    private void resize(int newCapacity) {
        Object[] newList = new Object[newCapacity];
        for (int i=0; i<this.list.length; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
    }


    public Object remove(int index) {
        if (index < 0 || index >= this.size)
            return null;
            //throw new IndexOutOfBoundsException();

        Object object = this.get(index);
        this.shiftLeft(index);
        this.size--;
        return object;
    }


    public boolean remove(Object object) {
        if (object == null)
            return false;
        
        for (int i=0; i<this.size; i++) {
            if (object.equals(this.list[i])) {
                this.shiftLeft(i);
                this.size--;
                return true;
            }
        }
        return false;
    }


    public Object get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();

        return this.list[index];
    }


    public int indexOf(Object object) {
        if (object == null)
            return -1;

        for (int i=0; i<this.size; i++) {
            if (object.equals(this.list[i]))
                return i;
        }
        return -1;
    }


    public boolean contains(Object object) {
        return this.indexOf(object) != -1;
    }



    //tests
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("mun");
        assert l.get(0).equals("mun");
        l.add("ola", 0);
        assert l.get(0).equals("ola");
        assert l.get(1).equals("mun");
        l.set("mundo", 1);
        assert l.get(1).equals("mundo");
        l.add("first", 0);
        assert l.get(0).equals("first");
        assert l.get(2).equals("mundo");
        l.add("max");
        l.add("verstappen");
        l.add("best");
        assert l.get(5).equals("best");
        l.set("vigarista", 5);
        assert l.get(5).equals("vigarista");
        assert l.indexOf("vigarista") == 5;
        l.add("plus07");
        l.add("plus08");
        l.add("plus09");
        l.add("plus10");
        l.add("plus11");
        l.add("plus12");
        l.add("plus13");
        l.add("plus14");
        l.add("plus15");
        l.add("plus16");
        l.add("plus17");
        l.add("plus18");
        l.add("plus19");
        l.add("20");
        assert l.get(19).equals("20");
        assert !l.contains("last");
        assert l.add("last");
        assert l.contains("last");
        assert l.get(20).equals("last");

        assert l.remove(15).equals("plus16");
        assert l.get(15).equals("plus17");
        assert l.get(19).equals("last");

        assert !l.remove("iDoNotExist");
        assert l.get(9).equals("plus10");
        assert l.remove("plus10");
        assert l.get(9).equals("plus11");
        assert l.get(18).equals("last");
        assert l.remove("last");
        
        //System.out.println(l.size);
    }
}