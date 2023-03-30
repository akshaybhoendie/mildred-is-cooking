package com.unasat.dao;

import com.unasat.dao.connection.DatabaseConnection;
import com.unasat.utility.Messages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchuldenDao {

    private Connection connection = DatabaseConnection.connectToDB();

    private final String schuldBekijkenOpbasisVanNaamEnVoornaamEnKookCursusCode = "SELECT d.id,d.naam,d.voornaam,k.cursus_naam,k.cursus_code, k.bedrag,d.betaald_bedrag, kd.rest_bedrag, kd.resultaat FROM kookcursus_deelnemer kd\n" +
            "JOIN deelnemers d ON d.id = kd.deelnemer_id\n" +
            "JOIN kookcursus k ON k.id = kd.kookcursus_id\n" +
            "WHERE d.naam = ?\n" +
            "AND d.voornaam = ?\n" +
            "AND k.cursus_code = ?\n" +
            "AND kd.rest_bedrag > 0;";

    private final String bekijkSchuldPerKookCursus = "SELECT d.id,d.naam,d.voornaam,k.cursus_naam,k.cursus_code, k.bedrag,d.betaald_bedrag, kd.rest_bedrag, kd.resultaat FROM kookcursus_deelnemer kd\n" +
            "JOIN deelnemers d ON d.id = kd.deelnemer_id\n" +
            "JOIN kookcursus k ON k.id = kd.kookcursus_id\n" +
            "WHERE k.cursus_code = ?\n" +
            "AND kd.rest_bedrag > 0;";

    private final String bekijkAlleSchulden = "SELECT d.id,d.naam,d.voornaam,k.cursus_naam,k.cursus_code, k.bedrag,d.betaald_bedrag, kd.rest_bedrag, kd.resultaat FROM kookcursus_deelnemer kd\n" +
            "JOIN deelnemers d ON d.id = kd.deelnemer_id\n" +
            "JOIN kookcursus k ON k.id = kd.kookcursus_id\n" +
            "WHERE kd.rest_bedrag > 0;";

    private final String updateSchuld = "UPDATE kookcursus_deelnemer kd SET kd.rest_bedrag=? WHERE kd.deelnemer_id=? AND kd.kookcursus_id=?";

    private final String bekijkPrestatie = "SELECT d.naam, d.voornaam, k.cursus_naam, k.cursus_code, kd.resultaat FROM kookcursus_deelnemer kd \n" +
            "join deelnemers d ON d.id = kd.deelnemer_id \n" +
            "JOIN kookcursus k ON k.id = kd.kookcursus_id\n" +
            "WHERE kd.resultaat = '1';";


    public SchuldenDao() throws SQLException {
    }


    public void schuldenbekijkenPersoonCursus(String naam, String voornaam, String cursusCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(schuldBekijkenOpbasisVanNaamEnVoornaamEnKookCursusCode);
        statement.setString(1, naam);
        statement.setString(2, voornaam);
        statement.setString(3, cursusCode);

        ResultSet resultSet = statement.executeQuery();

        Messages.header();

        while (resultSet.next()){
            Long persoonId = resultSet.getLong("id");
            String persoon_naam = resultSet.getString("naam");
            String persoon_voornaam = resultSet.getString("voornaam");
            String cursus_naam = resultSet.getString("cursus_naam");
            String cursus_code = resultSet.getString("cursus_code");
            double bedrag = resultSet.getDouble("bedrag");
            double betaald_bedrag = resultSet.getDouble("betaald_bedrag");
            double rest_bedrag = resultSet.getDouble("rest_bedrag");
            double resultaat = resultSet.getDouble("resultaat");
            String resultaatString = null;
            if(resultaat == 0.0){
                resultaatString = "Niet Behaald";
            } else {
                resultaatString = "Behaald";
            }

            System.out.println("====================================================================================================");
            System.out.println(persoonId + " - " + persoon_naam + " - " + persoon_voornaam + " - " + cursus_naam + " - " + cursus_code + " - " + "SRD" + bedrag + " - " + "SRD" + betaald_bedrag + " - " + "SRD" + rest_bedrag + " - " + resultaatString);
            System.out.println("====================================================================================================");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public void bekijkSchuldPerCursus(String cursusCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(bekijkSchuldPerKookCursus);
        statement.setString(1, cursusCode);

        ResultSet resultSet = statement.executeQuery();

        Messages.header();

        while (resultSet.next()){
            Long persoonId = resultSet.getLong("id");
            String persoon_naam = resultSet.getString("naam");
            String persoon_voornaam = resultSet.getString("voornaam");
            String cursus_naam = resultSet.getString("cursus_naam");
            String cursus_code = resultSet.getString("cursus_code");
            double bedrag = resultSet.getDouble("bedrag");
            double betaald_bedrag = resultSet.getDouble("betaald_bedrag");
            double rest_bedrag = resultSet.getDouble("rest_bedrag");
            double resultaat = resultSet.getDouble("resultaat");
            String resultaatString = null;
            if(resultaat == 0.0){
                resultaatString = "Niet Behaald";
            } else {
                resultaatString = "Behaald";
            }

            System.out.println("====================================================================================================");
            System.out.println(persoonId + " - " + persoon_naam + " - " + persoon_voornaam + " - " + cursus_naam + " - " + cursus_code + " - " + "SRD" + bedrag + " - " + "SRD" + betaald_bedrag + " - " + "SRD" + rest_bedrag + " - " + resultaatString);
            System.out.println("====================================================================================================");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public void bekijkAlleSchulden() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(bekijkAlleSchulden);
        ResultSet resultSet = statement.executeQuery();

        Messages.header();

        while (resultSet.next()){
            Long persoonId = resultSet.getLong("id");
            String persoon_naam = resultSet.getString("naam");
            String persoon_voornaam = resultSet.getString("voornaam");
            String cursus_naam = resultSet.getString("cursus_naam");
            String cursus_code = resultSet.getString("cursus_code");
            double bedrag = resultSet.getDouble("bedrag");
            double betaald_bedrag = resultSet.getDouble("betaald_bedrag");
            double rest_bedrag = resultSet.getDouble("rest_bedrag");
            double resultaat = resultSet.getDouble("resultaat");
            String resultaatString = null;
            if(resultaat == 0.0){
                resultaatString = "Niet Behaald";
            } else {
                resultaatString = "Behaald";
            }

            System.out.println(persoonId + " - " + persoon_naam + " - " + persoon_voornaam + " - " + cursus_naam + " - " + cursus_code + " - " + "SRD" + bedrag + " - " + "SRD" + betaald_bedrag + " - " + "SRD" + rest_bedrag + " - " + resultaatString);
        }
        System.out.println("====================================================================================================");
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void updateCursusDeelnemerSchuldById(String deelNemerId, String cursusId, String restbedrag) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updateSchuld);
        preparedStatement.setDouble(1, Double.valueOf(restbedrag));
        preparedStatement.setInt(2, Integer.valueOf(deelNemerId));
        preparedStatement.setInt(3, Integer.valueOf(cursusId));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Update gefaald");
        }

        preparedStatement.close();
        connection.close();
    }

    public void bekijkPrestatie() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(bekijkPrestatie);
        ResultSet resultSet = ps.executeQuery();

        Messages.headerPrestaties();

        while (resultSet.next()){
            String naam = resultSet.getString("naam");
            String voornaam = resultSet.getString("voornaam");
            String cursusNaam = resultSet.getString("cursus_naam");
            String cursusCode = resultSet.getString("cursus_code");
            String resultaat = resultSet.getString("resultaat");

            System.out.println(naam + " - " + voornaam + " - " + cursusNaam + " - " + cursusCode + " - " + resultaat);
        }

        System.out.println("====================================================================================================");
        resultSet.close();
        ps.close();
        connection.close();
    }
}
