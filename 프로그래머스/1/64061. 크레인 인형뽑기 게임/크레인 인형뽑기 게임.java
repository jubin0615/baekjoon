import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int n=board.length;
        //board의 각 열을 스택으로 만들기
        Stack<Integer>[] stack=new Stack[n+1];
        for(int i=0; i<n; i++){
            stack[i]=new Stack<>();
        }

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++) {
                if(board[i][j]!=0)
                    stack[j].push(board[i][j]);
            }
        }

        Stack<Integer> basket =new Stack<>();
        int count=0;
        for(int idx:moves){
            if(!stack[idx-1].isEmpty()){
                int doll=stack[idx-1].pop();
                if(!basket.isEmpty() && basket.peek()==doll){
                    basket.pop();
                    count+=2;
                }
                else basket.push(doll);
            }
        }
        return count;
    }
}