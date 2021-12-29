package ru.melnikov.task;

import java.util.Arrays;

public class Replacer {

    public void replace(int[] source, int m) {
        if (m < 0 || m >= source.length) throw new IllegalArgumentException("M must be between 0 " + source.length);
        int counter = source.length;
        for (int i = 0; i < m; i++) {
            int nextIdx = i;
            int itemValue = source[i];
            do {
                nextIdx = calcNextIndex(nextIdx, m, source.length);
                int oldValue = source[nextIdx];
                source[nextIdx] = itemValue;
                counter--;
                itemValue = oldValue;
            } while (nextIdx != i);
            if (counter == 0) return;
        }
    }

    private int calcNextIndex(int index, int m, int size) {
        int min = Math.min(m, size - m);
        int idx;
        if (m <= size / 2) {
            idx = size - m > m ? size - m + index : index + m;
        } else {
            idx = index + min;
        }
        return idx >= size ? idx - size : idx;
    }

}
