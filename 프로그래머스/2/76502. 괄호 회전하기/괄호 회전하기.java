import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map=new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        int count=0;

        A:for(int i=0; i<s.length(); i++){
            // 회전
            String str=s.substring(i)+s.substring(0,i);

            // 닫힌 괄호로 시작하면 pass
            char start=str.charAt(0);
            if(start==')' || start=='}' || start==']') continue;

            ArrayDeque<Character> stack=new ArrayDeque<>();
            for(int j=0; j<str.length(); j++){
                char c=str.charAt(j);
                if(map.containsKey(c))
                    stack.push(c);  // 열린괄호면 push
                //닫힌 괄호일 때
                else{
                    if(stack.isEmpty()) continue A;

                    char temp=stack.pop();  //temp는 열린 괄호임
                    if(map.get(temp)!=c) continue A;
                }
            }
            if(stack.isEmpty()) count++;
        }
        return count;
    }
}