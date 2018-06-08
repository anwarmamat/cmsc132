/*
 * This class generates division questions 
 */
package questiontest;

/**
 * @author anwar mamat
 */
public class Division extends Question{
    Division(int minv, int maxv){
        minValue = minv;
        maxValue = maxv;
        operator = "/";

        operand2 =(int)( Math.random()* maxValue + minValue + 1);
        operand1 = operand2 * (int)( Math.random()* maxValue + minValue);
    }

    @Override
    int getAnswer() {
        return operand1 / operand2;
    }
}
