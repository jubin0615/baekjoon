import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1,1,-1,1,-1};
    static int[] dy={1,-1,0,0,1,-1,-1,1};
    static void dfs(int x, int y){
        visited[x][y]=true;
        for(int k=0; k<8; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny] && map[nx][ny]==1)
                dfs(nx, ny);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            if(n==0 && m==0)
                break;
            map=new int[m][n];
            for(int i=0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++)
                    map[i][j]=Integer.parseInt(st.nextToken());
            }
            visited=new boolean[m][n];
            int count=0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
