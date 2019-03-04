package com.sk.examtasks;

import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.time.LocalTime;
import java.util.*;

/**
 * @author Sergey Kuzhel
 */
public class ArraysTasks {
    private int[] testArr = {1, 2, 147, 1, 55, 3, 677, 13, 52, 66, -1, 0, 45, 99, 44};
    private int[] testArr2 = {42, 32, 32, 34, 32, 22, 12, 12};
    private int[] testArr3 = {9, 3, 9, 3, 9, 7, 9};
    private int[] testArr4 = {9};
    private int[] testArr5 = {10, 2, 5, 1, 8, 20};
    private int[] testArr6 = {8, 4, 8, 9, 7};

    private int[] A = new int[]{10, 2, 5, 1, 8, 20, 4, 14, 23, 56, 76};
    private int[] B = new int[]{10, 3, 6, 8, 3, 6, 1, 9};

    @Test
    public void main() {
//        solutionFindMinPositiveValue(testArr);

//        for (int i : testArr) {
//            getBinaryGap(i);
//        }

        // oddOccurencesInArray1(testArr4);
        //oddOccurencesInArray1(testArr3);
        // oddOccurencesInArray1(testArr2);
        //  oddOccurencesInArray1(testArr);
       // trianglePerimeter(testArr6);

        System.out.println(solutionTask2(25,4));
        System.out.println(solutionTask2(8,0));
        System.out.println(solutionTask2(10,10));
        System.out.println(solutionTask(A));
        System.out.println(solutionTask(B));
    }

