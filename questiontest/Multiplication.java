/*
 * This class generates multiplication question 
 */
package questiontest;

/**
 * @author anwar mamat
 */
public class Multiplication extends Question{
    Multiplication(int minv, int maxv){
        minValue = minv;
        maxValue = maxv;
        operator = "*";
        operand1 =(int)( Math.random()* maxValue + minValue);
        operand2 =(int)( Math.random()* maxValue + minValue);
    }

    @Override
    int getAnswer() {
        return operand1 * operand2;
    }
}
