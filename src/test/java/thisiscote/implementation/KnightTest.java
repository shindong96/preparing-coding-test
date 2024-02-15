package thisiscote.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class KnightTest {

    @Test
    void test() {
        final Knight knight = new Knight();
        assertThat(knight.solution('a', 1)).isEqualTo(2);
    }
}
