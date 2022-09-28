package Exc;


import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
        String ans = sc.next();

        while (!ans.equals("8")){
            try {
                Integer.parseInt(ans);
            }
            catch (Exception e){
                System.out.println("Введите число.");
            }

            switch (Integer.parseInt(ans)){
                case 1 -> {
                    Exc_1 e1 = new Exc_1();
                    int x = 0;
                    String check = "";
                    System.out.println("Введите название таблицы");
                    e1.setName_table(sc.next());

                    while (!check.equals("12")){
                        System.out.println("""
                    1. Вывести все таблицы из MySQL.
                    2. Создать таблицу в MySQL.
                    3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль.
                    4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль.
                    5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.
                    6. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.
                    7. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим выводом в консоль.
                    8. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом в консоль.
                    9. Возведение числа в степень, результат сохранить в MySQL с последующим выводом в консоль.
                    10. Удаление таблицы по имени.
                    11. Сохранение данных в Excel.
                    12. Выход из программыю""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e){
                            System.out.println("Неверный формат ввода");
                        }
                        switch (x){
                            case 1 -> e1.sql_show("jdbc:mysql://localhost/Exc1");
                            case 2 -> e1.sql_create();
                            case 3 -> e1.exc_1_1();
                            case 4 -> e1.exc_1_2();
                            case 5 -> e1.exc_1_3();
                            case 6 -> e1.exc_1_4();
                            case 7 -> e1.exc_1_5();
                            case 8 -> e1.exc_1_6();
                            case 9 -> e1.exc_1_7();
                            case 10 -> e1.drop("jdbc:mysql://localhost/Exc1");
                            case 11 -> e1.excel("jdbc:mysql://localhost/Exc1");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
                case 2 -> {
                    Exc_2 e2 = new Exc_2();
                    int x = 0;
                    String check = "";
                    System.out.println("Введите название таблицы");
                    e2.setName_table(sc.next());
                    while (!check.equals("9")){
                        System.out.println("""
                    1. Вывести все таблицы из MySQL.
                    2. Создать таблицу в MySQL.
                    3. Ввести две строки с клавиатуры, результат сохранить в MySQL с последующим выводом в консоль.
                    4. Подсчитать размер ранее введенных строк, результат сохранить в MySQL с последующим выводом в
                    консоль.
                    5. Объединить две строки в единое целое, результат сохранить в MySQL с последующим выводом в
                    консоль.
                    6. Сравнить две ранее введенные строки, результат сохранить в MySQL с последующим выводом в
                    консоль.
                    7. Удалить таблицу.
                    8. Сохранить данные в Excel.
                    9. Выход из программы
                    """);
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода");
                        }

                        switch (x) {
                            case 1 -> e2.sql_show("jdbc:mysql://localhost/Exc2");
                            case 2 -> e2.sql_create();
                            case 3 -> e2.exc_2_insert();
                            case 4 -> e2.exc_2_1();
                            case 5 -> e2.exc_2_2();
                            case 6 -> e2.exc_2_3();
                            case 7 -> e2.drop("jdbc:mysql://localhost/Exc2");
                            case 8 -> e2.excel("jdbc:mysql://localhost/Exc2");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
                case 3 -> {
                    Exc_3 e3 = new Exc_3();
                    String chek = "";
                    int x = 0;
                    System.out.println("Введите название таблицы");
                    e3.setName_table(sc.next());
                    while (!chek.equals("6")){
                        System.out.println("""
                                1. Вывести все таблицы из MySQL.
                                2. Создать таблицу в MySQL.
                                3. Реализовать программу, проверяющую каждое число на целостность (т.е. целое число или нет) и четность.
                                При этом необходимо реализовать условие на проверку целостности числа\040
                                (т.е. если пользователь вводит не целое число или вообще не число, то сообщать ему об ошибке).
                                4. Удаление таблицы.
                                5. Сохранить данные в Excel.
                                6. Выход из программы.""");
                        chek = sc.next();
                        try {
                            x = Integer.parseInt(chek);
                        }catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода");
                        }
                        switch (x){
                            case 1 -> e3.sql_show("jdbc:mysql://localhost/Exc3");
                            case 2 -> e3.sql_create();
                            case 3 -> e3.case_3();
                            case 4 -> e3.drop("jdbc:mysql://localhost/Exc3");
                            case 5 -> e3.excel("jdbc:mysql://localhost/Exc3");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
                case 4 ->{
                    Exc_4 e4 = new Exc_4();
                    int x = 0;
                    String check = "";
                    System.out.println("Введите название таблицы");
                    e4.setName_table(sc.next());
                    while (!check.equals("9")){
                        System.out.println("""
                                1. Вывести все таблицы из MySQL.
                                2. Создать таблицу в MySQL.
                                3. Возвращение подстроки по индексам, результат сохранить в MySQL с последующим выводом в
                                консоль.
                                4. Перевод строк в нижний регистр, результат сохранить в MySQL с последующим выводом
                                в консоль.
                                5. Перевод строк в верхний регистр, результат сохранить в MySQL с последующим выводом
                                в консоль.
                                6. Поиск подстроки и определение окончания подстроки, результат сохранить в MySQL с последующим
                                выводом в консоль.
                                7. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран.
                                8. Удаление таблиц по имени""");
                        check = sc.nextLine();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода");
                        }
                        switch (x){
                            case 1 -> e4.sql_show("jdbc:mysql://localhost/Exc4");
                            case 2 -> e4.sql_create();
                            case 3, 4, 5, 6 -> e4.all_section(x);
                            case 7 -> e4.excel("jdbc:mysql://localhost/Exc4");
                            case 8 -> e4.drop("jdbc:mysql://localhost/Exc4");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
                case 5 -> {
                    Exc_5 exc_5 = new Exc_5();
                    int x = 0;
                    String check = "";
                    System.out.println("Введите название таблицы");
                    exc_5.setName_table(sc.next());
                    while (!check.equals("7")){
                        System.out.println("""
                                1. Вывести все таблицы из MySQL.
                                2. Создать таблицу в MySQL.
                                3. Изменить порядок символов строки на обратный, результат сохранить в MySQL с последующим выводом в
                                консоль.
                                4. Добавить одну строку в другую, результат сохранить в MySQL с последующим выводом в консоль.
                                5. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран.
                                6. Удалить таблицу по имени.
                                7. Выход.""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода");
                        }
                        switch (x){
                            case 1 -> exc_5.sql_show("jdbc:mysql://localhost/Exc5");
                            case 2 -> exc_5.sql_create();
                            case 3, 4 -> exc_5.section(x);
                            case 5 -> exc_5.excel("jdbc:mysql://localhost/Exc5");
                            case 6 -> exc_5.drop("jdbc:mysql://localhost/Exc5");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
                case 6 ->{
                    Exc_6 exc_6 = new Exc_6();
                    int x = 0;
                    String check = "";
                    System.out.println("Введите название таблицы");
                    exc_6.setName_table(sc.next());
                    while (!check.equals("7")){
                        System.out.println("""
                                1. Вывести все таблицы из базы данных MySQL.
                                2. Создать таблицу в базе данных MySQL.
                                3. Ввести две матрицы с клавиатуры и каждую из них сохранить в MySQL с последующим выводом в консоль.
                                4. Перемножить матрицу, сохранить перемноженную матрицу в MySQL и вывести в консоль.
                                5. Сохранить результаты из MySQL в Excel и вывести их в консоль.
                                6. Удалить таблицу по имени
                                7. Выход из программы.""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода");
                        }
                        switch (x){
                            case 1 -> exc_6.sql_show("jdbc:mysql://localhost/Exc6");
                            case 2 -> exc_6.sql_create();
                            case 3, 4 -> exc_6.section(x);
                            case 5 -> exc_6.excel("jdbc:mysql://localhost/Exc6");
                            case 6 -> exc_6.drop("jdbc:mysql://localhost/Exc6");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
                case 7 -> {
                    Exc_7 exc_7 = new Exc_7();
                    int x = 0;
                    String check = "";
                    System.out.println("Введите название таблицы");
                    exc_7.setName_table(sc.next());
                    while (!check.equals("6")) {
                        System.out.println("""
                                1. Вывести все таблицы из базы данных MySQL.
                                2. Создать таблицу в базе данных MySQL.
                                3. Ввести одномерный массив отсортировать массив и сохранить в MySQL с последующим выводом в консоль.
                                4. Удалить талицу.
                                5. Сохранить результаты из MySQL в Excel и вывести их в консоль.
                                6. Выход из программы.""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода");
                        }
                        switch (x) {
                            case 1 -> exc_7.sql_show("jdbc:mysql://localhost/Exc7");
                            case 2 -> exc_7.sql_create();
                            case 3 -> exc_7.section();
                            case 4 -> exc_7.drop("jdbc:mysql://localhost/Exc7");
                            case 5 -> exc_7.excel("jdbc:mysql://localhost/Exc7");
                        }
                    }
                    System.out.println("Выберите задачу от 1 до 7. Или 8, что бы закончить выполнение программы.");
                    ans = sc.next();
                }
            }
        }
    }
}
