/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import forme.ServerskaForma;
import java.util.ArrayList;
import java.util.List;
import model.Korisnik;
import model.Pitanje;

/**
 *
 * @author racunar
 */
public class Controller {
    
    private static Controller instance;
    private DBBroker dbb;
    private int maxBrKlijenata = 0;
    private List<Korisnik> sviKorisnici = new ArrayList<>();
    private List<Korisnik> ulogovaniKorisnici = new ArrayList<>();
    ;
    private ServerskaForma sf;
    
    private Controller() {
        dbb = new DBBroker();
        
        sviKorisnici.add(new Korisnik(1, "pera", "pera", false, -1, 0));
        sviKorisnici.add(new Korisnik(2, "ana", "ana", false, -1, 0));
        sviKorisnici.add(new Korisnik(3, "zika", "zika", false, -1, 0));
        sviKorisnici.add(new Korisnik(4, "jana", "jana", false, -1, 0));
        sviKorisnici.add(new Korisnik(5, "laza", "laza", false, -1, 0));
        
    }
    
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public void setMaxBrKlijenata(int maxBrKlijenata) {
        this.maxBrKlijenata = maxBrKlijenata;
    }
    
    public Korisnik login(Korisnik korisnik) {
        
        for (Korisnik k : sviKorisnici) {
            
            if (sviKorisnici.contains(k)) {
                
                if (ulogovaniKorisnici.contains(k)) {
                    return null;
                }
                
                if (ulogovaniKorisnici.size() == maxBrKlijenata) {
                    return null;
                }
                
                ulogovaniKorisnici.add(k);
                sf.osveziTabelu();
                return k;
                
            }
            
        }
        return null;
    }
    
    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }
    
    public List<Korisnik> getUlogovaniKorisnici() {
        return ulogovaniKorisnici;
    }
    
    public boolean logout(Korisnik korisnik) {
        for (Korisnik k : ulogovaniKorisnici) {
            if (k.getId() == korisnik.getId()) {
                ulogovaniKorisnici.remove(k);
                sf.osveziTabelu();
                return true;
            }
        }
        return false;
    }
    
    public List<Pitanje> vratiPitanja() {
        return dbb.vratiPitanja();
    }
    
    public boolean azuriraj(Korisnik korisnik) {
        for (Korisnik k : ulogovaniKorisnici) {
            if (k.equals(korisnik)) {
                k.setRbPitanja(korisnik.getRbPitanja() + 1);
                k.setBrojPoena(korisnik.getBrojPoena());
                k.setPokrenutKviz(korisnik.isPokrenutKviz());
                
                if (k.getRbPitanja() > 5) {
                    k.setRbPitanja(5);
                }
                
                sf.osveziTabelu();
                return true;
            }
        }
        return false;
    }

    public boolean pokreniKviz(Korisnik korisnik) {
         for (Korisnik k : ulogovaniKorisnici) {
            if (k.equals(korisnik)) {
                k.setRbPitanja(1);
                k.setPokrenutKviz(true);
                sf.osveziTabelu();
                return true;
            }
        }
        return false;
    }
    
}
