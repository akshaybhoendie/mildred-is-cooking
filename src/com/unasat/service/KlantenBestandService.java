package com.unasat.service;

import com.unasat.dao.DeelnemerDao;
import com.unasat.entity.Deelnemer;
import com.unasat.utility.Messages;

import java.sql.SQLException;
import java.util.Scanner;

import static com.unasat.utility.UtilityMethods.isInputNotCorrect;

public class KlantenBestandService {


    public void perform(Scanner scanner) {
        boolean cannotProceed = true;

        while(cannotProceed) {
            Messages.subMenuKlantenBestand();
            String input = scanner.nextLine();

            if (isInputNotCorrect(input)) {
                Messages.error1();
            } else {
                if (input.trim().equalsIgnoreCase("1")) {
                    break;
                } else if (input.trim().equalsIgnoreCase("2")){
                    Messages.bewerkenKlantenBestand();
                    Scanner scanner1 = new Scanner(System.in);
                    String parameters = scanner1.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")){
                            String[] split = parameters.split("-");
                            if(split.length == 6){
                                try{
                                    String naam = split[0].trim();
                                    String voorNaam = split[1].trim();
                                    String geboorteDatum = split[2].trim();
                                    String gender = split[3].trim();
                                    double betaaldBedrag = Double.valueOf(split[4]);
                                    String id = split[5].trim();
                                    DeelnemerDao dao = new DeelnemerDao();
                                    dao.updateDeelnemer(id, naam, voorNaam, geboorteDatum, gender,betaaldBedrag );
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
                } else if (input.trim().equalsIgnoreCase("3")){
                    Messages.verwijderenDeelnemer();
                    Scanner scanner1 = new Scanner(System.in);
                    String parameters = scanner1.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")){
                            String[] split = parameters.split("-");
                            if(split.length == 1){
                                try{
                                    String id = split[0].trim();
                                    DeelnemerDao dao = new DeelnemerDao();
                                    dao.deleteDeelnemer(id);
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
