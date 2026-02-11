import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] A=new int[N];
        for(int i=0; i<A.length; i++)
            A[i]=sc.nextInt();
        Arrays.sort(A);
        int count=0;
        for(int k=0; k<N; k++) {
            int i=0;
            int j=N-1;
            while(i<j){
                if(A[i]+A[j]==A[k]){
                    if(i==k)
                        i++;
                    else if(j==k)
                        j--;
                    else if(i!=k && j!=k){
                        count++;
                        break;
                    }
                } else if(A[i]+A[j]>A[k]){
                    j--;
                } else i++;
            }
        }
        System.out.println(count);
    }
}