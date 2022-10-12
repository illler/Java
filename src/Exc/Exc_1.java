

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

class Exc_1 extends Exc_all{

    private final Connection con;
    Logger logger = LogManager.getRootLogger();

    Exc_1() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc1";
        con = DriverManager.getConnection(mysqlUrl1, "root", Config.getPassword());
        System.out.println("Успешно подключились к бд");
    }

    @Override
    public void sql_show(String a) throws SQLException {
        super.sql_show(a);
    }


    @Override
    public void sql_create() throws SQLException {
        try {
            Statement statement1 = con.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (description varchar(255)," +
                    " number1 varchar(255), number2 varchar(255), result varchar(255))";
            statement1.executeUpdate(query);
            ResultSet rs1 = statement1.executeQuery("Show tables");
            System.out.println("Таблицы из текущей бд");
            while (rs1.next()) {
                System.out.print(rs1.getString(1));
                System.out.println();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            logger.error(ex.toString());
        }
    }
    public void exc_1_1() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, a+b);
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setInt(8, c+d);
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12, Float.toString(e+f));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }

    public void exc_1_2() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, a-b);
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setInt(8, c-d);
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12, Float.toString(e-f));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }

    public void exc_1_3() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, a*b);
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setInt(8, c*d);
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12, Float.toString(e*f));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }

    public void exc_1_4() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, a/b);
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setInt(8, c/d);
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12, Float.toString(e/f));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }
    public void exc_1_5() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, a%b);
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setInt(8, c%d);
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12, Float.toString(e%f));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }

    public void exc_1_6() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, Math.abs(a));
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setInt(8, Math.abs(c));
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12, Float.toString(Math.abs(e)));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }

    public void exc_1_7() throws SQLException{
        System.out.println("Введите два числа типа int");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Введите два числа типа byte");
        byte c = sc.nextByte();
        byte d = sc.nextByte();
        System.out.println("Введите два числа типа float");
        float e = sc.nextFloat();
        float f = sc.nextFloat();
        String query2 = "insert into " + getName_table() + " (description, number1, number2, result) values (?, ?, ?, ?), (?, ?, ?, ?), " +
                "(?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query2);
        statement2.setString(1,"int");
        statement2.setInt(2, a);
        statement2.setInt(3, b);
        statement2.setInt(4, (int) Math.pow(a, b));
        statement2.setString(5,"byte");
        statement2.setByte(6, c);
        statement2.setByte(7, d);
        statement2.setString(8,  Byte.toString((byte) Math.pow(c, d)));
        statement2.setString(9,"float");
        statement2.setFloat(10, e);
        statement2.setFloat(11, f);
        statement2.setString(12,  Float.toString((float) Math.pow(e, f)));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
        System.out.println("Структура таблицы");
        System.out.println("Тип данных | первое число | второе число | Финал операции");
        show_result(rs2);
        sc.nextLine();
    }

    @Override
    public void excel(String mysqlUrl1) throws ClassNotFoundException, SQLException, IOException {
        super.excel(mysqlUrl1);
    }

    @Override
    public void drop(String a) throws SQLException {
        super.drop(a);
    }

    private void show_result(ResultSet rs2) throws SQLException{
        while (rs2.next()){
            if (Arrays.toString(rs2.getString(1).split(" ")).contains("int")) {
                System.out.print(Arrays.toString(rs2.getString(1).split(" ")) + "           ");
                System.out.print(Arrays.toString(rs2.getString(2).split(" ")) + "            ");
                System.out.print(Arrays.toString(rs2.getString(3).split(" ")) + "            ");
                System.out.print(Arrays.toString(rs2.getString(4).split(" ")) + "         ");
                System.out.println();
            }else if (Arrays.toString(rs2.getString(1).split(" ")).contains("byte")){
                System.out.print(Arrays.toString(rs2.getString(1).split(" ")) + "          ");
                System.out.print(Arrays.toString(rs2.getString(2).split(" ")) + "            ");
                System.out.print(Arrays.toString(rs2.getString(3).split(" ")) + "            ");
                System.out.print(Arrays.toString(rs2.getString(4).split(" ")) + "      ");
                System.out.println();
            }else if (Arrays.toString(rs2.getString(1).split(" ")).contains("float")){
                System.out.print(Arrays.toString(rs2.getString(1).split(" ")) + "         ");
                System.out.print(Arrays.toString(rs2.getString(2).split(" ")) + "          ");
                System.out.print(Arrays.toString(rs2.getString(3).split(" ")) + "          ");
                System.out.print(Arrays.toString(rs2.getString(4).split(" ")) + "      ");
                System.out.println();
            }
        }
    }
}
