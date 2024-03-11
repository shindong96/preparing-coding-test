package programmers.sort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SisoPair {

    int[] m = {2, 3, 4};

    public long solution(int[] weights) {
        long answer = 0;
        List<Integer> ws = new ArrayList<>();
        Map<Integer, Long> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int weight : weights) {
            ws.add(weight);
        }
        Collections.sort(ws);

        for (Integer w : ws) {
            answer += map.getOrDefault(w, 0L);
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        for (int i = 0; i < ws.size(); i++) {
            if (set.contains(ws.get(i))) {
                continue;
            }

            for (int j = i + 1; j < ws.size(); j++) {
                int w1 = ws.get(i);
                int w2 = ws.get(j);
                if (w1 == w2) {
                    continue;
                }

                if (isPair(w1, w2)) {
                    answer += map.get(w1);
                }
            }

            set.add(ws.get(i));
        }

        return answer;
    }

    public boolean isPair(int x, int y) {
        if (x == y) {
            return true;
        }

        if (x * m[2] < y) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            int a = x * m[i];

            for (int j = 0; j < i; j++) {
                int b = y * m[j];

                if (a < b) {
                    break;
                }

                if (a == b) {
                    return true;
                }
            }
        }
        return false;
    }
}
