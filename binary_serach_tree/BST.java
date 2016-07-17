
package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        public Node(Key k, Value v){
            key = k;
            value = v;
        }
    }
    BST(){
        root = null;
    }
    BST(Node r){
        this.root = r;
    }
    
    
    public void put(Key key, Value val){
        if(val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        //dumpToGraphViz();
    }
    
    private Node put(Node x, Key key, Value val){
        if(x == null) { return new Node(key,val);}
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {x.left = put(x.left, key, val);}
        else if (cmp > 0) {x.right = put(x.right, key, val);}
        else {x.value = val;}
        return x;
        
    }
    
    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.value;
    }
    
    
    public void delete(Key key){
        root = delete(root, key);
    }
    
    public Value value(){
        return root.value;
    }
    public String info(){
        return root.key + "/" + root.value;
    }
    
    public BST<Key,Value> getLeft(){
        return new BST(root.left);
    }
    public BST<Key, Value> getRight(){
        return new BST(root.right);
    }
    
    private Node delete(Node x, Key k){
        if(x == null) return null;
        int cmp = k.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, k);
        else if (cmp > 0) x.right = delete(x.right, k);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
           
    }
    public void deleteMin(){
        deleteMin(root);
    }
    
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        //System.out.println("Key=" + x.key  + "\tValue=" + x.value);
        return x;
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    
    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        return x;
    }
    
    public Key min(){
        if(isEmpty()) return null;
        return min(root).key;
    }
    
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    
    public Key max(){
        if(isEmpty()) return null;
        return max(root).key;
    }
    
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    
    public int size(){
        return size(root);
    }
    
    private int size(Node x){
        if(x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    private int height(Node r){
        if(r == null) return -1;
        return 1 + Math.max(height(r.left), height(r.right));
    }
    public int height(){
        
        return height(root);
    }
    public boolean contains(Key key){
        return get(key) == null;
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node r){
        if(r == null) return;
        System.out.print(r.key+",");
        preOrder(r.left);
        preOrder(r.right);
    }
    
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node r){
        if(r == null) return;
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.key+",");
    }
    
     public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node r){
        if(r == null) return;
        inOrder(r.left);
        System.out.print(r.key+",");
        inOrder(r.right);
    }
    
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node r){
        if( r == null) return;
        Queue<Node> q = new LinkedList();
        q.offer(r);
        while(!q.isEmpty()){
            Node t = q.poll();//pop
            System.out.print("<"+t.key+","+t.value+">");
            if(t.left != null) q.offer(t.left);
            if(t.right != null) q.offer(t.right);
        }
    }
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST();
        BinaryTreeView<Integer,String> btv = new BinaryTreeView<Integer,String>(bst, 400, 400);
        String inp;
        System.out.println("Command:\ninsert: i key value      i 10 Alice");
        System.out.println("remove: r key      r 10");
        System.out.println("max: returns max key");
        System.out.println("min: returns min key");
        System.out.println("done: terminate the program");
        inp = InputHelper.getStringInput("Enter next key value:");
        if(inp.equals("")){
    			Integer i = (int)(Math.random()*1000);
    			
    			inp = "i " + i + " " + ".";
        }
        while (!inp.equals("done")){
            String inputs[] = inp.split(" ");
            try{
                if(inputs[0].equals("min")){
                    System.out.println("Min: "+bst.min());
                }else if(inputs[0].equals("max")){
                    System.out.println("Max: "+bst.max());
                }
                else if(inputs[0].toLowerCase().equals("i")){
                    bst.put(Integer.parseInt(inputs[1]),inputs[2]);
                }else if(inputs[0].toLowerCase().equals("r")){
                    bst.delete(Integer.parseInt(inputs[1]));
                    System.out.println("element is removed");
                }else if(inputs[0].toLowerCase().equals("rmin")){
                    bst.deleteMin();
                }else if(inputs[0].toLowerCase().equals("rmax")){
                    bst.deleteMax();
                }
            
                btv.refresh();
            }catch(ArrayIndexOutOfBoundsException ex)
            {
                System.out.println(ex);
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
            inp = InputHelper.getStringInput("Enter next value (i key value):");
            if(inp.equals("")){
        			Integer i  = (int)(Math.random()*1000);
        			inp = "i " + i + " " + ".";
            }
        }
        System.out.println("done.");
        bst.preOrder();
        System.out.println("");
        bst.inOrder();
        System.out.println("");
        bst.postOrder();
        System.out.println("");
        
     }
       
}
