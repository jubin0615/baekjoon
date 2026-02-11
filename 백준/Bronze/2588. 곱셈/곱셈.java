import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        String B=sc.next();
        char[]b=B.toCharArray();
        System.out.println(A*(b[2]-'0'));
        System.out.println(A*(b[1]-'0'));
        System.out.println(A*(b[0]-'0'));
        System.out.println(A*Integer.parseInt(B));
    }
}