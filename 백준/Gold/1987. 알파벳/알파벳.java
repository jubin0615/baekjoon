import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int answer=0;
    static char[][] board;
    static boolean[] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static void dfs(int x, int y, int count){
        answer=Math.max(answer, count);
        visited[board[x][y]-'A']=true;

        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[board[nx][ny]-'A'])
                dfs(nx,ny,count+1);
        }
        visited[board[x][y]-'A']=false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board=new char[n][m];
        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<m; j++)
                board[i][j]=str.charAt(j);
        }
        visited=new boolean[26];
        dfs(0,0,1);
        System.out.println(answer);
    }
}