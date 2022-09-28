package Exc;

import java.io.IOException;
import java.sql.*;
import java.util.*;


interface get_set{

    String getStr2();
    void setStr2(String a);

    String getStr3();
    void setStr3(String a);

}

public class Exc_4 extends Exc_all implements get_set{

    private final Connection con;

    Exc_4() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc4";
        con = DriverManager.getConnection(mysqlUrl1, "root", Config.getPassword());
        System.out.println("Успешно подключились к бд");
    }

    static ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public void sql_show(String a) throws SQLException {
        super.sql_show(a);
    }

    @Override
    public void sql_create() throws SQLException{
        Statement statement1 = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (first_str varchar(255), second_str varchar(255)," +
                "substring varchar(255), to_lower_case varchar(255), to_upper_case varchar(255), endWith varchar(255))";
        statement1.executeUpdate(query);
        ResultSet rs1 = statement1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей бд");
        while (rs1.next()) {
            System.out.print(rs1.getString(1));
            System.out.println();
        }
        System.out.println();
    }

    public void print_sql(ResultSet rs2) throws SQLException{
        while (rs2.next()) {
            System.out.print(Arrays.toString(rs2.getString(1).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(2).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(3).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(4).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(5).split(" ")));
            System.out.print(Arrays.toString(rs2.getString(6).split(" ")));
            System.out.println();
        }
    }

    public void insert(Connection con) throws SQLException {
        String query = "insert into " + getName_table() + " (first_str, second_str," +
                "substring, to_lower_case, to_upper_case, endWith)" +
                " values (?, ?, ?, ?, ?, ?) ";
        PreparedStatement statement2 = con.prepareStatement(query);
        statement2.setString(1, getStr2());
        statement2.setString(2, getStr3());
        statement2.setString(3, "");
        statement2.setString(4, "");
        statement2.setString(5, "");
        statement2.setBoolean(6, false);
        statement2.executeUpdate();
    }

    public void all_section(int x) throws SQLException {
        System.out.print("Введите первую строку: ");
        setStr2(sc.next());
        System.out.print("Введите вторую строку: ");
        setStr3(sc.next());
        String a = getStr3();
        String b = getStr2();
        if (arrayList.contains(a) && arrayList.contains(b)) {
            update(x);
        }
        else {
            arrayList.add(getStr2());
            arrayList.add(getStr3());
            insert(con);
            update(x);
        }
    }
    public void update(int x) throws  SQLException{
        switch (x){
            case 3 -> {
                System.out.println("Введите два индекса");
                int a = sc.nextInt();
                int b = sc.nextInt();
                String qq = (getStr2().substring(a, b) + " " + getStr3().substring(a, b));
                String query = "UPDATE " + getName_table() + " SET substring = '" + qq + "' WHERE first_str = ? and second_str = ?";
                PreparedStatement statement2 = con.prepareStatement(query);
                statement2.setString(1, getStr2());
                statement2.setString(2, getStr3());
                statement2.executeUpdate();
                ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
                print_sql(rs2);
            }
            case 4 -> {
                String query = "update " + getName_table() + " set to_lower_case = '" + (getStr2().toLowerCase() + " " +
                        getStr3().toLowerCase()) + "' WHERE first_str = ? and second_str = ?";
                PreparedStatement statement2 = con.prepareStatement(query);
                statement2.setString(1, getStr2());
                statement2.setString(2, getStr3());
                statement2.executeUpdate();
                ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
                print_sql(rs2);
            }
            case 5 -> {
                String query = "update " + getName_table() + " set to_upper_case = '" + (getStr2().toUpperCase() + " " +
                        getStr3().toUpperCase()) + "' WHERE first_str = ? and second_str = ?";
                PreparedStatement statement2 = con.prepareStatement(query);
                statement2.setString(1, getStr2());
                statement2.setString(2, getStr3());
                statement2.executeUpdate();
                ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
                print_sql(rs2);
            }
            case 6 -> {
                System.out.print("Введите строку: ");
                String und = sc.next();
                System.out.println((getStr2().contains(und)) ? "Подстрока содержится в первой строке": "Подстрока не содержится в строке");
                System.out.println((getStr3().contains(und)) ? "Подстрока содержится во второй строке": "Подстрока не содержится в строке");
                String query = "update " + getName_table() + " set endWith = '" + (getStr2().endsWith(und) + " " +
                        getStr3().endsWith(und)) + "' WHERE first_str = ? and second_str = ?";
                PreparedStatement statement2 = con.prepareStatement(query);
                statement2.setString(1, getStr2());
                statement2.setString(2, getStr3());
                statement2.executeUpdate();
                ResultSet rs2 = statement2.executeQuery("SELECT * FROM " + getName_table() + "");
                print_sql(rs2);
            }
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

    private String str2;
    private String str3;

    @Override
    public String getStr2() {
        return str2;
    }

    @Override
    public void setStr2(String a) {
        str2 = a;
    }

    @Override
    public String getStr3() {
        return str3;
    }

    @Override
    public void setStr3(String a) {
        str3 = a;
    }

}
