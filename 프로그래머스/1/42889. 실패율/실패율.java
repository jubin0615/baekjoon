import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int users=stages.length;

        int[] temp=new int[N+2];
        for(int i=0; i<users; i++)
            temp[stages[i]]++;

        HashMap<Integer, Double> fail=new HashMap<>();
        for(int i=1; i<=N; i++){
            if(temp[i]==0)
                fail.put(i,0.0);
            else{
                fail.put(i,(double)temp[i]/users);
                users-=temp[i];
            }
        }

        return fail.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}