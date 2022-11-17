package sql;

import java.sql.*;

public class DatabaseIslemler {

    public void calisanlarGetir(){
        Baglanti baglanti = new Baglanti();
        String sorgu = "Select * From calisanlar";

        try {
            baglanti.setStatement(baglanti.getCon().createStatement());
            ResultSet rs = baglanti.getStatement().executeQuery(sorgu);
            while (rs.next()){
                Calisan calisan = new Calisan(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("departman"));
                /*int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String departman = rs.getString("departman");
                String balance = rs.getString("balance");
                String hours = rs.getString("hours");*/
                //System.out.println("Id:" + id + "\nAd:" + name + "\nSoyad:" + surname + "\nBalance:" + balance + "\nHours:" + hours);
                if(calisan.getDepartman().equals("asistant")){
                    System.out.println("Welcome Asistant");
                    System.out.println("Id:" + calisan.getId() + "\nAd:" + calisan.getName() + "\nSoyad:" + calisan.getSurname() + "\nDepartman:" + calisan.getDepartman());
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
