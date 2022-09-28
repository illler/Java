package Exc;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

interface value{

    void setIndex1(int a);
    int getIndex1();

    void setIndex2(int b);
    int getIndex2();


}

public class Exc_6 extends Exc_all implements value {

    private final Connection con;

    Exc_6() throws SQLException{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc6";
        con = DriverManager.getConnection(mysqlUrl1, "root", Config.getPassword());
        System.out.println("Успешно подключились к бд");
    }

    private int index;
    private int index2;

    @Override
    public void sql_show(String a) throws SQLException {
        super.sql_show(a);
    }

    @Override
    public void sql_create() throws SQLException{
        Statement statement1 = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + getName_table() + " (first_mat varchar(255), second_mat varchar(255)," +
                " dot_mat varchar(255))";
        statement1.executeUpdate(query);
        ResultSet rs1 = statement1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей бд");
        while (rs1.next()) {
            System.out.print(rs1.getString(1));
            System.out.println();
        }
        System.out.println();
    }

    public void section(int x) throws SQLException {
        System.out.println("Введите кол-во строк для первой матрицы: " );
        setIndex1(sc.nextInt());
        System.out.println("Введите кол-во столбцов для первой матрицы:  " );
        setIndex2(sc.nextInt());
        int a = getIndex2();
        int[][] mA = new int[getIndex1()][getIndex2()];
        System.out.println("Введите кол-во строк для второй матрицы: " );
        setIndex1(sc.nextInt());
        System.out.println("Введите кол-во столбцов для второй матрицы: " );
        setIndex2(sc.nextInt());
        int b = getIndex1();
        int[][] mB = new int[getIndex1()][getIndex2()];
        if (a!=b) {
            System.out.println("Две матрицы можно перемножить между собой тогда и только тогда," +
                    " когда количество столбцов первой матрицы равно количеству строк второй матрицы.");
            section(x);
        }
        StringBuilder str = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        System.out.println("Первая матрица");
        for (int i = 0; i<mA.length; i++){
            for (int j = 0; j<mA[i].length; j++){
                System.out.printf("Введите [%d][%d] элемент первой матрицы: ", i, j);
                mA[i][j] = sc.nextInt();
                str.append(mA[i][j]).append(" ");
            }if (i!=mA.length-1) str.append("\n");
        }
        System.out.println();
        System.out.println("Вторая матрица");
        for (int i = 0; i<mB.length; i++){
            for (int j = 0; j<mB[i].length; j++){
                System.out.printf("Введите [%d][%d] элемент второй матрицы: ", i, j);
                mB[i][j] = sc.nextInt();
                str1.append(mB[i][j]).append(" ");
            }if (i!= mB.length-1) str1.append("\n");
        }
        System.out.println();
        int m = mA.length;
        int n = mB[0].length;
        int o = mB.length;
        int[][] res = new int[m][n];
        StringBuilder res_str = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
                res_str.append(res[i][j]).append(" ");
            }if (i!=m-1)res_str.append("\n");
        }

        String query = "insert into " + getName_table() + " values (?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, str.toString());
        statement.setString(2, str1.toString());
        statement.setString(3, res_str.toString());
        statement.executeUpdate();
        if (x==3){
            ResultSet rs2 = statement.executeQuery("SELECT first_mat , second_mat FROM " + getName_table() + "");
            print_sql(rs2);
        }
        else if (x==4){
            ResultSet rs2 = statement.executeQuery("SELECT * FROM " + getName_table() + "");
            print_sql_2(rs2);
        }

    }

    private void print_sql(ResultSet rs2) throws SQLException {
        while (rs2.next()) {
            System.out.println("Матрица 1");
            System.out.println(Arrays.toString(rs2.getString(1).split("  ")));
            System.out.println("Матрица 2");
            System.out.println(Arrays.toString(rs2.getString(2).split("  ")));
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------");

        }
    }
    private void print_sql_2(ResultSet rs2) throws SQLException {
        while (rs2.next()) {
            System.out.println("Матрица 1");
            System.out.println(Arrays.toString(rs2.getString(1).split("  ")));
            System.out.println("Матрица 2");
            System.out.println(Arrays.toString(rs2.getString(2).split("  ")));
            System.out.println();
            System.out.println("Умноженные");
            System.out.print(Arrays.toString(rs2.getString(3).split("  ")));
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void drop() throws SQLException {
        String mysqlUrl1 = "jdbc:mysql://localhost/Exc6";
        super.drop(mysqlUrl1);
    }

    @Override
    public void excel() throws ClassNotFoundException, SQLException, IOException {
        super.excel();
    }

    @Override
    public void setIndex1(int a) {
        index = a;
    }


    @Override
    public int getIndex1() {
        return index;
    }

    @Override
    public void setIndex2(int b) {
        index2 = b;
    }

    @Override
    public int getIndex2() {
        return index2;
    }
}

