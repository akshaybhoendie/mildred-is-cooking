package com.unasat.entity;

import java.time.LocalDate;

public class KookCursus {

    private Long id;
    private String cursusNaam;
    private String cursusCode;
    private String loopTijd;
    private double bedrag;
    private String startDatum;
    private boolean verlopen;
    private boolean verwijderd;

    public KookCursus() {
    }

    public KookCursus(Long id, String cursusNaam, String cursusCode, String loopTijd, double bedrag, String startDatum, boolean verlopen, boolean verwijderd) {
        this.id = id;
        this.cursusNaam = cursusNaam;
        this.cursusCode = cursusCode;
        this.loopTijd = loopTijd;
        this.bedrag = bedrag;
        this.startDatum = startDatum;
        this.verlopen = verlopen;
        this.verwijderd = verwijderd;
    }

    public KookCursus(String cursusNaam, String cursusCode, String loopTijd, double bedrag, String startDatum) {
        this.cursusNaam = cursusNaam;
        this.cursusCode = cursusCode;
        this.loopTijd = loopTijd;
        this.bedrag = bedrag;
        this.startDatum = startDatum;
    }

    @Override
    public String toString() {
        return "KookCursus{" +
                "id=" + id +
                ", cursusNaam='" + cursusNaam + '\'' +
                ", cursusCode='" + cursusCode + '\'' +
                ", loopTijd='" + loopTijd + '\'' +
                ", bedrag=" + bedrag +
                ", startDatum=" + startDatum +
                ", verlopen=" + verlopen +
                ", verwijderd=" + verwijderd +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCursusNaam() {
        return cursusNaam;
    }

    public void setCursusNaam(String cursusNaam) {
        this.cursusNaam = cursusNaam;
    }

    public String getCursusCode() {
        return cursusCode;
    }

    public void setCursusCode(String cursusCode) {
        this.cursusCode = cursusCode;
    }

    public String getLoopTijd() {
        return loopTijd;
    }

    public void setLoopTijd(String loopTijd) {
        this.loopTijd = loopTijd;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(String startDatum) {
        this.startDatum = startDatum;
    }

    public boolean isVerlopen() {
        return verlopen;
    }

    public void setVerlopen(boolean verlopen) {
        this.verlopen = verlopen;
    }

    public boolean isVerwijderd() {
        return verwijderd;
    }

    public void setVerwijderd(boolean verwijderd) {
        this.verwijderd = verwijderd;
    }
}
