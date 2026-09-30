/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author racunar
 */
public class Pitanje implements Serializable {
    private int id;
    private String tekst;
    private int brojSekundi;
    private List<Odgovor> odgovori;

    public Pitanje() {
    }

    public Pitanje(int id, String tekst, int brojSekundi, List<Odgovor> odgovori) {
        this.id = id;
        this.tekst = tekst;
        this.brojSekundi = brojSekundi;
        this.odgovori = odgovori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getBrojSekundi() {
        return brojSekundi;
    }

    public void setBrojSekundi(int brojSekundi) {
        this.brojSekundi = brojSekundi;
    }

    public List<Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(List<Odgovor> odgovori) {
        this.odgovori = odgovori;
    }
    
    
    
}
