/*
Partner 1 Name: Susan Zhao
Partner 1 PennKey: suzhao
Partner 1 Recitation #: 216

Partner 2 Name: Tong Pow
Partner 2 PennKey: tpow
Partner 2 Recitation #: 202
 * 
 * Execution: One LinkedList class to work with all data types
 * Linked list implements the List interface, which is a basic API of a list
 * 
*/
public class LinkedList<T> implements List<T> {
    private Node head;  
    private int size;
    
    private class Node {
        private T element;
        private Node next;
    }
    
    /* Description: constructor for the linked list
     * Input: none
     * Output: none, generates the head of the node with element null
    */
    public LinkedList() {
        head = new Node();
    }
    
    /* Description: adds element x to the end of the list
     * Input: element x
     * Output: boolean
    */
    public boolean add(T x) {
        Node insert = new Node(); 
        if (head == null) {
            head = new Node();
            head.element = x;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = insert; 
            insert.element = x; 
            insert.next = null;
        }
        //increment size
        size++;
        return true;
    }
    
    /* Description: adds element x at a particular index of the list
     * Input: integer index, element x
     * Output: boolean
    */
    public boolean add(int index, T x) {
        if (index != 0) {
                throw new IllegalArgumentException("ERROR: Index out of bounds");
            }
        Node toAdd = new Node();
        if (head == null) {
            head = new Node();
            head.element = x;
        }
        else {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("ERROR: Index out of bounds");
            }
            if (index == 0) {
                if (head == null) {
                    head = new Node();
                    head.element = x;
                }
                else {
                    toAdd.next = head; 
                    toAdd.element = x;
                    head = toAdd;
                }            
            }
            else {
                Node beforeIndex = head;
                for (int i = 0; i < index - 1; i++) {
                    beforeIndex = beforeIndex.next;
                }
                toAdd.next = beforeIndex.next;
                beforeIndex.next = toAdd; 
                toAdd.element = x; 
            }
        }
        //increment size
        size++;
        return true;
    }
    
    /* Description: returns size of list
     * Input: none
     * Output: integer size
    */ 
    public int size() {
        return size;
    }
    
    /* Description: recursively returns the element using the specified 
     * position in the list
     * Input: integer index
     * Output: element at that index
    */
    public T get(int index) {
        if (head == null) {
            throw new IllegalArgumentException("ERROR: Index out of bounds");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ERROR: Index out of bounds");
        }
        return getHelper(index, head);
    }
    
    private T getHelper(int index, Node node) {
        if (index == 0) {
            return node.element;
        }
        return getHelper(index - 1, node.next);
    }
    
    /* Description: replace the object at the specified index
     * Input: integer index, element x
     * Output: element
    */
    public T set(int index, T x) {
        // move iteratively to position index, only have a reference to 
        // position n
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("ERROR: Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        } 
        T returnVal = current.element;
        current.element = x;
        return returnVal; 
    }
    
    /* Description: remove T at a particular index
     * Input: integer index
     * Output: T (element)
    */
    public T remove(int index) {
        T returnVal = null;
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ERROR: Index out of bounds");
        }
        if (index == 0) {
            returnVal = head.element;
            head = head.next;
        } else { 
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            returnVal = node.next.element;
            node.next = node.next.next;
        }
        //Decrement size
        size--;
        return returnVal; 
    }
    
    /* Description: check if list is empty
     * Input: none
     * Output: boolean
    */
    public boolean isEmpty() {
        return head == null;  
    }
    
    /* Description: check if list contains a certain T
     * Input: T element
     * Output: boolean
    */
    public boolean contains(T element) {
        for (Node current = head; current != null; current = current.next) {
            if (current.element == element) { 
                return true; 
            }
        }
        return false;
    }
    
    /* Description: returns the index of a certain element
     * Input: element T
     * Output: integer of index
    */
    public int indexOf(T element) {
        int count = 0;
        for (Node current = head; current != null; current = current.next) {
            
            if (current.element == element) {
                return count;
            } 
            count++;
        }
        return -1;
    }
}
