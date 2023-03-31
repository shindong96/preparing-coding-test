package simulation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class ChairNumTest {

    @Test
    void check() {
        final ChairNum chairNum = new ChairNum();

        assertAll(
                () -> assertThat(chairNum.solution(6, 5, 12)).isEqualTo(new int[]{6, 3}),
                () -> assertThat(chairNum.solution(6, 5, 20)).isEqualTo(new int[]{2, 3}),
                () -> assertThat(chairNum.solution(6, 5, 30)).isEqualTo(new int[]{4, 3}),
                () -> assertThat(chairNum.solution(6, 5, 31)).isEqualTo(new int[]{0, 0})
        );
    }

}
