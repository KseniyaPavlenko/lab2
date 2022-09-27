import java.util.Arrays;
import java.util.Random;

public class main {

    /**
     * task1
     * #31
     * Дана последовательность чисел а1, а2, ..., an. Указать наименьшую длину числовой оси, содержащую все эти числа.
     */

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    private static void task1() {
        int[] array = {5, 6, 3, 3, -1, 4};
        System.out.println(minAxisLength(array));
    }

    public static int minAxisLength(int[] array) {
        Arrays.sort(array);
        return Math.abs(array[0]) + array[array.length - 1];
    }

    /**
     * task2
     * #56
     * Дан вектор {zi}, i = 1, ..., 50. Вычислить длину этого вектора: L = √z1^2 + z2^2 + .... + z50^2
     */
    private static void task2() {

        int n = 50;
        double l = 0;
        for (int i = 0; i < n; i++) l += i * i;
        System.out.printf(String.valueOf(Math.sqrt(l)));
    }

    /**
     * task3
     * #81
     * Дана последовательность натуральных чисел а1, a2, ..., а15. Определить, есть ли в последовательности хотя бы одна пара соседних нечетных чисел.
     * В случае положительного ответа определить порядковые номера чисел первой из таких пар.
     */
    private static void task3() {
        int[] arr = {1, 2, 5, 8, 9, 2, 4, 5, 3, 1, 2, 8};
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 != 0) {
                if ((arr[i] == arr[i + 1] + 2)) {
                    System.out.printf("\nДва соседних нечетных числа %d и %d в позиции %d", arr[i], arr[i + 1], i);
                    flag = false;
                    break;
                }
            }
        }
        if (flag) System.out.println("\nВ массиве нет последовательности соседних нечетных чисел.");

    }

    /**
     * task4
     * #106
     * Удалить последний элемент массива вещественных чисел.
     */


    public static void task4() {
        double[] arr1 = {5.2, 3.3, 4.1, 7.8, 6.3, 8.9};

        arr1 = removeLastElement(arr1);
        System.out.println("\n" + Arrays.toString(arr1));
    }

    public static double[] removeLastElement(double[] arr1) {
        return Arrays.copyOf(arr1, arr1.length - 1);
    }

    /**
     * task5
     * #131
     * Дана последовательность целых чисел а1, а2, ..., an. Образовать новую последовательность, выбросив из исходной те члены,
     * которые равны min (а1, а2, ..., an).
     */
    public static void task5() {
        int n = 15;
        Random rand = new Random();
        int[] ints = new int[n];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(20) - 10;
            System.out.print(ints[i] + ", ");
        }
        System.out.println();
        int minVal = Integer.MAX_VALUE;
        for (int tmpEl : ints) minVal = Math.min(minVal, tmpEl);
        int countMinElem = 0;
        for (int tmpEl : ints)
            if (tmpEl == minVal) countMinElem++;

        int[] newA = new int[n - countMinElem];
        int indexNewArray = 0;
        for (int tmpEl : ints)
            if (tmpEl != minVal) {
                newA[indexNewArray++] = tmpEl;
                System.out.print(tmpEl + ", ");
            }
    }
}