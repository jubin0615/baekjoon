import java.util.*;
public class Main {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] data=new int[n];
       for(int i=0; i<n; i++)
           data[i]=sc.nextInt();
       Arrays.sort(data);
       int m=sc.nextInt();
       for(int i=0; i<m; i++){
           boolean find=false;
           int target=sc.nextInt();
           int start=0;
           int end=n-1;
           while(start<=end){
               int mid=data[(start+end)/2];
               if (mid>target)
                   end=(start+end)/2-1;
               else if(mid<target)
                   start=(start+end)/2+1;
               else {
                   find=true;
                   break;
               }
           }
           if(find)
               System.out.println(1);
           else System.out.println(0);
       }
    }
}
