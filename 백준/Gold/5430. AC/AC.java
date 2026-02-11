import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String p=br.readLine();
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();

            Deque<Integer> deq=new LinkedList<>();
            str=str.substring(1,str.length()-1);  //대괄호 제거
            if(!str.isEmpty()){
                String[] nums=str.split(",");
                for(String num:nums)
                    deq.offer(Integer.parseInt(num));
            }

            boolean isReversed=false;
            boolean isError=false;
            for(int i=0; i<p.length(); i++){
                if(p.charAt(i)=='R')
                    isReversed=!isReversed;
                else if(p.charAt(i)=='D'){
                    if(deq.isEmpty()){
                        System.out.println("error");
                        isError=true;
                        break;
                    }
                    if(isReversed)
                        deq.pollLast();
                    else deq.pollFirst();
                }
            }
            if(!isError){
                StringBuilder sb=new StringBuilder();
                sb.append("[");
                while(!deq.isEmpty()){
                    sb.append(isReversed?deq.pollLast():deq.pollFirst());
                    if(!deq.isEmpty())
                        sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
