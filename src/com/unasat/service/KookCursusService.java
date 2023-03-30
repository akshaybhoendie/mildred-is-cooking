package com.unasat.service;

import com.unasat.dao.KookCursusDao;
import com.unasat.entity.KookCursus;
import com.unasat.utility.Messages;

import java.sql.SQLException;
import java.util.Scanner;

import static com.unasat.utility.UtilityMethods.isInputNotCorrect;

public class KookCursusService {

    public void perform(Scanner scanner) throws SQLException {
        boolean cannotProceed = true;

        while (cannotProceed) {
            Messages.subMenuKookCursus();
            String input = scanner.nextLine();

            if (isInputNotCorrect(input)) {
                Messages.error1();
            } else {
                if (input.trim().equalsIgnoreCase("1")) {
                    break;
                } else if (input.trim().equalsIgnoreCase("2")) {
                    Messages.toevoegenKookCursus();
                    Scanner scanner1 = new Scanner(System.in);
                    String parameters = scanner1.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")) {
                            String[] split = parameters.split("-");
                            if (split.length == 5) {
                                try {
                                    KookCursus kookCursus = new KookCursus();
                                    kookCursus.setCursusNaam(split[0].trim());
                                    kookCursus.setCursusCode(split[1].trim());
                                    kookCursus.setLoopTijd(split[2].trim());
                                    kookCursus.setStartDatum(split[3].trim());
                                    kookCursus.setBedrag(Double.valueOf(split[4].trim()));
                                    KookCursusDao kookCursusDao = new KookCursusDao();
                                    kookCursusDao.insertKookCursus(kookCursus);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                    continue;
                                }
                            } else {
                                Messages.error1();
                            }
                        } else {
                            Messages.error1();
                        }
                        continue;
                    }
                } else if (input.trim().equalsIgnoreCase("3")) {
                    Messages.bewerkenKookCursus();
                    Scanner scanner2 = new Scanner(System.in);
                    String parameters = scanner2.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")) {
                            String[] split = parameters.split("-");
                            if (split.length == 7) {
                                try {
                                    String id = split[0].trim();
                                    String cursusNaam = split[1].trim();
                                    String cursusCode = split[2].trim();
                                    String looptijd = split[3].trim();
                                    String startdatum = split[4].trim();
                                    String verlopen = split[5].trim();
                                    double bedrag = Double.valueOf(split[6].trim());

                                    KookCursusDao kookCursusDao = new KookCursusDao();
                                    kookCursusDao.updateKookCursus(cursusNaam, cursusCode, looptijd, startdatum, verlopen, bedrag, id);
                                } catch (NumberFormatException | SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            } else {
                                Messages.error1();
                            }
                        } else {
                            Messages.error1();
                        }
                        continue;
                    }
                } else if (input.trim().equalsIgnoreCase("4")) {
                    Messages.verwijderenKookCursus();
                    Scanner scanner3 = new Scanner(System.in);
                    String parameters = scanner3.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")) {
                            String[] split = parameters.split("-");
                            if (split.length == 1) {
                                try {
                                    String id = split[0].trim();

                                    KookCursusDao kookCursusDao = new KookCursusDao();
                                    kookCursusDao.deleteKookCursus(id);
                                } catch (NumberFormatException | SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }
                            } else {
                                Messages.error1();
                            }
                        } else {
                            Messages.error1();
                        }
                        continue;
                    }
                } else if (input.trim().equalsIgnoreCase("5")) {
                    Messages.kookCursusBekijken();
                    Scanner scanner4 = new Scanner(System.in);
                    String parameters = scanner4.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else if (parameters.trim().equalsIgnoreCase("1")) {
                            KookCursusDao kookCursusDao = new KookCursusDao();
                            kookCursusDao.overzichtKookCursus();
                    } else {
                        Messages.error1();
                        continue;
                    }
                }
            }
        }
    }
}
