import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] D=new int[n+1];   // 연산 횟수
        for(int i=2; i<=n; i++){
            D[i]=D[i-1]+1;   // 1빼는 경우는 무조건 포함
            if(i%2==0) D[i]=Math.min(D[i], D[i/2]+1);
            if(i%3==0) D[i]=Math.min(D[i], D[i/3]+1);
        }
        System.out.println(D[n]);
    }
}
