package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoryScore {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        final HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        final ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < photo.length; i++) {
            final String[] memberNames = photo[i];

            int a = 0;
            for (String memberName : memberNames) {
                a += map.getOrDefault(memberName, 0);
            }
            list.add(a);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
