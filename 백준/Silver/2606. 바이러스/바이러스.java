import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[]computers;
    static boolean[] visited;
    static int count=0;
    static void DFS(int start){
        count++;
        visited[start]=true;
        for(int i:computers[start]){
            if(!visited[i])
                DFS(i);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int connections =Integer.parseInt(br.readLine());
        computers=new ArrayList[num+1];
        for (int i = 1; i< num+1; i++)
            computers[i]=new ArrayList<Integer>();
        for(int i=0; i<connections; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }
        visited=new boolean[num+1];
        DFS(1);
        System.out.println(count-1);
    }
}