import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map=new HashMap<>();

        for(int i=0; i< record.length; i++){
            String[] temp=record[i].split(" ");
            String command=temp[0];
            String id=temp[1];

            if(command.equals("Enter") || command.equals("Change")) {
                String nickname=temp[2];
                map.put(id,nickname);
            }
        }

        ArrayList<String> result=new ArrayList<>();

        for(int i=0; i< record.length; i++){
            String[] temp=record[i].split(" ");
            String command=temp[0];
            String id=temp[1];

            if(command.equals("Enter"))
                result.add(map.get(id)+"님이 들어왔습니다.");
            else if(command.equals("Leave"))
                result.add(map.get(id)+"님이 나갔습니다.");
        }
        return result.toArray(new String[0]);
    }
}