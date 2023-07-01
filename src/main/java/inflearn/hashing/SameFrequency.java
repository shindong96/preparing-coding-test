package inflearn.hashing;

import java.util.HashMap;
import java.util.Map;

public class SameFrequency {

    public int[] solution(String s) {
        int[] answer = new int[5];
        final Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            final int value = map.getOrDefault(c, 0) + 1;
            map.put(c, value);
            if (value >= max) {
                max = value;
            }
        }
        final String s2 = "abcde";

        for (int i = 0; i < s2.length(); i++) {
            answer[i] = max - map.getOrDefault(s2.charAt(i), 0);
        }
        return answer;
    }

}
