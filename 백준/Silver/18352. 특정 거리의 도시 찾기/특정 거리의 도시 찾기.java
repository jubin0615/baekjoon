import java.util.*;
import java.io.*;
public class Main {
    static int n, m, k, start;
    static ArrayList<Integer>[] city;
    static int[] visited;
    static void bfs(int node){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int i:city[current]){
                if(visited[i]==-1){
                    visited[i]=visited[current]+1;
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        start=Integer.parseInt(st.nextToken());
        city=new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            city[i]=new ArrayList<>();
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            city[a].add(b);
        }
        visited=new int[n+1];
        for(int i=1; i<=n; i++)
            visited[i]=-1;
        bfs(start);
        List<Integer> result=new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(visited[i]==k)
                result.add(i);
        }
        if(result.isEmpty())
            System.out.println("-1");
        else{
            Collections.sort(result);
            for(int ans:result)
                System.out.println(ans);
        }
    }
}