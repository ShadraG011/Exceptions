package Homework3;

import java.util.Scanner;

class Controller {
    private FileWorker fw = new FileWorker();
    ;
    private DataChecked dc = new DataChecked();
    ;
    private Scanner sc = new Scanner(System.in);

    /**
     * Метод для запуска программы
     */
    public void run() {
        System.out.println("Это программы для работы с исключениями.\n");
        System.out.println("Пожалуйста введите пользовтеля в следующем формате:\n\n" +
                "Фамилия Имя Отчество | дата рождения (в формате dd.mm.yyyy) | номер телефона (в формате 89000000000) | гендер (f или m)\n\n" +
                "примечание: вводите данный в соответствии с представленным форматом разделяя пробелом!\n");
        write();
        read();
        sc.close();
    }

    /**
     * Метод объединяющий работу с файлом, проверку введеных данных, введение данных пользователем.
     */
    private void write() {
        do {
            System.out.print("Поле ввода: ");
            fw.writeToFile(dc.dataChecked(sc.nextLine().split(" ")));
            System.out.println("Повторить ввод данных? (д/н)");
        } while (!sc.nextLine().equalsIgnoreCase("н"));
    }

    /**
     * Метод работающий с прочтением файла.
     */
    private void read() {
        do {
            System.out.print("Введите фамилию, чтобы найти пользователей: ");
            fw.readToFile(sc.nextLine());
            System.out.println("Повторить ввод данных? (д/н)");
        } while (!sc.nextLine().equalsIgnoreCase("н"));
    }
}
