package com.unasat.dao;

import com.unasat.dao.connection.DatabaseConnection;
import com.unasat.entity.Deelnemer;
import com.unasat.entity.KookCursus;

import java.sql.*;
import java.time.LocalDate;

import static com.unasat.utility.UtilityMethods.generatedColumns;

public class KookCursusDeelnemerDao {

    private Connection connection = DatabaseConnection.connectToDB();
    private final String insertKookcursusDeelnemer = "insert into kookcursus_deelnemer (kookcursus_id,deelnemer_id,rest_bedrag,inschrijfdatum,resultaat) values (?,?,?,?,?)";

    public KookCursusDeelnemerDao() throws SQLException {
    }

    public Long insertKookCursusDeelnemer(Deelnemer deelnemer, KookCursus cursus) throws SQLException {
        PreparedStatement insertCursusDeelnemerStatement = connection.prepareStatement(insertKookcursusDeelnemer, generatedColumns);
        Date inschrijfDatum = Date.valueOf(LocalDate.now());

        double restBedrag = 0.0;
        if(deelnemer != null && cursus != null){
            restBedrag = cursus.getBedrag() - deelnemer.getBetaaldBedrag();
        }else{
            System.out.println("De deelnemer heeft een bedrag van srd 0 betaald");
        }

        insertCursusDeelnemerStatement.setLong(1, cursus.getId());
        insertCursusDeelnemerStatement.setLong(2, deelnemer.getId());
        insertCursusDeelnemerStatement.setDouble(3, restBedrag);
        insertCursusDeelnemerStatement.setDate(4, inschrijfDatum);
        insertCursusDeelnemerStatement.setInt(5, 0);

        int affectedRowsCursusDeelnemer = insertCursusDeelnemerStatement.executeUpdate();
        if (affectedRowsCursusDeelnemer == 0) {
            throw new SQLException("Cursus Deelnemer toevoegen gefaald");
        }

        ResultSet rs = insertCursusDeelnemerStatement.getGeneratedKeys();

        Long cursusDeelnemerId = null;
        if (rs.next()) {
            cursusDeelnemerId = rs.getLong(1);
            System.out.println("Inserted Kookcursus deelnemer ID - " + cursusDeelnemerId); // display id inserted record
        }

        insertCursusDeelnemerStatement.close();
        connection.close();

        return cursusDeelnemerId;
    }

}
