/*
 * Question abstract class
 */
package questiontest;

/**
 *
 * @author anwar mamat
 */
public abstract class Question {
    protected int minValue;
    protected int maxValue;
    protected int operand1;
    protected int operand2;
    protected String operator;
    @Override
    public String toString(){
        return (operand1 + " " + getOpeator() + " " + operand2)+" =";
    }
    
    private String getOpeator(){
        return operator;
    }
    
    abstract int getAnswer();
    /**
     * checks if two questions are same
     * @param obj another question
     * @return true two questions same, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        Question q = (Question)obj;
        if(operand1 == q.operand1 
                && operand2 == q.operand2 
                && this.getOpeator().equals(q.getOpeator())){
            return true;
        }else{
            return false;
        }            
    }
}
