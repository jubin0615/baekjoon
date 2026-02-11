import java.util.*;
import java.io.*;
public class Main {
    static int A,B,C;
    static boolean[][][] visited;
    static Set<Integer> result=new TreeSet<>();
    static class Water{
        int A,B,C;
        public Water(int a, int b, int c){
            A=a;
            B=b;
            C=c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        visited=new boolean[201][201][201];  //A,B,C의 범위가 200 이하라서
        bfs();

        for(int i:result){
            System.out.print(i);
            System.out.print(" ");
        }

    }
    static void bfs(){
        Queue<Water> q=new ArrayDeque<>();
        q.add(new Water(0,0,C));
        visited[0][0][C]=true;
        while(!q.isEmpty()){
            Water cur=q.poll();
            if(cur.A==0){
                result.add(cur.C);
            }
            int tempA,tempB,tempC;
            // <물 옮기는 6개 경우>
            // 1. A->B
            tempA=cur.A-Math.min(cur.A, B-cur.B);
            tempB=cur.B+Math.min(cur.A, B-cur.B);
            tempC=cur.C;
            checkWater(tempA, tempB, tempC, q); //중복 검사 후 큐에 저장하는 것까지
            // 2. B->C
            tempA=cur.A;
            tempB=cur.B-Math.min(cur.B, C-cur.C);
            tempC=cur.C+Math.min(cur.B, C-cur.C);
            checkWater(tempA, tempB, tempC, q);
            // 3. C->A
            tempA=cur.A+Math.min(cur.C, A-cur.A);
            tempB=cur.B;
            tempC=cur.C-Math.min(cur.C, A-cur.A);
            checkWater(tempA, tempB, tempC, q);
            // 4. A->C
            tempA=cur.A-Math.min(cur.A,C-cur.C);
            tempB=cur.B;
            tempC=cur.C+Math.min(cur.A,C-cur.C);
            checkWater(tempA, tempB, tempC, q);
            // 5. C->B
            tempA=cur.A;
            tempB=cur.B+Math.min(cur.C, B-cur.B);
            tempC=cur.C-Math.min(cur.C, B-cur.B);
            checkWater(tempA, tempB, tempC, q);
            // 6. B->A
            tempA=cur.A+Math.min(cur.B, A-cur.A);
            tempB=cur.B-Math.min(cur.B, A-cur.A);
            tempC=cur.C;
            checkWater(tempA, tempB, tempC, q);
        }
    }
    static void checkWater(int tempA, int tempB, int tempC, Queue<Water> q){
        if(!visited[tempA][tempB][tempC]){
            visited[tempA][tempB][tempC]=true;
            q.add(new Water(tempA, tempB, tempC));
        }
    }
}
