package Exc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.*;


public class Exc8_2 extends Exc_all{
    Scanner sc = new Scanner(System.in);

    public void sql() throws SQLException {
        DriverManager.registerDriver(new Driver());
        String mysqlUrl = "jdbc:mysql://localhost/kursovaya";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "16213026_Ai");
        System.out.println("Connection successfully");
        String tablename = "all_data";
        String query = "SELECT * FROM " + tablename;
        PreparedStatement pre_stat = con.prepareStatement(query);
        ResultSet rs = pre_stat.executeQuery();
        ArrayList<String[]> b = new ArrayList<>();
        while (rs.next()) {
            String index = rs.getString(2);
            if (rs.getString(2).equals("76373(н.б.)")) {
                index = rs.getString(2).replace("(н.б.)", "");
            }
            b.add((index + " " +rs.getString(4) + " " + rs.getString(5)
                    + " " + rs.getString(7) + " " + rs.getString(8) + " " + rs.getString(9)
                    + " " + rs.getString(10) + " " + rs.getString(11)).split(" "));
        }
        System.out.println("Do you want to find info with approximate date or exact date?\n" +
                "Select 1 or 2.");
        if (sc.nextInt()==1) {
            approximate_date(b);
            exact_date(b);
        }
    }

    public void approximate_date(ArrayList<String[]> b){
        System.out.print("Enter a code post: ");
        String post_code = sc.next();
        System.out.print("Enter date (format Y-m-d): ");
        String[] date = sc.next().split("-");
        b.stream().sorted(Comparator.comparing(strings -> Integer.parseInt(strings[0])))
                .filter(strings -> strings[0].equals(post_code) & (strings[1].contains(date[0])))
                .forEach(strings -> System.out.println(Arrays.toString(strings)));
    }

    public void exact_date(ArrayList<String[]> b){
        System.out.print("Enter a code post: ");
        String post_code = sc.next();
        System.out.print("Enter date (format Y-m-d): ");
        String date = sc.next();
        b.stream().sorted(Comparator.comparing(strings -> Integer.parseInt(strings[0])))
                .filter(strings -> strings[0].equals(post_code) & (strings[1].contains(date)))
                .forEach(strings -> System.out.println(Arrays.toString(strings)));
    }

    public static void main(String[] args) throws SQLException {
        Exc8_2 database = new Exc8_2();
        database.sql();
    }
}