import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, L;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        map =new int[n][n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }

        int count=0;

        for(int i=0; i<n; i++){
            if(checkRow(i)) count++;
            if(checkCol(i)) count++;
        }

        System.out.println(count);

    }
    static boolean checkRow(int row){
        boolean[] check=new boolean[n];

        for(int i=0; i<n-1; i++){
            if(map[row][i]== map[row][i+1]) continue;
            if(Math.abs(map[row][i]- map[row][i+1])>1) return false;

            if(map[row][i]> map[row][i+1]){
                for(int j=1; j<=L; j++){
                    if(i+j>=n || map[row][i+j]!=map[row][i+1] || check[i+j]) return false;
                    else check[i+j]=true;
                }
            }
            else{
                for(int j=0; j<L; j++){
                    if(i-j<0 || map[row][i-j]!=map[row][i] || check[i-j]) return false;
                    else check[i-j]=true;
                }
            }
        }
        return true;

    }
    static boolean checkCol(int col){
        boolean[] check=new boolean[n];

        for(int i=0; i<n-1; i++){
            if(map[i][col]==map[i+1][col]) continue;
            if(Math.abs(map[i][col]-map[i+1][col])>1) return false;

            if(map[i][col]> map[i+1][col]){
                for(int j=1; j<=L; j++){
                    if(i+j>=n || map[i+j][col]!=map[i+1][col] || check[i+j]) return false;
                    else check[i+j]=true;
                }
            }
            else{
                for(int j=0; j<L; j++){
                    if(i-j<0 || map[i-j][col]!=map[i][col] || check[i-j]) return false;
                    else check[i-j]=true;
                }
            }
        }
        return true;

    }
}
