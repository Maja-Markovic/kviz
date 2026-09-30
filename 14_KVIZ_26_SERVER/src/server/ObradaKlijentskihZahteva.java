/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Korisnik;
import model.Pitanje;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author racunar
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch (kz.getOperacija()) {
                case Operacije.LOGIN:
                    Korisnik k = Controller.getInstance().login((Korisnik) kz.getParam());
                    so.setOdgovor(k);
                    break;
                case Operacije.LOGOUT:
                    boolean odjava = Controller.getInstance().logout((Korisnik) kz.getParam());
                    so.setOdgovor(odjava);
                    break;
                case Operacije.VRATI_PITANJA:
                    List<Pitanje> pitanja = Controller.getInstance().vratiPitanja();
                    so.setOdgovor(pitanja);
                    break;
                case Operacije.AZURIRAJ:
                    boolean azuriraj = Controller.getInstance().azuriraj((Korisnik) kz.getParam());
                    so.setOdgovor(azuriraj);
                    break;
                case Operacije.POKRENI_KVIZ:
                    boolean pokrenutKviz = Controller.getInstance().pokreniKviz((Korisnik)kz.getParam());
                    so.setOdgovor(pokrenutKviz);
                    break;

                default:
                    System.out.println("NA OKZ");
            }
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
