import java.util.*;

/**
 * TIME COMPLEXITY
 * -Set and Get = O(1)
 * -Insertion and Deletion = O(n)
 */
class CustomArrayList<E> {
    private static final int INITIAL_CAPACITY =10;
    private E[] theData;
    private int size = 0;
    private int capacity;

    /**
     * Constructor for Arraylist  
     */
    public CustomArrayList(){
        this.capacity = INITIAL_CAPACITY;
        this.theData = (E[]) new Object[this.capacity];
    }

    /**
     * Get size 
     */
    public int size(){
        return this.size;
    }

    /**
     * Add method
     */
    public boolean add(E anEntry){
        if(this.size == this.capacity){
            reallocate();    
        }
        this.theData[size] = anEntry;
        this.size++;
        return true;
    }

    /**
     * Add to and index
     */
    public void add(int index, E anEntry){
        if(index < 0 || index > this.size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(this.size == capacity){
            reallocate();
        }
        for(int i = this.size; i>index; i--){
            this.theData[i] = this.theData[i-1];
        }
        this.theData[index] = anEntry;
        this.size++;
    }

    /**
     * Get method 
     */
    public E get(int index){
        if(index < 0 || index > this.size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.theData[index];
    }

    /**
     * Set method 
     */
    public E set(int index, E newEntry){
        if(index < 0 || index > this.size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = this.theData[index];
        this.theData[index] = newEntry;
        return oldValue;
    }

    /**
     * Remove method 
     */
    public E remove(int index){
        if(index < 0 || index > this.size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = this.theData[index];
        for(int i = index + 1; i < this.size; i++){
            this.theData[i-1] = this.theData[i];
        }
        this.size--;
        return oldValue;
    }

    /**
     * Reallocate method 
     */
    private void reallocate(){
        this.capacity = 2 * this.capacity;
        this.theData = Arrays.copyOf(theData, this.capacity);
    }
}

class TestArrayList{
    public static void main(String[] args) {
        CustomArrayList<Integer> myList  = new CustomArrayList<Integer>();

        myList.add(1);

        System.out.print(myList.get(0));
    }
}