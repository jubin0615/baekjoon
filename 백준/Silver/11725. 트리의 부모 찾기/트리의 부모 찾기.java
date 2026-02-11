import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static List<Integer> node[];
    static boolean[] visited;
    static int[] parent;
    static void dfs(int idx){
        visited[idx]=true;
        for(int num:node[idx]){
            if(!visited[num]){
                parent[num]=idx;
                dfs(num);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        node=new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            node[i]=new ArrayList<Integer>();
        for(int i=1; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        visited=new boolean[n+1];
        parent=new int[n+1];
        dfs(1);
        for(int i=2; i<=n; i++)
            System.out.println(parent[i]);
    }
}