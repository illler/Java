package Exc;


import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
        String ans = sc.next();

        while (!ans.equals("8")){
            try {
                Integer.parseInt(ans);
            }
            catch (Exception e){
                System.out.println("������� �����.");
            }

            switch (Integer.parseInt(ans)){
                case 1 -> {
                    Exc_1 e1 = new Exc_1();
                    int x = 0;
                    String check = "";
                    System.out.println("������� �������� �������");
                    e1.setName_table(sc.next());

                    while (!check.equals("12")){
                        System.out.println("""
                    1. ������� ��� ������� �� MySQL.
                    2. ������� ������� � MySQL.
                    3. �������� �����, ��������� ��������� � MySQL � ����������� ������� � �������.
                    4. ��������� �����, ��������� ��������� � MySQL � ����������� ������� � �������.
                    5. ��������� �����, ��������� ��������� � MySQL � ����������� ������� � �������.
                    6. ������� �����, ��������� ��������� � MySQL � ����������� ������� � �������.
                    7. ������� ����� �� ������ (�������), ��������� ��������� � MySQL � ����������� ������� � �������.
                    8. ���������� ����� � ������, ��������� ��������� � MySQL � ����������� ������� � �������.
                    9. ���������� ����� � �������, ��������� ��������� � MySQL � ����������� ������� � �������.
                    10. �������� ������� �� �����.
                    11. ���������� ������ � Excel.
                    12. ����� �� ����������""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e){
                            System.out.println("�������� ������ �����");
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
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
                case 2 -> {
                    Exc_2 e2 = new Exc_2();
                    int x = 0;
                    String check = "";
                    System.out.println("������� �������� �������");
                    e2.setName_table(sc.next());
                    while (!check.equals("9")){
                        System.out.println("""
                    1. ������� ��� ������� �� MySQL.
                    2. ������� ������� � MySQL.
                    3. ������ ��� ������ � ����������, ��������� ��������� � MySQL � ����������� ������� � �������.
                    4. ���������� ������ ����� ��������� �����, ��������� ��������� � MySQL � ����������� ������� �
                    �������.
                    5. ���������� ��� ������ � ������ �����, ��������� ��������� � MySQL � ����������� ������� �
                    �������.
                    6. �������� ��� ����� ��������� ������, ��������� ��������� � MySQL � ����������� ������� �
                    �������.
                    7. ������� �������.
                    8. ��������� ������ � Excel.
                    9. ����� �� ���������
                    """);
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("�������� ������ �����");
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
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
                case 3 -> {
                    Exc_3 e3 = new Exc_3();
                    String chek = "";
                    int x = 0;
                    System.out.println("������� �������� �������");
                    e3.setName_table(sc.next());
                    while (!chek.equals("6")){
                        System.out.println("""
                                1. ������� ��� ������� �� MySQL.
                                2. ������� ������� � MySQL.
                                3. ����������� ���������, ����������� ������ ����� �� ����������� (�.�. ����� ����� ��� ���) � ��������.
                                ��� ���� ���������� ����������� ������� �� �������� ����������� �����\040
                                (�.�. ���� ������������ ������ �� ����� ����� ��� ������ �� �����, �� �������� ��� �� ������).
                                4. �������� �������.
                                5. ��������� ������ � Excel.
                                6. ����� �� ���������.""");
                        chek = sc.next();
                        try {
                            x = Integer.parseInt(chek);
                        }catch (NumberFormatException e) {
                            System.out.println("�������� ������ �����");
                        }
                        switch (x){
                            case 1 -> e3.sql_show("jdbc:mysql://localhost/Exc3");
                            case 2 -> e3.sql_create();
                            case 3 -> e3.case_3();
                            case 4 -> e3.drop("jdbc:mysql://localhost/Exc3");
                            case 5 -> e3.excel("jdbc:mysql://localhost/Exc3");
                        }
                    }
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
                case 4 ->{
                    Exc_4 e4 = new Exc_4();
                    int x = 0;
                    String check = "";
                    System.out.println("������� �������� �������");
                    e4.setName_table(sc.next());
                    while (!check.equals("9")){
                        System.out.println("""
                                1. ������� ��� ������� �� MySQL.
                                2. ������� ������� � MySQL.
                                3. ����������� ��������� �� ��������, ��������� ��������� � MySQL � ����������� ������� �
                                �������.
                                4. ������� ����� � ������ �������, ��������� ��������� � MySQL � ����������� �������
                                � �������.
                                5. ������� ����� � ������� �������, ��������� ��������� � MySQL � ����������� �������
                                � �������.
                                6. ����� ��������� � ����������� ��������� ���������, ��������� ��������� � MySQL � �����������
                                ������� � �������.
                                7. ��������� ��� ������ (�������������� ����������) �� MySQL � Excel � ������� �� �����.
                                8. �������� ������ �� �����""");
                        check = sc.nextLine();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("�������� ������ �����");
                        }
                        switch (x){
                            case 1 -> e4.sql_show("jdbc:mysql://localhost/Exc4");
                            case 2 -> e4.sql_create();
                            case 3, 4, 5, 6 -> e4.all_section(x);
                            case 7 -> e4.excel("jdbc:mysql://localhost/Exc4");
                            case 8 -> e4.drop("jdbc:mysql://localhost/Exc4");
                        }
                    }
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
                case 5 -> {
                    Exc_5 exc_5 = new Exc_5();
                    int x = 0;
                    String check = "";
                    System.out.println("������� �������� �������");
                    exc_5.setName_table(sc.next());
                    while (!check.equals("7")){
                        System.out.println("""
                                1. ������� ��� ������� �� MySQL.
                                2. ������� ������� � MySQL.
                                3. �������� ������� �������� ������ �� ��������, ��������� ��������� � MySQL � ����������� ������� �
                                �������.
                                4. �������� ���� ������ � ������, ��������� ��������� � MySQL � ����������� ������� � �������.
                                5. ��������� ��� ������ (�������������� ����������) �� MySQL � Excel � ������� �� �����.
                                6. ������� ������� �� �����.
                                7. �����.""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("�������� ������ �����");
                        }
                        switch (x){
                            case 1 -> exc_5.sql_show("jdbc:mysql://localhost/Exc5");
                            case 2 -> exc_5.sql_create();
                            case 3, 4 -> exc_5.section(x);
                            case 5 -> exc_5.excel("jdbc:mysql://localhost/Exc5");
                            case 6 -> exc_5.drop("jdbc:mysql://localhost/Exc5");
                        }
                    }
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
                case 6 ->{
                    Exc_6 exc_6 = new Exc_6();
                    int x = 0;
                    String check = "";
                    System.out.println("������� �������� �������");
                    exc_6.setName_table(sc.next());
                    while (!check.equals("7")){
                        System.out.println("""
                                1. ������� ��� ������� �� ���� ������ MySQL.
                                2. ������� ������� � ���� ������ MySQL.
                                3. ������ ��� ������� � ���������� � ������ �� ��� ��������� � MySQL � ����������� ������� � �������.
                                4. ����������� �������, ��������� ������������� ������� � MySQL � ������� � �������.
                                5. ��������� ���������� �� MySQL � Excel � ������� �� � �������.
                                6. ������� ������� �� �����
                                7. ����� �� ���������.""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        }catch (NumberFormatException e) {
                            System.out.println("�������� ������ �����");
                        }
                        switch (x){
                            case 1 -> exc_6.sql_show("jdbc:mysql://localhost/Exc6");
                            case 2 -> exc_6.sql_create();
                            case 3, 4 -> exc_6.section(x);
                            case 5 -> exc_6.excel("jdbc:mysql://localhost/Exc6");
                            case 6 -> exc_6.drop("jdbc:mysql://localhost/Exc6");
                        }
                    }
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
                case 7 -> {
                    Exc_7 exc_7 = new Exc_7();
                    int x = 0;
                    String check = "";
                    System.out.println("������� �������� �������");
                    exc_7.setName_table(sc.next());
                    while (!check.equals("6")) {
                        System.out.println("""
                                1. ������� ��� ������� �� ���� ������ MySQL.
                                2. ������� ������� � ���� ������ MySQL.
                                3. ������ ���������� ������ ������������� ������ � ��������� � MySQL � ����������� ������� � �������.
                                4. ������� ������.
                                5. ��������� ���������� �� MySQL � Excel � ������� �� � �������.
                                6. ����� �� ���������.""");
                        check = sc.next();
                        try {
                            x = Integer.parseInt(check);
                        } catch (NumberFormatException e) {
                            System.out.println("�������� ������ �����");
                        }
                        switch (x) {
                            case 1 -> exc_7.sql_show("jdbc:mysql://localhost/Exc7");
                            case 2 -> exc_7.sql_create();
                            case 3 -> exc_7.section();
                            case 4 -> exc_7.drop("jdbc:mysql://localhost/Exc7");
                            case 5 -> exc_7.excel("jdbc:mysql://localhost/Exc7");
                        }
                    }
                    System.out.println("�������� ������ �� 1 �� 7. ��� 8, ��� �� ��������� ���������� ���������.");
                    ans = sc.next();
                }
            }
        }
    }
}
