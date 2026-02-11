import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap=new HashMap<>();
        HashMap<String, Integer> count=new HashMap<>();


        for(int i=0; i<report.length; i++){
            String[] name=report[i].split(" ");
            String userId=name[0];
            String reportedId=name[1];

            if(!reportMap.containsKey(reportedId)){
                reportMap.put(reportedId, new HashSet<>());
            }
            // 신고한 사람의 아이디를 value로 넣는게 맞음. 신고자에게 메일을 보내주는 것이기 때문
            reportMap.get(reportedId).add(userId);
        }
        for(Map.Entry<String, HashSet<String>> entry : reportMap.entrySet()){
            if(entry.getValue().size()>=k){
                for(String uid: entry.getValue())
                    count.put(uid,count.getOrDefault(uid,0)+1);
            }
        }

        int[] answer=new int[id_list.length];
        for(int i=0; i< id_list.length; i++){
            answer[i]=count.getOrDefault(id_list[i],0);
        }
        
        return answer;
    }
}