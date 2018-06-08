/*
 * This class generates subtraction question 
 */
package questiontest;

/**
 * @author anwar mamat
 */
public class Subtraction extends Question{
    Subtraction(int minv, int maxv){
        minValue = minv;
        maxValue = maxv;
        operator = "-";
        /**
         * operand1 = random int, operand2 = random int + operand 2. 
         *  operand1 - operand1 >0
         */
        operand2 =(int)( Math.random()* maxValue + minValue);
        operand1 = operand2 + (int)( Math.random()* maxValue + minValue);
    }

    @Override
    int getAnswer() {
        return operand1 - operand2;
    }
}
