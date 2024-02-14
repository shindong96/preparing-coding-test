package thisiscote.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumCardTest {

    @Test
    void test() {
        final NumCard numCard = new NumCard();
        assertThat(numCard.solution(new int[][]{{3, 1, 2}, {4, 1, 4}, {2, 2, 2}})).isEqualTo(2);
    }

    @Test
    void test2() {
        final NumCard numCard = new NumCard();
        assertThat(numCard.solution(new int[][]{{7, 3, 1, 8}, {3, 3, 3, 4}})).isEqualTo(3);
    }
}
