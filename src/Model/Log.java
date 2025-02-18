package Model;

import java.util.Date;

public class Log {
    private int id;
    private String held;
    private String antagonist;
    private Konftyp konftyp;
    private String ort;
    private String datum;
    private double globeinfluss;

    public Log(int id, String held, String antagonist, Konftyp konftyp, String ort, String datum, double globeinfluss) {
        this.id = id;
        this.held = held;
        this.antagonist = antagonist;
        this.konftyp = konftyp;
        this.ort = ort;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeld() {
        return held;
    }

    public void setHeld(String held) {
        this.held = held;
    }

    public String getAntagonist() {
        return antagonist;
    }

    public void setAntagonist(String antagonist) {
        this.antagonist = antagonist;
    }

    public Konftyp getKonftyp() {
        return konftyp;
    }

    public void setKonftyp(Konftyp konftyp) {
        this.konftyp = konftyp;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getGlobeinfluss() {
        return globeinfluss;
    }

    public void setGlobeinfluss(double globeinfluss) {
        this.globeinfluss = globeinfluss;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", held='" + held + '\'' +
                ", antagonist='" + antagonist + '\'' +
                ", konftyp=" + konftyp +
                ", ort='" + ort + '\'' +
                ", datum=" + datum +
                '}';
    }
}
