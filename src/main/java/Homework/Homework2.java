package Homework;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Homework2 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        task4();
    }

    /*
     * 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
     * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */

    /**
     * Метод запуска программы.
     */
    public static void task1() {
        System.out.print("Введите число: ");
        while (true) {
            try {

                float number = floatNumberInput();
                System.out.println(number);
                return;
            } catch (MyFloatException e) {
                System.out.printf("%s\nПовтирите попытку ввода: ", e.getMessage());
                sc.nextLine();
            }
        }

    }

    /**
     * Метод для ввода и проверки числа.
     *
     * @return Введеное число, если оно не является буквой или символом.
     * @throws MyFloatException
     */
    public static float floatNumberInput() throws MyFloatException {
        try {
            return sc.nextFloat();
        } catch (InputMismatchException e) {
            throw new MyFloatException("Вы ввели НЕ дробное число!");
        }
    }

    /*
     * 2-3. Если необходимо, исправьте данный код (https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
     */

    /**
     * Метод обрабатывающий ошибку при делении на 0 и неверно введеные данные (буква или символ вместо числа)
     */
    public static void task2() {
        int[] intArray = new int[10];
        try {
            double d = sc.nextDouble();
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("Вы ввели не число!");
        }
    }

    /**
     * Метод для обработки следующих исключений: выход за границу массива,
     * проверка на null, проверка на остальные исключения группы Throwable
     */
    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    /**
     * Метод печати суммы двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @throws FileNotFoundException
     */
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }


    /*
     * 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
     * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
     */

    /**
     * Метод обработки исключения при вводе пустой строки.
     */
    public static void task4() {
        System.out.print("Введите строку: ");
        while (true) {
            try {
                NotNullStringInput();
                return;
            } catch (MyNullException e) {
                System.out.printf("%s\nПовторите ввод: ", e.getMessage());
                sc.nextLine();
            }
        }
    }

    /**
     * Метод выбрасывания исключения при вводе пустой строки.
     *
     * @throws MyNullException
     */
    public static void NotNullStringInput() throws MyNullException {
        String text = sc.nextLine();
        if (text == null) {
            throw new MyNullException("Ввод пустой строки не допускается!");
        } else {
            System.out.println("Вы ввели: " + text);
        }
    }
}

/**
 * Абстрактный класс для обработки собственных исключений, наследуется от Exception
 */
abstract class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

/**
 * Класс наследуемый от MyException, для обработки исключения при введении дробного числа.
 */
class MyFloatException extends MyException {
    MyFloatException(String message) {
        super(message);
    }
}

class MyNullException extends MyException {
    MyNullException(String message) {
        super(message);
    }
}