import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static String input;
    static StringBuilder sb=new StringBuilder();;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        input=br.readLine();
        visited=new boolean[input.length()];

        solve(0, input.length()-1);

        System.out.print(sb);

    }
    static void solve(int left, int right){
        if(left>right) return;

        char minChar=Character.MAX_VALUE;
        int minIdx=0;

        // 사전 순 가장 앞에 오는 문자 찾기
        for(int i=left; i<=right; i++){
            if(input.charAt(i)<minChar){
                minChar=input.charAt(i);
                minIdx=i;
            }
        }
        visited[minIdx]=true;

        for(int i=0; i<input.length(); i++){
            if(visited[i]) sb.append(input.charAt(i));
        }
        sb.append('\n');

        solve(minIdx+1, right);
        solve(left, minIdx-1);

    }
}