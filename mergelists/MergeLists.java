public class MergeLists {

    public static void main(String[] args) {
    
        Node n1 = new Node(9);
        n1 = new Node(4, n1);
        n1 = new Node(2, n1);
        n1 = new Node(1, n1);
        
        Node n2 = new Node(10);
        n2 = new Node(8, n2);
        n2 = new Node(7, n2);
        n2 = new Node(4, n2);
        n2 = new Node(3, n2);
        n2 = new Node(1, n2);
       
        print(n1);
        print(n2);
        Node l = merge(n1,n2);
        System.out.println("After merge");
        print(l);
        System.out.println("After reverse");
        Node r = reverse(l);
        print(r);
        
    }
    
    public static void print (Node h){
        while(h != null){
            System.out.print(h.data+"->");
            h = h.next;
        }
        System.out.println("null");
    }
    
    public static Node merge(Node l1, Node l2){
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        //l1, l2 not null;
        Node l3;
        if(l1.data > l2.data){
            l3 = l1;
            l1 = l1.next;
        }else{
            l3 = l2;
            l2 = l2.next;
        }
        Node tail = l3;
        while(l1!= null && l2 != null){
            if(l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;            
        }
        if(l1 != null){
            tail.next = l1;
        }else{
            tail.next = l2;
        }
        
        return l3;
    }
    
	public static Node merge2(Node list1, Node list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		if (list1.data > list2.data) {
			list1.next = merge2(list1.next, list2);
			return list1;
		} else {
			list2.next = merge2(list2.next, list1);
			return list2;
		}
	}


   
    public static Node reverse(Node n1){
        Node h = n1;
        n1 = n1.next;
        h.next = null;
        while(n1 != null){
            Node t = n1;
            n1 = n1.next;
            t.next = h;
            h = t;
        }
        
        return h;
    }
    
   
}
