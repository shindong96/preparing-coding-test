package thisiscote.greedy;

public class BigNumRule {

    public int solution(int[] n, int m, int k) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] >= first) {
                second = first;
                first = n[i];
            }
        }

        return first * m - (first - second) * (m % k);
    }
}
