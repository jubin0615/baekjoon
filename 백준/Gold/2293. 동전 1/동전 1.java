import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] coin=new int[n+1];
        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            coin[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coin);
        int[] dp=new int[k+1];  //dp[i]: i원을 만들 수 있는 경우의 수
        dp[0]=1;
        for(int i=1; i<=n; i++){
            for(int j=coin[i]; j<=k; j++){
                dp[j]+=dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
