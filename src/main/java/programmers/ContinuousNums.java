package programmers;

public class ContinuousNums {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] sumNumList = new int[sequence.length];
        int[] countInit = new int[sequence.length];
        int maxSize = sequence.length;
        int endIdx = sequence.length - 1;
        int startIdx = sequence.length - 1;

        while (startIdx >= 0 && endIdx - startIdx + 1 <= maxSize) {
            if (endIdx != sequence.length - 1 && countInit[endIdx] == 0) {
                sumNumList[endIdx] = sumNumList[endIdx + 1] - sequence[endIdx + 1];
                countInit[endIdx]++;
            }
            sumNumList[endIdx] += sequence[startIdx];

            if (sumNumList[endIdx] > k) {
                endIdx--;
            } else if (sumNumList[endIdx] == k) {
                maxSize = endIdx - startIdx + 1;
                answer[0] = startIdx;
                answer[1] = endIdx;
                endIdx--;
            }

            startIdx--;
        }
        return answer;
    }
}
