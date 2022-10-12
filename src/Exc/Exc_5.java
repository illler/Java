

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

public class Exc_5 extends Exc_all{


    private final Connection con;

    Exc_5() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc5";
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
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (first_str varchar(255), second_str varchar(255)," +
                "reverse_1 varchar(255), reverse_2 varchar(255), concatenation varchar(255))";
        statement1.executeUpdate(query);
        ResultSet rs1 = statement1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей бд");
        while (rs1.next()) {
            System.out.print(rs1.getString(1));
            System.out.println();
        }
        System.out.println();
    }

    private void print_sql(ResultSet rs2) throws SQLException {
        while (rs2.next()) {
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(3).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(4).split(" ")));
            System.out.println();
        }
    }
    private void print_sql_2(ResultSet rs2) throws SQLException {
        while (rs2.next()) {
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(3).split(" ")));
            System.out.println();
        }
    }

    public void section(int x) throws SQLException{
        System.out.print("Введите первую строку: ");
        setStr(sc.nextLine());
        StringBuilder stringBuffer = new StringBuilder(getStr());
        System.out.print("Введите вторую строку: ");
        setStr1(sc.nextLine());
        StringBuilder stringBuffer1 = new StringBuilder(getStr1());
        String query = "insert into " + getName_table() + " (first_str , second_str , reverse_1 , reverse_2," +
                " concatenation) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, stringBuffer.toString());
        statement.setString(2, stringBuffer1.toString());
        statement.setString(3, stringBuffer.reverse().toString());
        statement.setString(4, stringBuffer1.reverse().toString());
        statement.setString(5, stringBuffer.append(stringBuffer1).toString());
        statement.executeUpdate();
        if (x==3){
            ResultSet rs2 = statement.executeQuery("SELECT first_str , second_str , reverse_1 , reverse_2 FROM " + getName_table() + "");
            print_sql(rs2);
        }
        else if (x==4){
            ResultSet rs2 = statement.executeQuery("SELECT first_str , second_str , concatenation FROM " + getName_table() + "");
            print_sql_2(rs2);
        }


    }

    @Override
    public void drop(String a) throws SQLException {
        super.drop(a);
    }

    @Override
    public void excel(String url) throws ClassNotFoundException, SQLException, IOException {
        super.excel(url);
    }
}
