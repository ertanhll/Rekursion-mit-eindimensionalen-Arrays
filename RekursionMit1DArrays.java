/*
    Aufgabe 3) Rekursion mit eindimensionalen Arrays
*/

import java.util.Arrays;

public class Aufgabe3 {

    private static int getMaxPairSum(int[] workArray, int start, int end) {

//        System.out.println(Arrays.toString(workArray));
//        System.out.println("" + start + " " + end);

        int totalAmount = 0;
        if (start >= end)
            return 0;
        else {
            totalAmount = workArray[start] + workArray[start + 1];
            int nextAmount = getMaxPairSum(workArray, (start + 1), end);
            if (nextAmount > totalAmount)
                totalAmount = nextAmount;
        }
        return totalAmount;
    }

    private static int countValuesWithSmallerNeighbors(int[] workArray, int index) {

        int count = 0;
        if (index > workArray.length - 2 || index <= 0)
            return 0;
        else {
            if (workArray[index - 1] < workArray[index] && workArray[index] > workArray[index + 1])
                count++;
            count += countValuesWithSmallerNeighbors(workArray, index + 1);
        }
        return count;
    }


    private static int[] getArrayWithNegativeValues(int[] workArray, int index) {
        int[] clonedArr = workArray.clone();
        if (workArray.length > 0 && index < workArray.length) {
            if (clonedArr[index] > 0)
                clonedArr[index] = 0;
            return getArrayWithNegativeValues(clonedArr, index + 1);
        }
        return clonedArr;
    }

    private static boolean containsValue(int[] workArray, int value) {
        boolean isInArray = false;
        if (workArray.length > 0) {
            if (value == workArray[workArray.length / 2])
                isInArray = true;
            else if (workArray.length > 2)
                isInArray = containsValue(Arrays.copyOfRange(workArray, 0, workArray.length / 2), value - 1);
            if (isInArray == false)
                isInArray = containsValue(Arrays.copyOfRange(workArray, workArray.length / 2, workArray.length - 1), value - 1);
        }
        return isInArray;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 1, 7, 9, 4, 10, 5, 3};
        System.out.println(getMaxPairSum(array1, 0, array1.length - 1));
        System.out.println("##");
        System.out.println(getMaxPairSum(array1, 4, array1.length - 1));
        System.out.println("##");
        System.out.println(getMaxPairSum(array1, 1, 3));
        System.out.println("##");
        System.out.println(getMaxPairSum(array1, 0, 2));
        System.out.println("##");
        System.out.println(getMaxPairSum(array1, 0, 1));
        System.out.println();

        int[] array2 = {3, 9, 7, 19, 8, 10, 6, 3, 11, 5};
        System.out.println(countValuesWithSmallerNeighbors(array2, 1));
        System.out.println(countValuesWithSmallerNeighbors(array2, 4));
        System.out.println(countValuesWithSmallerNeighbors(array2, 6));
        System.out.println(countValuesWithSmallerNeighbors(array2, 8));
        System.out.println();

        int[] array3 = {5, -3, 7, -15, 20, -5, 0, 14, 3, -2, -8};
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 0)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 10)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 8)));
        System.out.println(Arrays.toString(getArrayWithNegativeValues(array3, 4)));
        System.out.println();

        int[] array4 = {2, 4, 7, 10, -10, 4, 0, 0, 27, 11, 4, 6};
        System.out.println(containsValue(array4, 11));
        System.out.println(containsValue(array4, 2));
        System.out.println(containsValue(array4, 25));
        System.out.println(containsValue(array4, 0));
        System.out.println(containsValue(array4, 14));
        System.out.println(containsValue(array4, 6));


        assert (getMaxPairSum(array1, 0, array1.length - 1) == 16);
        assert (getMaxPairSum(array1, 4, array1.length - 1) == 15);
        assert (getMaxPairSum(array1, 1, 3) == 16);
        assert (getMaxPairSum(array1, 0, 2) == 8);
        assert (getMaxPairSum(array1, 0, 1) == 4);

        assert (countValuesWithSmallerNeighbors(array2, 1) == 4);
        assert (countValuesWithSmallerNeighbors(array2, 4) == 2);
        assert (countValuesWithSmallerNeighbors(array2, 6) == 1);
        assert (countValuesWithSmallerNeighbors(array2, 8) == 1);

        assert (Arrays.equals(getArrayWithNegativeValues(array3, 0), new int[]{0, -3, 0, -15, 0, -5, 0, 0, 0, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 10), new int[]{5, -3, 7, -15, 20, -5, 0, 14, 3, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 8), new int[]{5, -3, 7, -15, 20, -5, 0, 14, 0, -2, -8}) == true);
        assert (Arrays.equals(getArrayWithNegativeValues(array3, 4), new int[]{5, -3, 7, -15, 0, -5, 0, 0, 0, -2, -8}) == true);

        assert (containsValue(array4, 11) == true);
        assert (containsValue(array4, 2) == true);
        assert (containsValue(array4, 25) == false);
        assert (containsValue(array4, 0) == true);
        assert (containsValue(array4, 14) == false);
        assert (containsValue(array4, 6) == true);
    }
}


