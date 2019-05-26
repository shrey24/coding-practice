import java.util.*;

class InfixToPostfix{

    static int precedence(Character opr){
        int val = -1;
        switch(opr){
            case '+':
            case '-':
                val = 1;
                break;

            case '*':
            case '/':
                val = 2;
                break;

            case '^':
                val = 3;
        }
        return val;
    }

    static boolean isOperator(Character ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'|| ch == '^')
            return true;
        return false;
    }

    public static String infix2postfix(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix_exp = new StringBuilder();

        for(int i=0; i<exp.length(); i++){
            Character ch = exp.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch)){
                postfix_exp.append(ch);
            }
            else if(isOperator(ch)){
                if(stack.isEmpty()){
                    stack.push(ch);
                }
                else if(precedence(stack.peek()) >= precedence(ch)){
                    while(!stack.empty() && stack.peek() != '(' && precedence(stack.peek()) >= precedence(ch) ){
                        postfix_exp.append(stack.pop());
                    }
                    stack.push(ch);
                }
                else{
                    stack.push(ch);
                }
            }
            else if(ch.equals('(')){
                stack.push(ch);
            }
            else if(ch.equals(')')){
                while(stack.peek()!= '('){
                    postfix_exp.append(stack.pop());
                }
                stack.pop();
            }
        }

        while(!stack.empty()){
            postfix_exp.append(stack.pop());
        }

        return postfix_exp.toString();
    }

    public static void printResult(String exp){
        System.out.println(exp+" --> "+infix2postfix(exp));
    }

    public static void main(String[] args) {
        String exp1 = "a*b+c";
        String exp2 = "a+b*c";
        String exp3 = "a+b*c+d/x*y";
        String exp4 = "(a+b)*(c+d)/(x-y)";

        printResult(exp1);
        printResult(exp2);
        printResult(exp3);
        printResult(exp4);
    }
}