package sql;

import java.sql.*;

public class Baglanti {

    private String kullanici_adi = "root";
    private String parola = "";
    private String db_name = "test";
    private String host = "localhost";
    private int port = 3306;

    private Connection con = null;

    private Statement statement = null;

    public Baglanti(){
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_name;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadi");
        }
        try {
            con = DriverManager.getConnection(url,kullanici_adi,parola);
            System.out.println("sql.Baglanti basarili...");
        } catch (SQLException e) {
            System.out.println("sql.Baglanti Basarisiz...");
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}