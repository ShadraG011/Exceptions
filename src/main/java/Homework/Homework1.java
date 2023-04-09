package Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Homework1 {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public static void main(String[] args) {
        Homework1 homework1 = new Homework1();
        int[] arr1 = homework1.fillArray();
        int[] arr2 = homework1.fillArray();
        homework1.task1(arr1, arr2);
        System.out.println();
        homework1.task2(arr1, arr2);
    }


    /**
     * 1. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
     * каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */

    /**
     * Метод возвращающий новый массив с разностью элементов 2-х входящих массивов
     * и уведомляющий об ошибке при разной длине исходных массивов.
     * @param arr1
     * @param arr2
     * @return resultArray
     */
    public int[] task1(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) { // проверка длинн массивов
            System.out.println("Размеры массива должны быть одинаковыми! (оповещение пользователя из первого метода)"); //оповещение пользователя об ошибке размера массивов
            return null;
        }
        int[] resultArray = new int[arr1.length];
        for (int i = 0; i < resultArray.length; i++) { // цикл вычисления разности элементов
            resultArray[i] = arr1[i] - arr2[i];
        }
        System.out.println("\nРезультат работы первого метода:");
        System.out.print("Первый массив: ");
        for (int c : arr1) { // вывод на печать 1-го массива
            System.out.printf("%d ", c);
        }
        System.out.println();
        System.out.print("Второй массив: ");
        for (int c : arr2) { // вывод на печать 2-го массива
            System.out.printf("%d ", c);
        }
        System.out.println();
        System.out.print("Результирующий массив: ");
        for (int c : resultArray) { // вывод на печать результирующего массива
            System.out.printf("%d ", c);
        }
        return resultArray;
    }


    /**
     * 2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
     * каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно:
     * При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
     */
    /**
     * Метод возвращающий массив с частным элементов из двух исходных массивов
     * и уведомляющий об ошибке при разной длине исходных массивов.
     * @param arr1
     * @param arr2
     * @return
     */
    public double[] task2(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) { // проверка длинн массивов
            throw new RuntimeException("Размеры массива должны быть одинаковыми! (выбрасывание исключения из второго метода)" ); // выбрасывание исключения при ошибке размера массивов
        }
        double[] resultArray = new double[arr1.length];
        for (int i = 0; i < resultArray.length; i++) { // цикл вычисления разности элементов
            resultArray[i] = ((double)arr1[i] / (double)arr2[i]);
        }
        System.out.println("\nРезультат работы второго метода:");
        System.out.print("Первый массив: ");
        for (int c : arr1) { // вывод на печать 1-го массива
            System.out.printf("%d ", c);
        }
        System.out.println();
        System.out.print("Второй массив: ");
        for (int c : arr2) { // вывод на печать 2-го массива
            System.out.printf("%d ", c);
        }
        System.out.println();
        System.out.print("Результирующий массив: ");
        for (double c : resultArray) { // вывод на печать результирующего массива
            if(c % 1 == 0)
                System.out.printf("%.0f ", c);
            else
                System.out.printf("%.2f ", c);
        }

        return resultArray;
    }

    /**
     * Метод заполнения массива в диапозоне от 1 до 10
     * @return array
     */
    public int[] fillArray() {
        int[] array;
        System.out.print("Введите длину массива: ");
        while (true) { // цикл для защиты от неверного ввода
            if (sc.hasNextInt()) { // проверка на ввод числа
                array = new int[sc.nextInt()];
                for (int i = 0; i < array.length; i++) {
                    array[i] = rd.nextInt(1, 11);
                }
                return array;
            } else{
                System.out.print("Введите длину массива цифрой: ");
                sc.nextLine();
            }
        }
    }
}
