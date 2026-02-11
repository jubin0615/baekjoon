import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap=new HashMap<>();
        HashMap<String, Integer> playMap=new HashMap<>();   // 각 장르별 재생 횟수의 합

        for(int i=0; i<genres.length; i++){

            // 해시맵에 key가 존재하지 않으면 키 넣고 value 넣을 틀을 만들어야함
            if(!genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], new ArrayList<>());
                playMap.put(genres[i],0);
            }
            genreMap.get(genres[i]).add(new int[]{i, plays[i]});
            playMap.put(genres[i], playMap.get(genres[i])+plays[i]);
        }
        List<Map.Entry<String, Integer>> list=new ArrayList<>(playMap.entrySet());
        list.sort((o1, o2)->o2.getValue().compareTo(o1.getValue()));

        ArrayList<Integer> answer=new ArrayList<>();
        for(Map.Entry<String, Integer> entry:list){
            String genre=entry.getKey();  // 합이 더 큰 장르부터 get

            ArrayList<int[]> songs=genreMap.get(genre);
            songs.sort((s1,s2)->{
                if(s1[1]==s2[1]) return s1[0]-s2[0];
                return s2[1]-s1[1];
            });

            answer.add(songs.get(0)[0]);
            if(songs.size()>1)
                answer.add(songs.get(1)[0]);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}