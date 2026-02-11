import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] A=new int[N];
        String[] str=br.readLine().split(" ");
        for(int i=0; i<N; i++)
            A[i]=Integer.parseInt(str[i]);
        int[] ans=new int[N];

        Stack<Integer> myStack=new Stack<>();
        myStack.push(0);
        for(int i=1; i<N; i++){
            while(!myStack.isEmpty() && A[myStack.peek()]<A[i])
                ans[myStack.pop()]=A[i];
            myStack.push(i);
        }
        while(!myStack.isEmpty())
            ans[myStack.pop()]=-1;
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++)
            bw.write(ans[i]+" ");
        bw.write("\n");
        bw.flush();

    }
}
