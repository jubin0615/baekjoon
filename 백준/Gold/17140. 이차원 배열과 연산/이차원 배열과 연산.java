import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static int r,c,k;
    static int rowLen, colLen;
    static class Num implements Comparable<Num>{
        int n, count;
        public Num(int n, int count){
            this.n=n;
            this.count=count;
        }

        @Override
        public int compareTo(Num o){
            if(this.count==o.count)
                return this.n-o.n;

            return this.count-o.count;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken())-1;
        c=Integer.parseInt(st.nextToken())-1;
        k=Integer.parseInt(st.nextToken());

        arr=new int[3][3];
        rowLen=3;
        colLen=3;

        for(int i=0; i<3; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }

        int time=0;
        while(time<=100){
            if(r<rowLen && c<colLen && arr[r][c]==k){
                System.out.println(time);
                return;
            }
            if(rowLen>=colLen) R();
            else C();
            time++;
        }
        System.out.println(-1);
    }
    static void R(){
        int[][] temp =new int[101][101];
        int maxSize=0;

        for(int i=0; i<rowLen; i++){
            HashMap<Integer, Integer> map=new HashMap<>();
            // 각 숫자별로 등장횟수 세기
            for(int j=0; j<colLen; j++){
                if(arr[i][j]==0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j],0)+1);
            }

            // hashmap의 데이터를 list로 옮기기
            List<Num> list=new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry:map.entrySet())
                list.add(new Num(entry.getKey(), entry.getValue()));
            //리스트 정렬
            Collections.sort(list);

            int k=0;
            for(Num num:list){
                if(k>=100) break;
                temp[i][k]=num.n;
                temp[i][k+1]=num.count;
                k+=2;
            }
            maxSize=Math.max(maxSize, k);
        }
        colLen=maxSize;   // 열 길이 갱신
        arr=temp;   // 배열을 통째로 교체
    }

    // R연산과 동일(인덱스만 바뀜)
    static void C(){
        int[][] temp =new int[101][101];
        int maxSize=0;

        for(int i=0; i<colLen; i++){
            HashMap<Integer, Integer> map=new HashMap<>();

            for(int j=0; j<rowLen; j++){
                if(arr[j][i]==0) continue;
                map.put(arr[j][i], map.getOrDefault(arr[j][i],0)+1);
            }

            List<Num> list=new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry: map.entrySet())
                list.add(new Num(entry.getKey(), entry.getValue()));

            Collections.sort(list);

            int k=0;
            for(Num num:list){
                if(k>=100) break;
                temp[k][i]=num.n;
                temp[k+1][i]=num.count;
                k+=2;
            }
            maxSize=Math.max(maxSize, k);
        }
        rowLen=maxSize;
        arr=temp;
    }
}
