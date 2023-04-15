package Homework3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorker {
    /**
     * Метод для запипси валидных данных в файл.
     * @param user строковый массив данных
     */
    public void writeToFile(String[] user) {
        if (user != null) {
            try (FileWriter writer = new FileWriter(String.format("src/main/java/Homework3/Users/%s.txt", user[0]), true)) {
                // запись всей строки
                for (String data : user) {
                    writer.write(String.format("<%s>", data));
                }
                writer.write("\n");
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Метод для чтения информации из файла.
     * @param secondName фамилия пользователя для поиска пользователей по ней.
     * @throws IOException при отстуствии файла по введеной фамилии.
     */
    public void readToFile(String secondName){
        try(FileReader reader = new FileReader(String.format("src/main/java/Homework3/Users/%s.txt", secondName)))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.printf("Пользователя с фамилей \"%s\" не найдено.", secondName);
        }
    }
}
