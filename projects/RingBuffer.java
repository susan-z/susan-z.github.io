/* Name: Susan Zhao
 * Pennkey: suzhao
 * Recitation: 216
 * 
 * Execution: Creates a ring buffer data structure that models a sitar string
 * 
 */

public class RingBuffer {
    private double[] bufferArray; // items in the buffer
    private int first = 0;        // index for the next dequeue or peek
    private int last = -1;        // index for the next enqueue
    private int currentSize;      // number of items in the buffer
    private double temp;          // temporary storage for first box in dequeue
    
    /* Description: creates an empty buffer with given max capacity
     * Input: integer value of max capacity
     * Output: creates an empty buffer, no output
     */
    public RingBuffer(int capacity) {
        bufferArray = new double[capacity];
    }
    
    /* Description: returns the number of items currently in the buffer
     * Input: none
     * Output: integer value of the number of items in the buffer at one time
     */
    public int currentSize() {
        if (last == -1) currentSize = 0;
        currentSize = Math.abs(first - last) + 1;
        return currentSize;
    }
    
    /* Description: checks if the buffer is empty
     * Input: none
     * Output: boolean t/f if the buffer is empty or not
     */
    public boolean isEmpty() {
        if (currentSize == 0) return true;
        return false;
    }
    
    /* Description: checks if the buffer is full
     * Input: none
     * Output: boolean to determine if the buffer is full
     */
    public boolean isFull() {
        if (currentSize == bufferArray.length) return true;
        return false;
    }
    
    /* Description: adds an item to the end ("last" index)
     * Input: double value x
     * Output: none
     */
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("ERROR: Attempting to enqueue " +
                                       "to a full buffer.");
        }
        
        last = (last + 1) % bufferArray.length;
        bufferArray[last] = x;
        currentSize++;
    }
    
    /* Description: deletes and returns the item from the "first" index
     * Input: none
     * Output: double value of the item in the first index
     */
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to dequeue " +
                                       "from an empty buffer.");
        }
        temp = bufferArray[first];
        bufferArray[first] = 0.0;
        first = (first + 1) % bufferArray.length;
        currentSize--;
        return temp;
    }
    
    /* Description: looks at the item in the "first" index, or front
     * Input: none
     * Output: double value of the first index
     */
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to peek " +
                                       "at an empty buffer.");
        }
        return bufferArray[first];
    }
    
    /* Description: prints the contents of the RingBuffer
     * Input: none
     * Output: none, but prints the object for debugging
     */
    private void printBufferContents() {
        // print out first, last, and currentSize
        System.out.println("first:        " + first);
        System.out.println("last:         " + last);
        System.out.println("currentSize:  " + currentSize);
        System.out.println("temp:         " + temp);
        
        // print bufferArray's length and contents if it is not null
        // otherwise just print a message that it is null
        if (bufferArray != null) {
            System.out.println("array length: " + bufferArray.length);
            System.out.println("Buffer Contents:");
            for (int i = 0; i < bufferArray.length; i++) {
                System.out.println(bufferArray[i]);
            }
        } else {
            System.out.println("bufferArray is null");
        }
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) {
        // create a RingBuffer with bufferSize elements
        // where bufferSize is a command-line argument
        int bufferSize = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(bufferSize);
        
    }
    
}