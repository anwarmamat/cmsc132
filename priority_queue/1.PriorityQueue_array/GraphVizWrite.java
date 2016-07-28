

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author anwar
 */
public class GraphVizWrite<T> {
    private ArrayList<T> PQ;
    GraphVizWrite(T[] g, int size) {
    	PQ = new ArrayList<>();
    	for(int i = 0; i <= size; i++){
	    	PQ.add(g[i]);    
	    }
    }
    
    public void print()
    {   
        File file = new File("graph.dot");
	
		try{
            file.createNewFile();
            StringBuilder content = new StringBuilder();
            content.append("Digraph G {\n");
            
            content.append("graph [ordering=\"out\"];\n");
            content.append("node [style=filled];\n");
            //content.append("label = \"PriorityQueue\";\n");
            content.append("color=blue;\n rankdir=\"TB\";\n");
             content.append("subgraph cluster0 {\n");
             content.append("rank=\"same\";\n");
             String lastNode = Integer.toString(PQ.size()-1);
            for (int i = 1; i < PQ.size(); i++){
                //if there is only one item
                if(PQ.size() == 2)
                {
                    content.append("1");
                    content.append("[label=\"" + PQ.get(1) +"\"];");
                }
                //add left child
                if(2*i < PQ.size()){
                    
                    //t[label="anwar"]; s[label="Zilala"];t->s[label="1"];
                    content.append(i);
                    content.append("[label=\"" + PQ.get(i) +"\"];");
                    content.append(2*i);
                    content.append("[label=\"" + PQ.get(2*i) +"\"];");
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
                if(2*i+1 < PQ.size()){
                    
                    content.append(i);
                    content.append("[label=\"" + PQ.get(i) +"\"];");
                    content.append(2*i+1);
                    content.append("[label=\"" + PQ.get(2*i+1) +"\"];");
                    
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
            for (int i = 1; i < PQ.size(); i++){
                content.append("|");
                content.append(PQ.get(i));
            }
            content.append("\"]\n");;
            
            content.append("}\n");//subgraph 2
            
            //content.append(PQ.size()-1);
            //if(PQ.size() > 1){
            //    content.append(lastNode);
            //    content.append("->struct1[style=invis];\n");
           // }
            if(PQ.size() > 1){
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
