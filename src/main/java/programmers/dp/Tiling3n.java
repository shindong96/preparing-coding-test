package programmers.dp;

public class Tiling3n {

    public int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }

        long[] cache = new long[n + 1];
        cache[2] = 3;
        cache[0] = 1;

        for (int i = 4; i <= n; i += 2) {
            if (cache[i - 2] < cache[i - 4]) {
                cache[i] += 1000000007;
            }

            cache[i] = (cache[i] + (4 * cache[i - 2] - cache[i - 4])) % 1000000007;
        }

        return (int) cache[n];
    }
}
