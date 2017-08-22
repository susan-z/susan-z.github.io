                      /*
 * Name: Susan Zhao
 * pennkey: suzhao
 * recitation: 216
 * 
 * Execution: Creates the optimal tour regarding points
 * 
 */

public class Tour implements TourInterface {
    private Node head;
    private Node tail;
    
    private class Node {
        private Point data;
        private Node next;
    }
    
    public Tour() {   
        
        head = new Node();
        tail = new Node();
        
        head.data = null; 
        head.next = tail;
        
        tail.data = head.data;
        tail.next = null;
    }
    
    public boolean isEmpty() { return head.data == null; } 
    
    /* Description: create a String representation of the Tour
     * Input: none
     * Output: String
     */
    // any edge starting or ending at p should be in a distinct color
    public String toString() {
        String tour = "";
        if (isEmpty()) { return tour; }
        
        for (Node current = head; current != null; current = current.next) {
            tour += current.data.toString() + '\n';
        }
        return tour;
        
    }
    
    /* Description: draw the Tour using PennDraw
     * Input: Point p 
     * Output: none, but draws the Tour using PennDraw
     */
    public void draw(Point p) {
        int count = 1;
        if (isEmpty()) { return; }
        for (Node current = head; current.next != null; current = current.next) {
            if (current.next.data == p || current.data == p) { 
                PennDraw.setPenColor(PennDraw.BLUE); 
            }
            else {
                PennDraw.setPenColor(PennDraw.RED);
            }
            current.data.drawTo(current.next.data);
        }
    }
    
    /* Description: number of Points in this Tour
     * Input: none
     * Output: integer value of the size of the tour
     */
    public int size() {
        int count = 0;
        if (isEmpty()) { return 0; }
        if (head.next == tail) { return 1; } 
        for (Node current = head; current != null; current = current.next) {
            count++;
        }
        return count - 1;
    }
    
    /* Description: return the total distance of the Tour
     * Input: none
     * Output: double value of the distance
     */
    public double distance() {
        double distance = 0;
        if (isEmpty()) { return 0.0; }
        else { for(Node current = head; current.next != null; 
                   current = current.next) {
            distance += current.data.distanceTo(current.next.data);
        }
        }
        return distance;
    }
    
    /* Description: insert p at the end of the Tour
     * Input: Point p
     * Output: none
     */
    public void insertInOrder(Point p) {
        if (head.data == null) {
            head.data = p;
            tail.data = head.data;
        }
        else {    
            Node current = head;
            Node previous = new Node();       
            Node insert = new Node();
            
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            
            insert.next = previous.next;
            previous.next = insert;    
            insert.data = p;
            
        }
    }
    
    /* Description: insert p using the nearest neighbor heuristic
     * Input: Point p
     * Output: none
     */
    public void insertNearest(Point p) {
        if (head.data == null) {
            head.data = p;
            tail.data = head.data;
        }
        else {
            Node insert = new Node();
            if (head.next == tail) {
                insert.next = head.next;
                head.next = insert;
                insert.data = p;
            }
            else { 
                Node near = head;
                double min = head.data.distanceTo(head.next.data);
                Node current = head;
                while (current.next != null) {
                    if (current.data.distanceTo(current.next.data) < min) {
                        near = current;
                        min = current.data.distanceTo(current.next.data); 
                    }
                    current = current.next;
                }
                insert.next = near.next;
                near.next = insert;
                insert.data = p;
            }
        }
    }
    
    /* Description: insert p using the smallest increase heuristic
     * Input: Point p 
     * Output: none
     */
    public void insertSmallest(Point p) {
        if (head.data == null) {
            head.data = p;
            tail.data = head.data;
        }
        else {
            Node smallest = head;
            Node insert = new Node();
            insert.data = p;
            if (head.next == tail) {
                insert.next = head.next;
                head.next = insert;
            }            
            else { 
                int count = 0;
                for (Node current = head; current != null; current = current.next) {
                    count++;
                }
                double[] distances = new double[count - 1];
                int i = 0;
                for (Node current = head; current != null; current = current.next) {
                    distances[i] = current.data.distanceTo(insert.data) + 
                        insert.data.distanceTo(current.next.data) - 
                        current.data.distanceTo(current.next.data);
                    i++;
                }
                double min = distances[0];
                for (int j = 0; j < distances.length; j++) {
                    if (distances[j] < min) {
                        min = distances[j];
                    }
                }
                for (Node current = head; current != null; current = current.next) {
                    if (current.data.distanceTo(insert.data) + 
                        insert.data.distanceTo(current.next.data) - 
                        current.data.distanceTo(current.next.data) == min) {
                        smallest = current;
                    }
            }
            }
            insert.next = smallest.next;
                smallest.next = insert;
    }
}
}


     
       