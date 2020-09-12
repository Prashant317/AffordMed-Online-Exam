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
    
        Deque<Character> stk = new ArrayDeque<Character>(); 
   
        for (int i = 0; i < s.length(); i++) { 
            char ch = s.charAt(i); 
  
            if (ch == '(' || ch == '[' || ch == '{') { 
                stk.push(ch); 
                continue; 
            } 
  
            if (stk.isEmpty()) 
                return false; 
  
            switch (ch) { 
            case ')': 
                stk.pop(); 
                if (ch == '{' || ch == '[') 
                    return false; 
                break; 
  
            case '}': 
                stk.pop(); 
                if (ch == '(' || ch == '[') 
                    return false; 
                break; 
  
            case ']': 
                stk.pop(); 
                if (ch == '(' || ch == '{') 
                    return false; 
                break; 
            } 
        } 
  
        return (stk.isEmpty()); 
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