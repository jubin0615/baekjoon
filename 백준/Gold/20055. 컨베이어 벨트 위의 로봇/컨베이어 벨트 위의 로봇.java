import java.io.*;
import java.util.*;
public class Main {
    static int n,k;
    static int[] A;
    static boolean[] robot;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        A=new int[2*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<2*n; i++)
            A[i]=Integer.parseInt(st.nextToken());

        robot=new boolean[n];
        System.out.println(move());
    }
    static int move(){
        int step=0;
        while(check()){
            step++;

            int temp=A[2*n-1];
            for(int i=2*n-1; i>0; i--)
                A[i]=A[i-1];
            A[0]=temp;

            for(int i=n-1; i>0; i--)
                robot[i]=robot[i-1];
            robot[0]=false;
            robot[n-1]=false;

            for(int i=n-1; i>0; i--){
                if(A[i]>=1 && robot[i-1] && !robot[i]){
                    A[i]--;
                    robot[i]=true;
                    robot[i-1]=false;
                }
            }
            if(A[0]>0 && !robot[0]){
                robot[0]=true;
                A[0]--;
            }
        }
        return step;
    }
    static boolean check(){
        int count=0;
        for(int i=0; i<2*n; i++){
            if(A[i]==0)
                count++;
        }
        if(count>=k)
            return false;
        return true;
    }
}
