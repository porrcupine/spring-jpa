package com.sk.examtasks;

import org.junit.Test;

/**
 * @author Sergey Kuzhel
 */
public class Arrays {
    private int[] testArr = {55, 133, 677, 13, 52, 66, -1, 0, 45, 99, 44};


    @Test
    public void main() {
        solutionFindMinPositiveValue(testArr);
    }

    public int solutionFindMinPositiveValue(int[] a) {
        int n = a.length;
        java.util.Arrays.sort(a);

        int j = 0;
        int temp[] = new int[n];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                temp[j] = a[i];
                j++;
            }
            temp[j] = a[a.length - 1];
        }

        int min;
        int result = 0;

        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] > 0) {
                min = temp[i];
                if (min + 1 < temp[i + 1]) {
                    result = min + 1;
                    break;
                }
            }

        }
        System.out.println(java.util.Arrays.toString(temp));
        System.out.println(result);

        return result;

    }
}
