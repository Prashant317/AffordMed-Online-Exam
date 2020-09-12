/*     *************PROBLEM STATEMENT*************

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
string is valid. An input string is valid if –
 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.

*/

import java.util.*; 
  
class second { 
  
    
    static boolean isBalanced(String s) 
    { 
		Stack<Character>st = new Stack<>();
		for(char c: s.toCharArray()){
			if(c=='(' || c=='[' || c=='{'){
				st.push(c);
			}else if(c==')' && !st.isEmpty() && st.peek()=='('){
				st.pop();
			}else if(c==']' && !st.isEmpty() && st.peek()=='['){
				st.pop();
			}else if(c=='}' && !st.isEmpty() && st.peek()=='{'){
				st.pop();
			}else{
				return false;
			}
		}
		return st.isEmpty();
    } 
  
    public static void main(String[] args) 
    { 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		
		String s = sc.next();
        
        if (isBalanced(s)) 
            System.out.println("true"); 
        else
            System.out.println("false"); 
    } 
} 
