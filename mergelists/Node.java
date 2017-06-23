
public class Node {
    public int data;
    public Node next;
    public Node(int i){
        data = i;
        next = null;
    }
    public Node(int i, Node r){
    	data = i;
    	next = r;
    }
    	
}
