package ru.melnikov.task;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

class ReplacerTest {

    @org.junit.jupiter.api.Test
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10})
    void replace(int m) {
        Replacer replacer = new Replacer();
        int data[] =  {90, 81, 72,63, 54, 45, 36, 27, 18, 9,11};
        int[] test_result = resultValidator(data, m);
        Arrays.stream(data).forEach(System.out::print);
        System.out.println("\n");
        replacer.replace(data, m);
        assertArrayEquals(test_result,data);
    }

    int[] resultValidator(int[] source, int m) {
        int[] left = Arrays.copyOfRange(source, 0, m);
        int[] right = Arrays.copyOfRange(source, m, source.length);
        return IntStream.concat(Arrays.stream(right), Arrays.stream(left)).toArray();
    }
}