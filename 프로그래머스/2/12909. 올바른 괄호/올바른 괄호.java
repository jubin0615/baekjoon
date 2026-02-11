import java.util.*;
class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();

        char[] arr=s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='(')
                stack.add(arr[i]);
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}