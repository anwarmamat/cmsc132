/**
 *
 * A binary tree implementation
 * * @auther Anwar Mamat
 *           2
 *       /       \
 *    7            5
 *  /  \             \
 * 2    6              9
 *     /  \           /
 *    5   11         4 
 *  
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BinaryTree<E> {

    private Node root;             // root of the binary tree
    
    Stack<Node> pathStack;	//this stack is used in the "path" method
    
    /**
    *	Constructor
    */
    
    BinaryTree(){
        pathStack = new Stack();
        create();
    }
    BinaryTree(Node r){
        this.root = r;
    }
    
    /**
    *	Binary Tree Node
    */
    private class Node {
        private E key;           // sorted by key
        private Node left, right;  // left and right subtrees

        public Node(E key) {
            this.key = key;
            left = null;
            right = null;
                    
        }
        
        
    }
    /**
    *	return the left subtree 
    */
    public BinaryTree getLeft(){
    	return new BinaryTree<E>(root.left);
    }
    
    /**
    *	return the right subtree 
    */
    public BinaryTree getRight(){
    	return new BinaryTree<E>(root.right);
    }
    /**
    *	Create a test tree
    */
    private void create(){
        Integer t = 2;
        root = new Node((E)t);
        t = 7;
        root.left = new Node((E)t);
        t = 2;
        root.left.left = new Node((E)t);
        t = 6;
        root.left.right = new Node((E)t);
        t = 5;
        root.left.right.left = new Node((E)t);
        t = 11;
        root.left.right.right = new Node((E)t);
        t = 30;
        root.left.right.right.right = new Node((E)t);
        t=5;
        root.right = new Node((E)t);
        t=9;
        root.right.right = new Node((E)t);
        t=4;
        root.right.right.left = new Node((E)t);
        
    }
    
    /**
    *	return the value of root
    */
    public E value() {
        return root.key;
    }
    
    
    /*
     * preOrder traverse the binary tree
     */
    public void preOrder(){
        preOrderTraverseIterate(root);
    }
    /*
     * Preorder traverse the binary tree starting from a node
     */
    public void preOrder(Node r){
        if(r == null){return;}
        System.out.print(r.key+",");
        preOrder(r.left);
        preOrder(r.right);
    }

    /*
     * inOrder traverse the binary tree
     */
    public void inOrder(){
        inOrderTraverseIterate(root);
    }
    /*
     * inOrder traverse the binary tree starting from a node
     */
    public void inOrder(Node r){
        if(r == null){return;}
        inOrder(r.left);
        System.out.print(r.key+",");
        inOrder(r.right);
    }
    
    /*
     * postOrder traverse the binary tree
     */
    public void postOrder(){
        postOrder(root);
    }
    /*
     * postOrder traverse the binary tree starting from a node
     */
    public void postOrder(Node r){
        if(r == null){return;}
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.key+",");
    }
    
    
    private void preOrderTraverseIterate(Node r){
        Stack<Node> S = new Stack();
        Node current = root;
        while(current != null || !S.empty()){
            while(current != null){
                System.out.print(current.key +"->");
                S.push(current.right);
                current = current.left;
            }
            if(!S.empty()){
                current = S.pop();
            }
        }
    }
    private void inOrderTraverseIterate(Node r){
    	Stack<Node> S = new Stack();
    	Node current = root;
    	while(current != null  || !S.empty()){
        	if(current != null){
           		S.push(current);
           		current = current.left;
        	}else{
            	current = S.pop();
            	System.out.print(current.key+ "->");
            	current = current.right;
        	}
    	}
    }


    public void postOrderTraversalIterative(){
	postOrderIterative(root3);
    }
    private void postOrderTraversalIterative(Node node) 
    {
        Stack<Node> S = new Stack<Node>();
          
        // Check for empty tree
        if (node == null)
            return;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty()) 
        {
            Node current = S.peek();
            /* go down the tree in search of a leaf an if so process it 
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else{
                    S.pop();
                    System.out.print(current.key+",");
                }
  
                /* go up the tree from left node, if the child is right 
                   push it onto stack otherwise process parent and pop 
                   stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else{
                    S.pop();
                    System.out.print(current.key+",");
                }
                  
                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } else if (current.right == prev){
                S.pop();
                System.out.print(current.key+",");
            }
            prev = current;
        }       
    }

    
    /**
    * is the symbol table empty?
    */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
    * return number of nodes in the tree
    */
    public int size() {
        return size(root);
    }
    
    /**
    * return the number of nodes in a subtree rooted at r
    */
    private int size(Node r){
        if(r == null) return 0;
        return 1 + size(r.left )+ size(r.right);
    }
    
    
    /**
    * height of this binary tree (one-node tree has height 0)
    */
    public int height() {
        return height(root); 
    }
    
    /** 
    * height of a tree rooted at r
    */
    
    private int height(Node r) {
        if (r == null) return -1;
        return 1 + Math.max(height(r.left), height(r.right));
    }

    /**
    * return the number of leaves
    */
    public int countLeaves(){
        return countLeaves(root);
    }
    
    /** 
    *	return the number of leaves of a rooted at r
    */
    public int countLeaves(Node r){
        if(r == null) return 0;
        if(r.left == null && r.right == null) return 1;
        return countLeaves(r.left) + countLeaves(r.right) ;
    }
    
   /**
   * return diameter of the tree
   */
   public int diameter(){
       return diameter(root);
   }
       
   /**
   * return diameter of the tree rooted at r
   */
   public int diameter(Node r){
       if (r == null) return 0;
       int lheight = height(r.left)+1;
       int rheight = height(r.right)+1;
       int ldiameter = diameter(r.left);
       int rdiameter = diameter(r.right);
       return Math.max(lheight + rheight + 1, Math.max(ldiameter,rdiameter));
    }
   
   /**
    * Display the tree in level order
    */
    public void levelOrder(){
        if(root == null){ return; }
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            Node t = q.poll();
            System.out.print(t.key+",");
            if(t.left != null) q.offer(t.left);
            if(t.right != null) q.offer(t.right);
        }
    }
    
    /**
     * Path from node with a given key to root
     */
    public void path(Integer k){
        path(root,k);
    }
    
    /**
     * Path from node with a given key to root
     */
    public void path(Node r, Integer k){
        if(r == null) return;
        pathStack.push(r);
        if(r.key.equals(k)) {
            System.out.print("\nPath to " + k +":" );
            for(Node tt: pathStack){
                System.out.print(tt.key+"-->");
            }
            System.out.println("\n");
            return;
        }
        path(r.left,k);
        path(r.right,k);
        pathStack.pop();
    }
    
    /** recursive path */
    public void path_rec(Integer k){
		path_rec(root,k);
	}
	private boolean path_rec(Node r, Integer k){
		if(r==null) return false;
		if(path_rec(r.right,k) || path_rec(r.left,k)
				||r.data.equals(k)){
			System.out.print(r.data+"->");
			return true;
		}else{
			return false;
		}
	}
    
    /**
     *  Merge two trees into one tree by adding corresponding keys
     *
     *
     */
    /*
    public void merge(){
		root3 = merge(root1,root2);
	}
	
	private Node merge(Node t1,Node t2){
		if(t1==null && t2==null) return null;
		if(t1==null) {
			Node t = new Node(t2.key);
			t.left = merge(null, t2.left);
			t.right = merge(null, t2.right);
			return t;
			}
		if(t2==null){
			Node t = new Node(t1.key);
			t.left = merge(t1.left, null);
			t.right = merge(t1.right, null);
			return t;
		}
		int d = t1.key + t2.key;
		Node t = new Node(d);
		t.left = merge(t1.left, t2.left);
		t.right = merge(t1.right, t2.right);
		return t;
	}
    
    */
    /*
     * mirror the binary tree
     */
    public void make_mirror(){
        make_mirror(root);
    }
    
    /*
     * mirror a subbinary tree at a given root
     */
    private void make_mirror(Node r){
        if(r == null) return;
        Node t = r.left;
        r.left = r.right;
        r.right = t;
        mirror(r.left);
        mirror(r.right);
    }
    
    
    
	
	public boolean equal(Node t1, Node t2){
			if(t1==null && t2==null) return true;
			if(t1 ==null && t2 != null) return false;
			if(t2 ==null && t1 != null) return false;
			return t1.data.equals(t2.data) && 
			equal(t1.left, t2.left) && equal(t1.right, t2.right);
	}
	
	public boolean is_mirror(Node t1, Node t2){
		if(t1==null && t2==null) return true;
		if(t1 ==null && t2 != null) return false;
		if(t2 ==null && t1 != null) return false;
		return t1.data.equals(t2.data) && 
		mirror(t1.left, t2.right) && mirror(t1.right, t2.left);
}

    
    public E findLCA(E n1, E n2)
    {
		Node t = findLCA(root, n1, n2);
        return t.key;
    }
 
    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    Node findLCA(Node node, E n1, E n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.key.equals(n1) || node.key.equals(n2))
            return node;
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        System.out.println("preOrder traversal:");
        b.preOrder();
        System.out.println("\ninOrder traversal:");
        b.inOrder();
        System.out.println("\npostOrder traversal:");
        b.postOrder();
        System.out.println("\n");
        System.out.println("Size:" + b.size());
        System.out.println("Height:" + b.height());
        System.out.println("Number of leaves:" + b.countLeaves());
        System.out.println("Diameter:" + b.diameter());
        System.out.println("Level Order:");
        b.levelOrder();
        b.path(11);
    
    	//visualize the binary tree
        BinaryTreeView<Integer> btv = new BinaryTreeView<Integer>(b, 400, 400);
        btv.refresh();
    }
}
