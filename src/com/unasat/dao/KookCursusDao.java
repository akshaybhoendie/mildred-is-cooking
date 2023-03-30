package com.unasat.dao;

import com.unasat.dao.connection.DatabaseConnection;
import com.unasat.entity.KookCursus;
import com.unasat.utility.Messages;
import com.unasat.utility.UtilityMethods;

import java.sql.*;
import java.time.LocalDate;

import static com.unasat.utility.UtilityMethods.convertLocalDateToSqlDate;
import static com.unasat.utility.UtilityMethods.generatedColumns;

public class KookCursusDao {

    private Connection connection = DatabaseConnection.connectToDB();
    private final String insertKookCursus = "insert into kookcursus (cursus_naam,cursus_code,looptijd,startdatum,bedrag) values (?,?,?,?,?)";
    private final String zoekIdKookcursus = "SELECT * FROM kookcursus WHERE cursus_code=? AND verwijderd=0 LIMIT 1";
    private final String updateCursus = "UPDATE kookcursus kd SET kd.cursus_naam=?, kd.cursus_code=?, kd.looptijd=?, kd.startdatum=?, kd.verlopen=?, kd.bedrag=? WHERE kd.id=?;";
    private final String deleteCursus = "UPDATE kookcursus kd SET kd.verwijderd = '1' WHERE kd.id=?;";
    private final String overzichtKookcursus = "SELECT v.id, v.cursus_naam, v.cursus_code, v.looptijd, v.startdatum, v.bedrag FROM kookcursus v WHERE v.verwijderd='0';";

    public KookCursusDao() throws SQLException {
    }

    public Long insertKookCursus(KookCursus cursus) throws SQLException {
        Long kookCursusID = null;
        PreparedStatement statement = connection.prepareStatement(insertKookCursus,generatedColumns);

        statement.setString(1, cursus.getCursusNaam());
        statement.setString(2, cursus.getCursusCode());
        statement.setString(3, cursus.getLoopTijd());
        statement.setDate(4, Date.valueOf(cursus.getStartDatum().replace("/","-")));
        statement.setDouble(5,cursus.getBedrag());

        int affectedRow = statement.executeUpdate();
        if (affectedRow == 0) {
            throw new SQLException("Kookcursus toevoegen gefaald");
        }else{
            System.out.println("Kookcursus toevoegen success");
        }

        ResultSet resultSet = statement.getGeneratedKeys();

        while (resultSet.next()){
            kookCursusID = resultSet.getLong(1);
            System.out.println("Inserted Kookcursus ID - " + kookCursusID); // display id inserted record
        }

        statement.close();
        connection.close();
        return kookCursusID;
    }

    public KookCursus searchKookCursusByCode(String kookCursusCode) throws SQLException {
        PreparedStatement zoekKookCursusStatement = connection.prepareStatement(zoekIdKookcursus);
        zoekKookCursusStatement.setString(1, kookCursusCode);
        ResultSet resultSet = zoekKookCursusStatement.executeQuery();

        Long kookCursusId = null;
        double cursusBedrag = 0.0;
        KookCursus kookCursus = null;
        while (resultSet.next()){
            kookCursusId = resultSet.getLong("id");
            String cursusNaam = resultSet.getString("cursus_naam");
            String cursusCode = resultSet.getString("cursus_code");
            String looptijd = resultSet.getString("looptijd");
            String startDatum = UtilityMethods.convertSqlDateToLocalDateToString(resultSet.getDate("startdatum"));
            cursusBedrag = resultSet.getDouble("bedrag");
            boolean verlopen = UtilityMethods.intToBoolean(resultSet.getInt("verlopen"));
            boolean verwijderd = UtilityMethods.intToBoolean(resultSet.getInt("verwijderd"));

            kookCursus = new KookCursus();
            kookCursus.setId(kookCursusId);
            kookCursus.setCursusNaam(cursusNaam);
            kookCursus.setCursusCode(cursusCode);
            kookCursus.setLoopTijd(looptijd);
            kookCursus.setStartDatum(startDatum);
            kookCursus.setBedrag(cursusBedrag);
            kookCursus.setVerlopen(verlopen);
            kookCursus.setVerwijderd(verwijderd);
        }

        zoekKookCursusStatement.close();
        connection.close();
        return kookCursus;
    }

    public void updateKookCursus(String cursusNaam, String cursusCode, String loopTijd, String startDatum, String verlopen, double bedrag,  String cursusId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updateCursus);
        preparedStatement.setString(1, cursusNaam);
        preparedStatement.setString(2, cursusCode);
        preparedStatement.setString(3, loopTijd);
        preparedStatement.setDate(4, Date.valueOf(startDatum.replace("/", "-")));
        preparedStatement.setString(5, verlopen);
        preparedStatement.setDouble(6, bedrag);
        preparedStatement.setLong(7, Long.valueOf(cursusId));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Update gefaald");
        }else{
            System.out.println("Update success");
        }

        preparedStatement.close();
        connection.close();
    }

    public void deleteKookCursus(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(deleteCursus);
        preparedStatement.setLong(1, Long.valueOf(id));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("verwijderen gefaald");
        }else{
            System.out.println("verwijderen success");
        }

        preparedStatement.close();
        connection.close();
    }

    public void overzichtKookCursus() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(overzichtKookcursus);
        ResultSet resultSet = ps.executeQuery();

        Messages.headerKookcursus();

        while (resultSet.next()){
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("cursus_naam");
            String code = resultSet.getString("cursus_code");
            String looptijd = resultSet.getString("looptijd");
            String date = resultSet.getDate("startdatum").toLocalDate().toString();
            double bedrag = resultSet.getDouble("bedrag");

            System.out.println(id + " - " + name + " - " + code + " - " + looptijd + " - " + date + " - " + bedrag);
        }

        System.out.println("====================================================================================================");
        resultSet.close();
        ps.close();
        connection.close();
    }
}
