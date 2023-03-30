package com.unasat.service;

import com.unasat.dao.DeelnemerDao;
import com.unasat.dao.KookCursusDao;
import com.unasat.entity.Deelnemer;
import com.unasat.entity.KookCursus;
import com.unasat.utility.Messages;

import java.sql.SQLException;
import java.util.Scanner;

import static com.unasat.utility.UtilityMethods.isInputNotCorrect;

public class DeelnemersService {


    public void perform(Scanner scanner) {
        boolean cannotProceed = true;

        while(cannotProceed) {
            Messages.subMenuInschrijvingen();
            String input = scanner.nextLine();

            if (isInputNotCorrect(input)) {
                Messages.error1();
            } else {
                if (input.trim().equalsIgnoreCase("1")) {
                    break;
                } else if (input.trim().equalsIgnoreCase("2")){
                    Messages.deelnemerInschrijven();
                    Scanner scanner1 = new Scanner(System.in);
                    String parameters = scanner1.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")){
                            String[] split = parameters.split("-");
                            if(split.length == 6){
                                try{
                                    Deelnemer deelnemer = new Deelnemer();
                                    deelnemer.setNaam(split[0].trim());
                                    deelnemer.setVoornaam(split[1].trim());
                                    deelnemer.setGeboorteDatum(split[2].trim());
                                    deelnemer.setGender(split[3].trim());
                                    deelnemer.setBetaaldBedrag(Double.valueOf(split[4].trim()));
                                    String kookCursus = split[5].trim();
                                    DeelnemerDao dao = new DeelnemerDao();
                                    dao.inschrijvingDeelnemer(deelnemer, kookCursus);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                    continue;
                                }
                            }else{
                                Messages.error1();
                            }
                        }else{
                            Messages.error1();
                        }
                        continue;
                    }
                }
            }
        }
    }
}
