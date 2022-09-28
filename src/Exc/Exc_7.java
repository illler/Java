package Exc;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

public class Exc_7 extends Exc_all{

    private final Connection con;

    Exc_7() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc7";
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
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (first_array varchar(255), sorted_array varchar(255))";
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
        System.out.print("Введите кол-во элементов в массиве: ");
        String query = "insert into " + getName_table() + " values (?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        int a = sc.nextInt();
        int[] array = new int[a];
        for (int i = 0; i<a; i++){
            System.out.printf("Введите %d элемент массива: ", i);
            int b = sc.nextInt();
            array[i] = b;
        }
        statement.setString(1, Arrays.toString(array));

        for (int i = 0; i<a; i++){
            for (int j = 1; j<a; j++){
                if (array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        statement.setString(2, Arrays.toString(array));
        statement.executeUpdate();
        ResultSet rs = statement.executeQuery("select * from " + getName_table());
        while (rs.next()){
            System.out.println("Одномерный массив");
            System.out.println(Arrays.toString(rs.getString(1).split("  ")));
            System.out.println();
            System.out.println("Отсортированный одномнрный массив");
            System.out.println(Arrays.toString(rs.getString(2).split("  ")));
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }



    @Override
    public void drop() throws SQLException {
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc7";
        super.drop(mysqlUrl1);
    }

    @Override
    public void excel() throws ClassNotFoundException, SQLException, IOException {
        super.excel();
    }
}
