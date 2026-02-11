import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[] tree;
    static int[] leaf;
    static int n, root;
    public static void dfs(int node){
        if(tree[node].isEmpty())
            leaf[node]=1;
        for(int child:tree[node]){
            dfs(child);
            leaf[node]+=leaf[child];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        tree=new ArrayList[n];
        for(int i=0; i<n; i++)
            tree[i]=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int parent=Integer.parseInt(st.nextToken());
            if(parent==-1)
                root=i;
            else tree[parent].add(i);
        }
        int target=Integer.parseInt(br.readLine());
        leaf=new int[n];
        for(int i=0; i<n; i++)
            tree[i].removeIf(integer -> integer==target);
        if(target!=root)
            dfs(root);
        System.out.println(leaf[root]);
    }
}
