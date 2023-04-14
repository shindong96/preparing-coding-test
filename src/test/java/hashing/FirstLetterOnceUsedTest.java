package hashing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class FirstLetterOnceUsedTest {

    @Test
    void solution() {
        final FirstLetterOnceUsed firstLetterOnceUsed = new FirstLetterOnceUsed();

        assertAll(
                () -> assertThat(firstLetterOnceUsed.solution("statitsics")).isEqualTo(3),
                () -> assertThat(firstLetterOnceUsed.solution("aabb")).isEqualTo(-1),
                () -> assertThat(firstLetterOnceUsed.solution("stringshowtime")).isEqualTo(3),
                () -> assertThat(firstLetterOnceUsed.solution("abcdeabcdfg")).isEqualTo(5)
        );
    }

}
