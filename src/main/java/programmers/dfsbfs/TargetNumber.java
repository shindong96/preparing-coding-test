package programmers.dfsbfs;

public class TargetNumber {
    class Solution {
        public int solution(int[] numbers, int target) {
            int answer = dfs(numbers, target, 0, 0, 0);
            return answer;
        }

        private int dfs(int[] numbers, int target, int idx, int value, int answer) {
            if (idx == numbers.length) {
                return value == target ? answer + 1 : answer;
            }

            answer = dfs(numbers, target, idx + 1, value + numbers[idx], answer);
            answer = dfs(numbers, target, idx + 1, value - numbers[idx], answer);

            return answer;
        }
    }
}
