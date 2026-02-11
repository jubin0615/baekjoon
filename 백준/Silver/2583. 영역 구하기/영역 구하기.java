import java.util.*;
import java.io.*;
public class Main {
    static int[][] square;
    static int size,n,m;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static void dfs(int y, int x){
        square[y][x]=1;
        for(int k=0; k<4; k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<m && square[ny][nx]==0){
                size++;
                dfs(ny,nx);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        square=new int[m][n];
        for(int r=0; r<k; r++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++)
                    square[y][x]=1;
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(square[i][j]==0){
                    size=1;
                    dfs(i,j);
                    result.add(size);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int q:result)
            System.out.print(q+" ");
    }
}
