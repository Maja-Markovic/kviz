/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.util.ArrayList;
import java.util.List;
import model.Pitanje;
import java.sql.*;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odgovor;

/**
 *
 * @author racunar
 */
public class DBBroker {

    public List<Pitanje> vratiPitanja() {
        List<Pitanje> lista = new ArrayList<>();

        try {
            String upit = "SELECT * FROM pitanje";
            Statement st = Konekcija.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {

                Pitanje p = new Pitanje(rs.getInt("id"), rs.getString("tekst"), rs.getInt("brojSekundi"), null);

                List<Odgovor> odgovori = vratiOdgovore(p);

                p.setOdgovori(odgovori);

                lista.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.shuffle(lista);

        for (Pitanje pitanje : lista.subList(0, 5)) {
            System.out.println("\n");
            System.out.println(pitanje);
            System.out.println(pitanje.getOdgovori().get(0));
            System.out.println(pitanje.getOdgovori().get(1));
            System.out.println(pitanje.getOdgovori().get(2));
            System.out.println("\n");
        }

        return new ArrayList(lista.subList(0, 5));
    }

    private List<Odgovor> vratiOdgovore(Pitanje p) {
        List<Odgovor> lista = new ArrayList<>();

        try {
            String upit = "SELECT * FROM odgovor WHERE pitanjeID=" + p.getId();
            Statement st = Konekcija.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {

                Odgovor odg = new Odgovor(p, rs.getInt("rb"), rs.getString("tekst"), rs.getBoolean("tacan"));

                lista.add(odg);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
