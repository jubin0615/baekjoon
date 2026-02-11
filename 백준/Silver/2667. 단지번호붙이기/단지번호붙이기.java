import java.util.*;
import java.io.*;
public class Main{
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    static int[][] danji;
    static int count=1;
    static int n;
    static void dfs(int a, int b){
        visited[a][b]=true;
        for(int i=0; i<4; i++){
            int x=a+dx[i];
            int y=b+dy[i];
            if(x>=0 && y>=0 && x<n && y<n && !visited[x][y] && danji[x][y]==1){
                count++;
                dfs(x,y);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        danji=new int[n][n];
        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<n; j++)
                danji[i][j]=str.charAt(j)-'0';
        }
        visited=new boolean[n][n];
        List<Integer> result=new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(danji[i][j]==1 && !visited[i][j]){
                    dfs(i,j);
                    result.add(count);
                    count=1;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int r: result){
            System.out.println(r);
        }
    }
} 