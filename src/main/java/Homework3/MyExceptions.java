package Homework3;

public class MyExceptions extends Exception{
    /**
     * Пример собственного исключения наследуется от Exception
     * @param message
     */
    public MyExceptions(String message) {
        super(message);
    }
}
