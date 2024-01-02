package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class ChangingWord {

    class Solution {
        public int solution(String begin, String target, String[] words) {
            int size = words.length;
            Word b = new Word(begin.toCharArray());
            Word t = new Word(target.toCharArray());
            Word[] w = new Word[size];
            boolean noAnswer = true;

            for (int i = 0; i < size; i++) {
                w[i] = new Word(words[i].toCharArray());

                if (words[i].equals(target)) {
                    noAnswer = false;
                }
            }

            if (noAnswer) {
                return 0;
            }

            Queue<Word> q = new LinkedList<>();
            q.add(b);

            while (!q.isEmpty()) {
                Word word = q.remove();

                for (int i = 0; i < size; i++) {
                    if (w[i].value != 0) {
                        continue;
                    }

                    if (word.canChange(w[i])) {
                        if (w[i].isSame(t)) {
                            return word.value + 1;
                        }
                        w[i].value = word.value + 1;
                        q.add(w[i]);
                    }
                }
            }

            return 0;
        }

        class Word {
            char[] spellings;
            int value;

            public Word(char[] spellings) {
                this.spellings = spellings;
                this.value = 0;
            }

            public boolean isSame(Word w) {
                for (int i = 0; i < spellings.length; i++) {
                    if (this.spellings[i] != w.spellings[i]) {
                        return false;
                    }
                }
                return true;
            }

            public boolean canChange(Word w) {
                int count = 0;
                for (int i = 0; i < spellings.length; i++) {
                    if (this.spellings[i] != w.spellings[i]) {
                        count++;
                    }
                }

                return count == 1;
            }
        }
    }
}
