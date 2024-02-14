package thisiscote.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UntilOneTest {

    @Test
    void test() {
        final UntilOne untilOne = new UntilOne();
        assertThat(untilOne.solution(25, 5)).isEqualTo(2);
    }
}
