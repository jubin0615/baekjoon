import java.io.*;
import java.util.*;
public class Main {
    static int[][] gear;
    static int gearNum,turn;
    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        gear=new int[5][8];
        for(int i=1; i<=4; i++){
            String str=br.readLine();
            for(int j=0; j<8; j++)
                gear[i][j]=str.charAt(j)-'0';
        }
        int k=Integer.parseInt(br.readLine());
        while(k-- >0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            gearNum=Integer.parseInt(st.nextToken());
            turn=Integer.parseInt(st.nextToken());
            d=new int[5];
            d[gearNum]=turn;
            checkDir(gearNum);
            gearTurn();
        }

        int point=0;
        if(gear[1][0]==1) point+=1;
        if(gear[2][0]==1) point+=2;
        if(gear[3][0]==1) point+=4;
        if(gear[4][0]==1) point+=8;
        System.out.println(point);
    }
    static void checkDir(int gearN){
        for(int i=gearN-1; i>0; i--){
            if(gear[i][2]!=gear[i+1][6])
                d[i]=-d[i+1];
            else break;
        }
        for(int i=gearN+1; i<=4; i++){
            if(gear[i][6]!=gear[i-1][2])
                d[i]=-d[i-1];
            else break;
        }
    }
    static void gearTurn(){
        int temp=0;
        for(int i=1; i<=4; i++){
            if(d[i]==1){
                temp=gear[i][7];
                for(int j=7; j>0; j--)
                    gear[i][j]=gear[i][j-1];
                gear[i][0]=temp;
            }
            if(d[i]==-1){
                temp=gear[i][0];
                for(int j=0; j<7; j++)
                    gear[i][j]=gear[i][j+1];
                gear[i][7]=temp;
            }
        }
    }
}
