import java.util.*;
import java.io.*;
public class Main {
    static int[][] forest, dp;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int n;
    static int dfs(int x, int y){  
        if(dp[x][y]!=0)   
            return dp[x][y];

        dp[x][y]=1;
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<n && forest[x][y]<forest[nx][ny]){
                dp[x][y]=Math.max(dp[x][y], dfs(nx,ny)+1);
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        forest=new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                forest[i][j]=Integer.parseInt(st.nextToken());
        }
        dp=new int[n][n];
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                result=Math.max(result,dfs(i,j));
        }
        System.out.println(result);
    }
}
