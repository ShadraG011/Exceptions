package Homework.Homework3;

public class DataChecked {
    /**
     * Метод для проверки количесва введеных данных
     *
     * @param userData строковый массив данных
     * @return код ошибки или код её отсутствия
     */
    private int checkInputData(String[] userData) {
        if (userData.length > 6) return -1;
        if (userData.length < 6) return -2;
        return 0;
    }

    /**
     * Метод для проверки валидности ФИО.
     *
     * @param fio - фамилия, имя, отчество - в виде трех строк.
     * @throws MyExceptions при ошибке ввода ФИО.
     */
    private void checkFIO(String... fio) throws MyExceptions {
        for (int i = 0; i < fio.length; i++) {
            for (char letter : fio[i].toCharArray()) {
                if (Character.isDigit(letter)) {
                    throw new MyExceptions("Ошибка ввода ФИО!\nФИО не может содержать цифры, повторите попытку ввода.");
                }
            }
        }
    }

    /**
     * Метод для проверки валидности даты рожлдения.
     *
     * @param dataBirth строка нужного формата.
     * @throws MyExceptions при ошибке ввода даты рождения.
     */
    private void checkDataBirth(String dataBirth) throws MyExceptions {
        if (dataBirth.length() != 10)
            throw new MyExceptions("Ошибка ввода Даты рождения!\nПовторите попытку ввода (по шаблону dd.mm.yyyy).");
        char[] arr = dataBirth.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i]) && arr[i] != '.') {
                throw new MyExceptions("Ошибка ввода Даты рождения!\nДата рождения не может содержать буквы или символы, кроме \".\", повторите попытку ввода (по шаблону dd.mm.yyyy).");
            }
        }
    }

    /**
     * Метод для проверки валидности номера телефона.
     *
     * @param phoneNumber номер телефона в формате long.
     * @throws MyExceptions при недостаточной или избыточной длине номера
     */
    private void checkPhone(long phoneNumber) throws MyExceptions {
        if (Long.toString(phoneNumber).length() != 11)
            throw new MyExceptions("Ошибка ввода Номера телефона!\nНомер должен состоять из 11 цифр, повторите попытку ввода (по шаблону 89000000000).");
    }

    /**
     * Метод для проверки валидности введеного гендера.
     *
     * @param gender строка одним симовлом.
     * @throws MyExceptions при введении больше символов чем 1 и других сиволов не обозначающих гендер.
     */
    private void checkGender(String gender) throws MyExceptions {
        if (gender.length() != 1 || (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")))
            throw new MyExceptions("Ошибка ввода Гендера!\nГендер обозначается буквами f или m, повторите попытку ввода.");
    }

    /**
     * Метод проверки введеных всех введных данных.
     *
     * @param user массив строк с данными
     * @return проверенный массив с данными пользователя, либо null при ошибке проверки.
     */
    public String[] dataChecked(String[] user) {
        if (checkInputData(user) == 0) {
            try {
                checkFIO(user[0], user[1], user[2]);
                checkDataBirth(user[3]);
                checkPhone(Long.parseLong(user[4]));
                checkGender(user[5]);
                return user;
            } catch (MyExceptions e) {
                System.out.println(e.getMessage());
                return null;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода Номера телефона!\nНомер не может содержать буквы или символы, повторите попытку ввода (по шаблону 89000000000).");
                return null;
            }
        } else if (checkInputData(user) == -1) {
            System.out.println("Ошибка ввода данных (код ошибки \"-1\")!\nВы ввели больше данных, чем нужно, повторите попытку ввода.");
        } else if (checkInputData(user) == -2) {
            System.out.println("Ошибка ввода данных (код ошибки \"-2\")!\nВы ввели меньше данных, чем нужно, повторите попытку ввода.");
        }
        return null;
    }
}
