import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[][] A=new int[n][2];
        for (int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            A[i][0]= Integer.parseInt(st.nextToken());
            A[i][1]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A,new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        int count=1;
        int end=A[0][1];
        for(int i=1; i<n; i++){
            if(A[i][0]>=end){
                end=A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}