    public void performanceArrayLinkedList() {
        Integer[] mas1 = new Integer[1];
        Integer[] mas2 = new Integer[1];
        ArrayList<Integer> linked = new ArrayList<>(Arrays.asList(mas1));
        LinkedList<Integer> array = new LinkedList<>(Arrays.asList(mas2));

        int n = 400000;
        LocalTime start;
        LocalTime finish;
        start = LocalTime.now();
        System.out.println(start);
        for (int i = 0; i < n; i++) {
            //linked.add(i, 132);
            // array.add(i, 132);
        }
        // System.out.println(linked.get(linked.size()/2 - 1));
        finish = LocalTime.now();
        System.out.println(finish);
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

    /**
     * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
     * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
     * Write a function:
     * class Solution { public int solution(int N); }
     * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
     * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
     * Write an efficient algorithm for the following assumptions:
     * N is an integer within the range [1..2,147,483,647].
     *
     * @alorithm get a binary representation
     * find first gap
     * check if another gap exists
     * if exists
     * check what of both gaps is biger
     * get biger gap
     * else
     * get gap
     * return gap
     */
    public int getBinaryGap(int digit) {
        String binaryString = Integer.toBinaryString(digit);
        char[] chars = binaryString.toCharArray();
        int gap = 0;
        int maxGap = 0;
        boolean isGapStarts = false;
        boolean isGapEnds = false;
        int j = 1;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '1':
                    gap = 0;
                    break;
                case '0':
                    if ((i != 0) && (i != chars.length - 1)) {
                        isGapStarts = (chars[i - j] == '1');
                        isGapEnds = (chars[i + 1] == '1');
                        j++;
                    }
                    if (isGapStarts) {
                        gap++;
                        if (gap > maxGap && isGapEnds) {
                            maxGap = gap;
                        }
                        if (isGapEnds) {
                            isGapStarts = false;
                            isGapEnds = false;
                            j = 1;
                        }
                    }
                    break;
            }
        }
        System.out.println("for int : " + digit + "\nbinary rep.: " + binaryString + "\nmax gap is: " + maxGap);
        return maxGap;
    }


    /**
     * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
     * <p>
     * For example, in array A such that:
     * A[0] = 9  A[1] = 3  A[2] = 9
     * A[3] = 3  A[4] = 9  A[5] = 7
     * A[6] = 9
     * <p>
     * the elements at indexes 0 and 2 have value 9,
     * the elements at indexes 1 and 3 have value 3,
     * the elements at indexes 4 and 6 have value 9,
     * the element at index 5 has value 7 and is unpaired.
     * <p>
     * Write a function:
     * <p>
     * class Solution { public int solution(int[] A); }
     * <p>
     * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
     * <p>
     * For example, given array A such that:
     * A[0] = 9  A[1] = 3  A[2] = 9
     * A[3] = 3  A[4] = 9  A[5] = 7
     * A[6] = 9
     * <p>
     * the function should return 7, as explained in the example above.
     * <p>
     * Write an efficient algorithm for the following assumptions:
     * <p>
     * N is an odd integer within the range [1..1,000,000];
     * each element of array A is an integer within the range [1..1,000,000,000];
     * all but one of the values in A occur an even number of times.
     */
    public int oddOccurencesInArray(int[] a) {
        Arrays.sort(a);
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 0;

            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if ((count % 2 != 0) || (a.length == 1)) {
                result = a[i];
            }
        }
        System.out.println(result);
        return result;
    }

    public int oddOccurencesInArray1(int[] a) {
        Arrays.sort(a);
        int count = 0;
        int result = 0;
        int j = a[0];
        for (int i = 0; i < a.length; i++) {
            if (j == a[i]) {
                count++;
            }
            j = a[i];

//            if ((count % 2 != 0)) {
//                result = a[i-1];
//                break;
//            }

        }
        System.out.println(result);
        return result;
    }

    public int oddOccurencesInArrayFromInet(int[] a) {
        Arrays.sort(a);
        int i, j, count = 0;
        for (i = 0; i < a.length; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] == a[j])
                    count++;
                else
                    break;
            }
            if (count % 2 == 0) {
                System.out.println(a[i]);
                return a[i];
            } else {
                count = 0;
                i = j - 1;
            }
        }
        return 0;
    }

    public int trianglePerimeter(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        Arrays.sort(a);

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            if (i + 2 < a.length) {
                long ap = a[i];
                long aq = a[i + 1];
                long ar = a[i + 2];
                result = ((ap + aq > ar)) ? 1 : 0;
                if (result == 1) {
                    System.out.println(result + " " + ap + " " + aq + " " + ar);
                    break;
                }
            }

        }
        return result;
    }


    /**
     * Task 1
     * @param  A
     * @return int max Perimeter
     */
    private  static int solutionTask(int[] A) {
        ArrayList<Integer> test= new ArrayList<>();
        int B[]= sort(A);
        for (int i = 0; i < B.length - 2; i++) {
            if (
                    (B[i] +  B[i + 1] > B[i + 2]) &&
                            ( B[i + 1] + B[i + 2] > B[i])&&
                            ( B[i] +  B[i + 2] > B[i + 1]))
            {
                test.add(B[i]+B[i+1]+B[i+2]);
            }
        }

        if(test.size()==0)
            return -1;
        else
        {
            return Collections.max(test);
        }
    }

    private static   int[] sort(int[] A)
    {
        for(int i = 1 ; i < A.length ;){
            if(A[1] < A[0]) {
                int temp = A[i];
                A[i] = A[i -1];
                A[i -1] = temp;
            }
            if(A[i] < A[i-1]){
                int  temp = A[i];
                A[i] = A[i -1];
                A[i -1] = temp;
                i--;
            }
            else{i++;}
        }
        return A;

    }

    /**
     * Task 2
     * @param N
     * @param K
     * @return int min value of retries
     */
    private static int   solutionTask2 (int N,int K)
    {

        HashMap<String,Integer> resultAllIn= new HashMap();
        resultAllIn.put("iteration",N);
        resultAllIn.put("AllIn",K);
        int j=-1;
        do {
            resultAllIn=divMinusOdd(resultAllIn);
            j++;
        }
        while (resultAllIn.get("iteration")!=0);
        return j;

    }

    private  static HashMap<String,Integer> divMinusOdd(HashMap<String,Integer> resultInn)
    {
        int N= resultInn.get("iteration");
        int K= resultInn.get("AllIn");
        if(N%2==0&&K!=0)
        {
            resultInn.put("iteration",N/2);
            resultInn.put("AllIn",K-1);
        }
        else
        {
            resultInn.put("iteration",N-1);
        }
        return resultInn;
    }
}


