package com.unasat.entity;

import java.time.LocalDate;

public class KookCursusDeelnemer {

    private Long id;
    private Long kookCursusId;
    private Long deelnemerId;
    private boolean resultaat;
    private LocalDate inschrijfDatum;
    private double restBedrag;

    public KookCursusDeelnemer() {
    }

    public KookCursusDeelnemer(Long id, Long kookCursusId, Long deelnemerId, boolean resultaat, LocalDate inschrijfDatum, double restBedrag) {
        this.id = id;
        this.kookCursusId = kookCursusId;
        this.deelnemerId = deelnemerId;
        this.resultaat = resultaat;
        this.inschrijfDatum = inschrijfDatum;
        this.restBedrag = restBedrag;
    }

    @Override
    public String toString() {
        return "KookCursusDeelnemer{" +
                "id=" + id +
                ", kookCursusId=" + kookCursusId +
                ", deelnemerId=" + deelnemerId +
                ", resultaat=" + resultaat +
                ", inschrijfDatum=" + inschrijfDatum +
                ", restBedrag=" + restBedrag +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKookCursusId() {
        return kookCursusId;
    }

    public void setKookCursusId(Long kookCursusId) {
        this.kookCursusId = kookCursusId;
    }

    public Long getDeelnemerId() {
        return deelnemerId;
    }

    public void setDeelnemerId(Long deelnemerId) {
        this.deelnemerId = deelnemerId;
    }

    public boolean isResultaat() {
        return resultaat;
    }

    public void setResultaat(boolean resultaat) {
        this.resultaat = resultaat;
    }

    public LocalDate getInschrijfDatum() {
        return inschrijfDatum;
    }

    public void setInschrijfDatum(LocalDate inschrijfDatum) {
        this.inschrijfDatum = inschrijfDatum;
    }

    public double getRestBedrag() {
        return restBedrag;
    }

    public void setRestBedrag(double restBedrag) {
        this.restBedrag = restBedrag;
    }
}
