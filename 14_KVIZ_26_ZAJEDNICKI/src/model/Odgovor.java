/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author racunar
 */
public class Odgovor implements Serializable {
    private Pitanje pitanje;
    private int rb;
    private String tekst;
    private boolean tacan;

    public Odgovor() {
    }

    public Odgovor(Pitanje pitanje, int rb, String tekst, boolean tacan) {
        this.pitanje = pitanje;
        this.rb = rb;
        this.tekst = tekst;
        this.tacan = tacan;
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public boolean isTacan() {
        return tacan;
    }

    public void setTacan(boolean tacan) {
        this.tacan = tacan;
    }

    @Override
    public String toString() {
        return rb + " " + tekst;
    }
    
    
    
    
}
