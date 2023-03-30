package com.unasat.entity;

import java.time.LocalDate;

public class Deelnemer {

    private Long id;
    private String naam;
    private String voornaam;
    private String geboorteDatum;
    private String gender;
    private double betaaldBedrag;
    private boolean verwijderd;

    public Deelnemer() {
    }

    public Deelnemer(Long id, String naam, String voornaam, String geboorteDatum, String gender, double betaaldBedrag, boolean verwijderd) {
        this.id = id;
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
        this.gender = gender;
        this.betaaldBedrag = betaaldBedrag;
        this.verwijderd = verwijderd;
    }

    public Deelnemer(String naam, String voornaam, String geboorteDatum, String gender, double betaaldBedrag) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
        this.gender = gender;
        this.betaaldBedrag = betaaldBedrag;
    }

    @Override
    public String toString() {
        return "Deelnemer{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", achternaam='" + voornaam + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                ", gender=" + gender +
                ", betaaldBedrag=" + betaaldBedrag +
                ", verwijderd=" + verwijderd +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBetaaldBedrag() {
        return betaaldBedrag;
    }

    public void setBetaaldBedrag(double betaaldBedrag) {
        this.betaaldBedrag = betaaldBedrag;
    }

    public boolean isVerwijderd() {
        return verwijderd;
    }

    public void setVerwijderd(boolean verwijderd) {
        this.verwijderd = verwijderd;
    }
}
