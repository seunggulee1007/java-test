package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> receive = new HashMap<>();
        Map<String, Map<String, Integer>> give = new HashMap<>();
        for (String friend : friends) {
            receive.put(friend, new HashMap<>());
            give.put(friend, new HashMap<>());
        }
        for (String gift : gifts) {
            String[] giftSplit = gift.split(" ");
            String giver = giftSplit[0];
            String receiver = giftSplit[1];
            give.get(giver).put(receiver, give.get(giver).getOrDefault(receiver, 0)+1);
            receive.get(receiver).put(giver, receive.get(receiver).getOrDefault(giver, 0)+1);
        }
        return answer;
    }

}
