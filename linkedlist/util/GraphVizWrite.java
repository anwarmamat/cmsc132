package util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *	Prints a linked list to a GraphViz file.
 *	Open graph.dot to visualize the linked list
 * @author anwar
 */
public class GraphVizWrite<T> {
    
    public void printLinkList(ArrayList g)
    {
        
        ArrayList<T> Items = g;
        File file = new File("graph.dot");
	try (FileOutputStream fop = new FileOutputStream(file)) {
            file.createNewFile();
            StringBuilder content = new StringBuilder();
       /*     
            digraph foo {
        rankdir=LR;
        node [shape=record];
        edge [tailclip=false];
        a [label="{ <data> 12 | <ref> }"]
        b [label="{ <data> 99 | <ref> }"];
        c [label="{ <data> 37 | <ref> }"];
        d [shape=box];
        a:ref:c -> b:data [arrowhead=vee, arrowtail=dot, dir=both];
        b:ref:c -> c:data [arrowhead=vee, arrowtail=dot, dir=both];
        c:ref:c -> d      [arrowhead=vee, arrowtail=dot, dir=both];
    }*/
            
            content.append("Digraph G {\n"); 
            content.append("\t rankdir=LR;\n");
            content.append("\tnode [shape=record];\n");
            //content.append("\t graph [ordering=\"out\"];\n");
            //content.append("\t node [style=filled];\n");
            //content.append("label = \"PriorityQueue\";\n");
            //content.append("\t color=blue;\n rankdir=\"TB\";\n");
            //content.append("\t subgraph cluster0 {\n");
            //content.append("\t rank=\"same\";\n");
            String lastNode = Integer.toString(Items.size()-1);
            for (int i = 0; i < Items.size(); i++){
                content.append(i);
                content.append(" [label=\"{<data>" + Items.get(i) + "|<ref>}"+"\""+" ];\n");
                //a [label="{ <data> 12 | <ref> }"]
                
                //a [label="{ <data> 12 | <ref> }"]
            }
            for (int i = 0; i < Items.size() - 1; i++){
                //content.append(Items.get(i) +"\"];");
                content.append(Integer.toString(i) + ":ref->" + Integer.toString(i+1));
                content.append(":data [arrowhead=vee, arrowtail=dot, dir=both]\n");
                //a:ref:c -> b:data [arrowhead=vee, arrowtail=dot, dir=both];
                //a [label="{ <data> 12 | <ref> }"]
            
            }
            content.append("}\n"); //subgraph 1
            /*content.append("subgraph cluster0 {\n");
            content.append("rank=\"same\";\n");
            content.append("node [shape=record];\n");
            content.append("struct1 [shape=record,label=\"");
            content.append("--");
            for (int i = 1; i < Items.size(); i++){
                content.append("|");
                content.append(Items.get(i));
            }
            content.append("\"]\n");;
            
            content.append("}\n");//subgraph 2
            
            if(Items.size() > 1){
                content.append("struct1->1[style=invis];\n");
                //content.append(lastNode);
            }
            content.append("}\n");   */               
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content.toString());
            bw.close();
	} catch (IOException e) {
            System.out.println(e);
	}
    }
    public void printPriorityQueue(ArrayList<T> g)
    {   
        ArrayList<T> Items = g;
        File file = new File("graph.dot");
	try (FileOutputStream fop = new FileOutputStream(file)) {
            file.createNewFile();
            StringBuilder content = new StringBuilder();
            content.append("Digraph G {\n");            
            content.append("graph [ordering=\"out\"];\n");
            content.append("node [style=filled];\n");
            //content.append("label = \"PriorityQueue\";\n");
            content.append("color=blue;\n rankdir=\"TB\";\n");
             content.append("subgraph cluster0 {\n");
             content.append("rank=\"same\";\n");
             String lastNode = Integer.toString(Items.size()-1);
            for (int i = 1; i < Items.size(); i++){
                //if there is only one item
                if(Items.size() == 2)
                {
                    content.append("1");
                    content.append("[label=\"" + Items.get(1) +"\"];");
                }
                //add left child
                if(2*i < Items.size()){
                    
                    //t[label="anwar"]; s[label="Zilala"];t->s[label="1"];
                    content.append(i);
                    content.append("[label=\"" + Items.get(i) +"\"];");
                    content.append(2*i);
                    content.append("[label=\"" + Items.get(2*i) +"\"];");
                    content.append(i);
                    content.append("->");
                    content.append(2*i);
                    content.append("\n");
                }else{
                    //break;
                    
                    content.append("null");
                    content.append(2*i);
                    //content.append("[shape=point][style=invis];\n");
                    //content.append("[shape=point];\n");
                    content.append("[style=invis];\n");
                    content.append(i);
                    content.append("->");
                    content.append("null");
                    content.append(2*i);
                    content.append("[style=invis];\n");
                    int h = (int)(Math.log( 2*i ) / Math.log( 2 ));
                    int leftmostnode = (int)Math.pow(2,h);
                    //lastNode = "null"+ (2*i);
                    lastNode = "null"+ (leftmostnode);
                  
                }
                //add right child
                if(2*i+1 < Items.size()){
                    
                    content.append(i);
                    content.append("[label=\"" + Items.get(i) +"\"];");
                    content.append(2*i+1);
                    content.append("[label=\"" + Items.get(2*i+1) +"\"];");
                    
                    content.append(i);
                    content.append("->");
                    content.append(2*i+1);
                    content.append("\n");
                }else{
                    content.append("null");
                    content.append(2*i+1);
                    //content.append("[shape=point][style=invis];\n");
                    //content.append("[shape=point];\n");
                    content.append("[style=invis];\n");
                    content.append(i);
                    content.append("->");
                    content.append("null");
                    content.append(2*i+1);
                    content.append("[style=invis]\n;");
                    //lastNode = "null" + (2*i+1);
                    //break;
                }
            }
            content.append("}\n"); //subgraph 1
            content.append("subgraph cluster0 {\n");
            content.append("rank=\"same\";\n");
            content.append("node [shape=record];\n");
            content.append("struct1 [shape=record,label=\"");
            content.append("--");
            for (int i = 1; i < Items.size(); i++){
                content.append("|");
                content.append(Items.get(i));
            }
            content.append("\"]\n");;
            
            content.append("}\n");//subgraph 2
            
            //content.append(Items.size()-1);
            //if(Items.size() > 1){
            //    content.append(lastNode);
            //    content.append("->struct1[style=invis];\n");
           // }
            if(Items.size() > 1){
                content.append("struct1->1[style=invis];\n");
                //content.append(lastNode);
            }
            content.append("}\n");                  
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content.toString());
            bw.close();
	} catch (IOException e) {
            System.out.println(e);
	}
    }    
}
