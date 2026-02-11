import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        int sum=0;
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
            sum+=nums[i];
        }
        Arrays.sort(nums);
        int center=nums[n/2];
        int mean=(int)Math.round((double)sum/n);
        int range=nums[n-1]-nums[0];

        Map<Integer, Integer> count=new HashMap<>();
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        int maxCount=Collections.max(count.values());
        List<Integer> modes=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:count.entrySet()) {
            if (entry.getValue() == maxCount)
                modes.add(entry.getKey());
        }
        Collections.sort(modes);
        int mode=(modes.size()>1)?modes.get(1):modes.get(0);  // mode 값이 여러개이면 두 번째로 작은 값 출력

        StringBuilder sb=new StringBuilder();
        sb.append(mean).append("\n");
        sb.append(center).append("\n");
        sb.append(mode).append("\n");
        sb.append(range);
        System.out.println(sb);
    }
}
