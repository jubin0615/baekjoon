import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        int[] A=new int[(int)Math.sqrt(b)+1];
        for(int i=2; i<A.length; i++)
            A[i]=i;
        for(int i=2; i<=Math.sqrt(b); i++){
            if(A[i]==0)
                continue;
            for(int j=i*2; j<A.length; j+=i)
                A[j]=0;
        }
        ArrayList<Integer> primeNum=new ArrayList<>();
        for(int i=2; i<A.length; i++){
            if(A[i]!=0)
                primeNum.add(i);
        }
        HashSet<Long> count=new HashSet<>();
        for(int i=0; i<primeNum.size(); i++){
            long base=primeNum.get(i);
            long power=base*base;
            while(power<=b){
                if(power>=a)
                    count.add(power);
                if (power > Long.MAX_VALUE / base) break;
                power*=base;
            }
        }
        System.out.println(count.size());
    }
}