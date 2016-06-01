/*
 * Generates Random +,-,*,/ Questions
 * @author anwar mamat
 */
package questiontest;

import java.util.ArrayList;


/**
 * Generates 100 addition, multiplication, subtraction and 
 * division question. 
 * @author anwar
 */
public class QuestionTest {

    public static void main(String[] args) {
        ArrayList<Question> qList = new ArrayList<>();
        Question question = null;
        while(qList.size()<100){
            switch((int)(Math.random()*4)){
                case 0:
                    question = new Subtraction(1,99);break;    
                case 1:
                    question = new Addition(1,99);break;
                case 2:
                    question = new Multiplication(1,20);break;
                case 3:
                    question = new Division(1,20);break;   
            }
            
            if(!qList.contains(question)){
                qList.add(question);
            }
        }
        System.out.println("Questions:");
        int lineNum  = 1;
        for(Question q: qList){
            System.out.println(lineNum++ + ":\t" + q);
        }
        lineNum = 1;
        System.out.println("Answers:");
        for(Question q: qList){
            System.out.println(lineNum++ + ":\t" + q + " "+ q.getAnswer());
        }
    }
}
