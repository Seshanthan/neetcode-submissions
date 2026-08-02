class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s= new Stack<>();
        for(String i:tokens){
            if(i.equals("+")){
                int num1=s.pop();
                int num2=s.pop();
                int num3=num1+num2;
                s.push(num3);
            }
            else if(i.equals("-")){
                int num1=s.pop();
                int num2=s.pop();
                int num3=num2-num1;
                s.push(num3);
            }
            else if(i.equals("*")){
                int num1=s.pop();
                int num2=s.pop();
                int num3=num1*num2;
                s.push(num3);
            }
            else if(i.equals("/")){
                int num1=s.pop();
                int num2=s.pop();
                int num3=num2/num1;
                s.push(num3);
            }
            else{
                s.push(Integer.parseInt(i));
            }
        }
        return s.pop();
    }
}