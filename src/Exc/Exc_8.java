package Exc;

import lombok.Data;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;


@Data
abstract class Exc_8 extends Exc_all{

    private String name;
    private int age;
}
@Data
class Worker extends Exc_8{

    private double salary;
    private final Connection con;
    Worker() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc8";
        con = DriverManager.getConnection(mysqlUrl1, "root", Config.getPassword());
        System.out.println("Успешно подключились к бд");
    }

    @Override
    public void sql_show(String a) throws SQLException {
        super.sql_show(a);
    }

    @Override
    public void drop(String a) throws SQLException {
        super.drop(a);
    }

    @Override
    public void excel(String mysqlUrl1) throws ClassNotFoundException, SQLException, IOException {
        super.excel(mysqlUrl1);
    }

    @Override
    public void sql_create() throws SQLException {
        Statement statement1 = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (Name varchar(255), Age varchar(255), Salary " +
                "varchar(255))";
        statement1.executeUpdate(query);
        ResultSet rs1 = statement1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей бд");
        while (rs1.next()) {
            System.out.print(rs1.getString(1));
            System.out.println();
        }
        System.out.println();
    }
    public void section() throws SQLException{
        System.out.print("Введите имя сотрудника: ");
        setName(sc.nextLine());
        System.out.print("Введите возраст сотрудника: ");
        setAge(sc.nextInt());
        System.out.print("Введите зарплату сотрудника: ");
        setSalary(sc.nextDouble());
        String query = "insert into " + getName_table() + " values (?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, getName());
        statement.setInt(2, getAge());
        statement.setDouble(3, getSalary());
        statement.executeUpdate();
        ResultSet rs = statement.executeQuery("select * from " + getName_table());
        while (rs.next()){
            System.out.print(Arrays.toString(rs.getString(1).split("  ")));
            System.out.print(Arrays.toString(rs.getString(2).split("  ")));
            System.out.print(Arrays.toString(rs.getString(3).split("  ")));
            System.out.println();
        }
    }
}
