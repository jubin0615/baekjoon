import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        // 기간 세는 배열
        int[] answer=new int[prices.length];

        // 스택으로 가격 비교(인덱스를 스택에 저장)
        Stack<Integer> stack=new Stack<>();
        stack.push(0);

        for(int i=1; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]){
                int idx=stack.pop();
                answer[idx]=i-idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx=stack.pop();
            answer[idx]=prices.length-idx-1;
        }
        return answer;
    }
}