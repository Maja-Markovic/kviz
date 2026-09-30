/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author racunar
 */
public class Korisnik implements Serializable {
    private int id;
    private String korisnickoIme;
    private String lozinka;
    private boolean pokrenutKviz;
    private int rbPitanja;
    private int brojPoena;

    public Korisnik() {
    }

    public Korisnik(int id, String korisnickoIme, String lozinka, boolean pokrenutKviz, int rbPitanja, int brojPoena) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.pokrenutKviz = pokrenutKviz;
        this.rbPitanja = rbPitanja;
        this.brojPoena = brojPoena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean isPokrenutKviz() {
        return pokrenutKviz;
    }

    public void setPokrenutKviz(boolean pokrenutKviz) {
        this.pokrenutKviz = pokrenutKviz;
    }

    public int getRbPitanja() {
        return rbPitanja;
    }

    public void setRbPitanja(int rbPitanja) {
        this.rbPitanja = rbPitanja;
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }
    
    
    
}
