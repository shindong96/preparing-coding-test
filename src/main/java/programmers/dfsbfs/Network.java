package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    class Solution {
        boolean[] flag;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            flag = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!flag[i]) {
                    bfs(i, computers);
                    answer++;
                }
            }

            return answer;
        }

        private void bfs(int idx, int[][] computers) {
            Queue<Integer> q = new LinkedList<>();
            q.add(idx);

            while (!q.isEmpty()) {
                int target = q.remove();
                for (int i = 0; i < computers.length; i++) {
                    if (flag[i]) {
                        continue;
                    }

                    if (computers[target][i] == 1) {
                        flag[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}
