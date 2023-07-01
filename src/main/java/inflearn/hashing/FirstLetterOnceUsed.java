package inflearn.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstLetterOnceUsed {
    public int solution(String s) {
        final Map<Character, Integer> map = new LinkedHashMap<>();
        final Map<Character, Integer> mapIdx = new LinkedHashMap<>();
        int i = 0;
        for (char c : s.toCharArray()) {
            mapIdx.put(c, i + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            i++;
        }

        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                return mapIdx.get(key);
            }
        }
        return -1;
    }
}
