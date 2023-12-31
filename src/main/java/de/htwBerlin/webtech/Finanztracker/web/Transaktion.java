package de.htwBerlin.webtech.Finanztracker.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaktion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal betrag;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate datum;
    private String beschreibung;

    public enum Kategorie {
        Gehalt,
        Gutschrift,
        Miete,
        Transport,
        Lebensmittel,
        Freizeit,
        Kleidung,
    }
    @Enumerated(value = EnumType.STRING)
    private Kategorie kategorie;
    public enum TransaktionsArt {
        Ausgabe,
        Einnahme,
    }

    @Enumerated(value = EnumType.STRING)
    private TransaktionsArt art;

    public Transaktion() {}

    public Transaktion(Long id, BigDecimal betrag, LocalDate datum, String beschreibung, Kategorie kategorie, TransaktionsArt art) {
        this.id = id;
        this.betrag = betrag;
        this.datum = datum;
        this.beschreibung = beschreibung;
        this.kategorie = kategorie;
        this.art = art;
    }


    public Long getId() {
        return id;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public TransaktionsArt getArt() {
        return art;
    }

    public void setArt(TransaktionsArt art) {
        this.art = art;
    }
}
