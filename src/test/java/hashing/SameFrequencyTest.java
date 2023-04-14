package hashing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class SameFrequencyTest {

    @Test
    void solution() {
        final SameFrequency sameFrequency = new SameFrequency();
        assertAll(
                () -> assertThat(sameFrequency.solution("aaabc")).isEqualTo(new int[]{0, 2, 2, 3, 3}),
                () -> assertThat(sameFrequency.solution("aabb")).isEqualTo(new int[]{0, 0, 2, 2, 2}),
                () -> assertThat(sameFrequency.solution("abcde")).isEqualTo(new int[]{0, 0, 0, 0, 0}),
                () -> assertThat(sameFrequency.solution("abcdeabc")).isEqualTo(new int[]{0, 0, 0, 1, 1}),
                () -> assertThat(sameFrequency.solution("abbccddee")).isEqualTo(new int[]{1, 0, 0, 0, 0})
        );
    }

}
