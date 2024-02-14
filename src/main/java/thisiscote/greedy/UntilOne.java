package thisiscote.greedy;

public class UntilOne {

    public int solution(int n, int k) {
        int answer = 0;

        while (n != 1) {
            if (n % k == 0) {
                answer += 1;
                n /= k;
            } else {
                answer += n % k;
                n -= n % k;
                if (n == 0) {
                    n = 1;
                    answer--;
                }
            }
        }
        return answer;
    }
}
