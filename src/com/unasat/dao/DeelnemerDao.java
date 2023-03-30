package com.unasat.dao;

import com.unasat.dao.connection.DatabaseConnection;
import com.unasat.entity.Deelnemer;
import com.unasat.entity.KookCursus;
import com.unasat.utility.Messages;

import java.sql.*;

import static com.unasat.utility.UtilityMethods.generatedColumns;
import static com.unasat.utility.UtilityMethods.intToBoolean;

public class DeelnemerDao {

    private Connection connection = DatabaseConnection.connectToDB();

    private final String insertDeelnemerQuery = "insert into deelnemers (naam,voornaam,geboorte_datum,geslacht,betaald_bedrag) values (?,?,?,?,?)";
    private final String findDeelnemerById = "select * from deelnemers where id=? and verwijderd=0";
    private final String inschrijvingenPerCursusBekijken = "SELECT d.id,d.naam,d.voornaam,k.cursus_naam,k.cursus_code, k.bedrag,d.betaald_bedrag, kd.rest_bedrag, kd.resultaat FROM kookcursus_deelnemer kd\n" +
            "JOIN deelnemers d ON d.id = kd.deelnemer_id\n" +
            "JOIN kookcursus k ON k.id = kd.kookcursus_id\n" +
            "WHERE k.cursus_code = ?;";

    private final String updateDeelnemer = "UPDATE deelnemers d SET d.naam=?, d.voornaam=?, d.geboorte_datum=?, d.geslacht=?, d.betaald_bedrag=? WHERE d.id=?;";
    private final String deleteDeelNemer = "UPDATE deelnemers d SET d.verwijderd='1' WHERE d.id=?;";

    public DeelnemerDao() throws SQLException {
    }

    public Long inschrijvingDeelnemer(Deelnemer deelnemer, String kookCursusCode) throws SQLException {
        PreparedStatement insertDeelnemerStatement = connection.prepareStatement(insertDeelnemerQuery, generatedColumns);

        insertDeelnemerStatement.setString(1, deelnemer.getNaam());
        insertDeelnemerStatement.setString(2, deelnemer.getVoornaam());
        insertDeelnemerStatement.setString(3, deelnemer.getGeboorteDatum());
        insertDeelnemerStatement.setString(4, deelnemer.getGender());
        insertDeelnemerStatement.setDouble(5, deelnemer.getBetaaldBedrag());

        int affectedRows = insertDeelnemerStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Deelnemer toevoegen gefaald");
        }

        ResultSet rs = insertDeelnemerStatement.getGeneratedKeys();

        Long deelnemerId = null;
        if (rs.next()) {
            deelnemerId = rs.getLong(1);
            System.out.println("Inserted Deelnemer ID - " + deelnemerId); // display id inserted record
        }

        Deelnemer deelnemerById = findDeelnemerById(deelnemerId);

        KookCursusDao kookCursusDao = new KookCursusDao();
        KookCursus kookCursus = kookCursusDao.searchKookCursusByCode(kookCursusCode);

        KookCursusDeelnemerDao kookCursusDeelnemerDao = new KookCursusDeelnemerDao();
        kookCursusDeelnemerDao.insertKookCursusDeelnemer(deelnemerById, kookCursus);


        insertDeelnemerStatement.close();
        connection.close();

        return deelnemerId;
    }

    public Deelnemer findDeelnemerById(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(findDeelnemerById);
        statement.setLong(1,id);

        ResultSet resultSet = statement.executeQuery();
        Deelnemer deelnemer = null;

        while(resultSet.next()){
            Long id1 = resultSet.getLong("id");
            String naam = resultSet.getString("naam");
            String voornaam = resultSet.getString("voornaam");
            String geboorteDatum = resultSet.getString("geboorte_datum");
            String geslacht = resultSet.getString("geslacht");
            double betaaldBedrag = resultSet.getDouble("betaald_bedrag");
            int verwijderd = resultSet.getInt("verwijderd");

            deelnemer = new Deelnemer();
            deelnemer.setId(id1);
            deelnemer.setNaam(naam);
            deelnemer.setVoornaam(voornaam);
            deelnemer.setGeboorteDatum(geboorteDatum);
            deelnemer.setGender(geslacht);
            deelnemer.setBetaaldBedrag(betaaldBedrag);
            deelnemer.setVerwijderd(intToBoolean(verwijderd));
        }

        statement.close();
        resultSet.close();
        connection.close();

        return deelnemer;
    }

    public void bekijkInschrijvingenPerCursus(String cursusCode) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(inschrijvingenPerCursusBekijken);
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

        statement.close();
        resultSet.close();
        connection.close();
    }

    public void updateDeelnemer(String id, String naam, String voornaam, String geboorteDatum, String gender, double betaaldBedrag) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement(updateDeelnemer);
            preparedStatement.setString(1, naam);
            preparedStatement.setString(2, voornaam);
            preparedStatement.setString(3, geboorteDatum);
            preparedStatement.setString(4, gender);
            preparedStatement.setDouble(5, betaaldBedrag);
            preparedStatement.setLong(6, Long.valueOf(id));

        int i = preparedStatement.executeUpdate();
        if (i == 0) {
            throw new SQLException("Update deelnemer gefaald");
        }else{
            System.out.println("Update deelnemer success");
        }

        preparedStatement.close();
        connection.close();
    }

    public void deleteDeelnemer(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(deleteDeelNemer);
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
}
