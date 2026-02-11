import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int k=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());

        long[] prime=new long[k];
        PriorityQueue<Long> q=new PriorityQueue<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            prime[i]=Integer.parseInt(st.nextToken());
            q.offer(prime[i]);
        }

        long num=0;
        for(int i=0; i<n; i++){
            num=q.poll();
            for(int j=0; j<k; j++){
                long temp=num*prime[j];
                q.offer(temp);
                if(num%prime[j]==0)   
                    break;
            }
        }
        System.out.println(num);  

    }
}
