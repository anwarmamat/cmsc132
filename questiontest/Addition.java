/*
 * This class generates addition questions 
 */
package questiontest;

/**
 * @author anwar mamat
 */
public class Addition extends Question{
    Addition(int minv, int maxv){
        minValue = minv;
        maxValue = maxv;
        operator = "+";
        operand1 =(int)( Math.random()* maxValue + minValue);
        operand2 =(int)( Math.random()* maxValue + minValue);
    }

    @Override
    int getAnswer() {
        return operand1 + operand2;
    }
}
