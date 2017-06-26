
import java.util.Stack;

public class Expression {
	Stack<Integer> operandS = new Stack<>();
	Stack<Character> operatorS = new Stack<>();
	
	private int calc(Character op, int a, int b){
		switch(op){
			case '*': return a * b;
			case '/': return a / b;
			case '+': return a + b;
			case '-': return a - b;
			default: return -1;
		}
	}
	private void operate(){
		int b = operandS.pop();        
        int a = operandS.pop();
        Character c = operatorS.pop();
        operandS.push(calc(c,a,b));
        System.out.println(operandS.peek());
	}
	
	public int rank(Character op){
		switch(op){
		case '*':
		case '/': return 5;
		case '+':
		case '-': return 3;
		default: return 10;
		}
	}
	public int eval(String expr){
		for(int i = 0; i < expr.length(); i++){
			if(expr.charAt(i)>='0' && expr.charAt(i)<='9'){
                int x = Character.getNumericValue(expr.charAt(i));
                operandS.push(x);
            }else{
            		int rank1 = rank(expr.charAt(i));
            		int rank2 = 10;
            		if(operatorS.isEmpty()){
            			operatorS.push(expr.charAt(i));
            		}else{
            				rank2 = rank(operatorS.peek());            			
            				if(rank1 > rank2){
            					operatorS.push(expr.charAt(i));
            					i++;
                            int b = Character.getNumericValue(expr.charAt(i));
                            operandS.push(b);
                            operate();
            				}else{
            					operate();
            					operatorS.add(expr.charAt(i));
            				}
            			}
            }	
		}
		while(!operatorS.isEmpty()) operate();
		return operandS.peek();
	}
	public static void main(String[] args){
		
		String expression = "8-4/2+5*3";
		
		Expression e = new Expression();
        int result = e.eval(expression);
        System.out.println(expression + "=" + result);
	}
}
