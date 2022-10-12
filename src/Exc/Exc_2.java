


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

class Exc_2 extends Exc_all{

    private final Connection con;
    Logger logger = LogManager.getRootLogger();

    Exc_2() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc2";
        con = DriverManager.getConnection(mysqlUrl1, "root", Config.getPassword());
        System.out.println("Успешно подключились к бд");
    }
    @Override
    public void sql_show(String a) throws SQLException {
        super.sql_show(a);
    }

    @Override
    public void sql_create() throws SQLException{
        Statement statement1 = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (first_string varchar(255), " +
                "second_string varchar(255), length1 varchar(255), length2 varchar(255)," +
                " connection varchar(255), equals varchar(255))";
        statement1.executeUpdate(query);
        ResultSet rs1 = statement1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей бд");
        while (rs1.next()){
            System.out.print(rs1.getString(1));
            System.out.println();
        }
        System.out.println();
    }

    public void exc_2_insert() throws SQLException{
        try {
        System.out.println("Введите 2 строки");
        setStr(sc.nextLine());
        setStr1(sc.nextLine());
        String query = "insert into " + getName_table() + " (first_string, second_string," +
                " length1, length2, connection, equals) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement2 = con.prepareStatement(query);
        statement2.setString(1, getStr());
        statement2.setString(2, getStr1());
        statement2.setInt(3, getStr().length());
        statement2.setInt(4, getStr1().length());
        statement2.setString(5, getStr() + getStr());
        statement2.setString(6, ((getStr().equals(getStr1())) ? "Строки равны":
                "Строки не равны"));
        statement2.executeUpdate();
        System.out.println("Данные успешно внесены");
        ResultSet rs2 = statement2.executeQuery("SELECT first_string, second_string FROM " + getName_table() + "");
        while (rs2.next()){
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.println();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            logger.error(ex.toString());
        }
    }

    public void exc_2_1() throws SQLException{
        Statement state4 = con.createStatement();
        ResultSet rs2 = state4.executeQuery("SELECT first_string, second_string," +
                " length1, length2 FROM " + getName_table() + "");
        while (rs2.next()){
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.print(Arrays.toString(new int[]{rs2.getInt(3)}));
            System.out.print(Arrays.toString(new int[]{rs2.getInt(4)}));
            System.out.println();
        }
    }

    public void exc_2_2() throws SQLException{
        Statement statement1 = con.createStatement();
        ResultSet rs2 = statement1.executeQuery("SELECT first_string, second_string, connection" +
                " FROM " + getName_table() + "");
        while (rs2.next()){
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(3).split(" ")));
            System.out.println();
        }
    }

    public void exc_2_3() throws SQLException{
        Statement statement1 = con.createStatement();
        ResultSet rs2 = statement1.executeQuery("SELECT first_string, second_string, equals FROM" +
                " " + getName_table() + "");
        while (rs2.next()){
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(3).split(" ")));
            System.out.println();
        }
    }

    @Override
    public void excel(String mysqlUrl1) throws ClassNotFoundException, SQLException, IOException {
        super.excel(mysqlUrl1);
    }

    @Override
    public void drop(String a) throws SQLException {
        super.drop(a);
    }

}