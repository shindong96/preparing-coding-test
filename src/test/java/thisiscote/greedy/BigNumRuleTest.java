package thisiscote.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BigNumRuleTest {

    @Test
    void test() {
        final BigNumRule bigNumRule = new BigNumRule();
        assertThat(bigNumRule.solution(new int[]{2, 4, 5, 4, 6}, 8, 3)).isEqualTo(46);
    }
}
