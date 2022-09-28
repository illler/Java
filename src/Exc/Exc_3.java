package Exc;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

class Exc_3 extends Exc_all{


    private final Connection con;

    Exc_3() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc3";
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
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (list_numbers varchar(255), type varchar(255))";
        statement1.executeUpdate(query);
        ResultSet rs1 = statement1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей бд");
        while (rs1.next()) {
            System.out.print(rs1.getString(1));
            System.out.println();
        }
        System.out.println();
    }

    public void case_3() throws SQLException{
        
        ArrayList<String> numbers = new ArrayList<>();
        System.out.println("Вводите числа пока не надоест, как устанете введите 'STOP'");
        String a = sc.next();
        while (!a.equals("STOP")){
            if (a.contains(",")) {
                System.out.println("Число должно быть целым!");
                a = sc.next();
            }
            String type_num = "";
            try {
                Integer.parseInt(a);
                if (Integer.parseInt(a)%2==0) type_num = "четное";
                else type_num = "нечетное";
                numbers.add(a + " " + type_num);
                a = sc.next();
            }catch (Exception e){
                System.out.println("Введите число!");
                a = sc.next();
            }

        }

        for (int i = 0; i<numbers.size(); i++){
            String query = "insert into " + getName_table() + " (list_numbers, type) values (?, ?)";
            PreparedStatement statement2 = con.prepareStatement(query);
            statement2.setString(1, numbers.get(i).split(" ")[0]);
            statement2.setString(2,  numbers.get(i).split(" ")[1]);
            statement2.executeUpdate();
            if (i== numbers.size()-1){
                ResultSet rs2 = statement2.executeQuery("SELECT list_numbers, type FROM " + getName_table() + "");
                while (rs2.next()) {
                    System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
                    System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
    @Override
    public void drop() throws SQLException {
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc3";
        super.drop(mysqlUrl1);
    }

    @Override
    public void excel() throws ClassNotFoundException, SQLException, IOException {
        super.excel();
    }
}
