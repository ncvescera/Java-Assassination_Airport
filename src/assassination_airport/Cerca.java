/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assassination_airport;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ncvescera
 */
public class Cerca {
    static public void codice(Map<String, Nazione>nazioni, String codice){
        ArrayList<ArrayList> result = new ArrayList();
        
        nazioni.forEach((String a, Nazione n) -> {
            n.aeroporti.forEach((String key, Aeroporto aeroporto) -> {
                result.add(aeroporto.cercaPerCodice(codice));
            });
        });
        
        String stampa = "";
        for(ArrayList elem:result){
            for(int i = 0; i < elem.size(); i++){
                Volo temp = (Volo) elem.get(i++);
                stampa += "Codice volo: "+temp.codice_volo+"\nCompagnia: "+temp.compagnia+"\nData: "+temp.data+"\nDestinazione: "+temp.destinazione+"\n-----------------------------\n";
                //System.out.println("Codice volo: "+temp.codice_volo+" Compagnia: "+temp.compagnia+" Data: "+temp.data+" Destinazione: "+temp.destinazione);
                //System.out.println("-----------------------------");
            }
        }
        
        JOptionPane.showMessageDialog(null, stampa);
        
    }
    
    static public void destinazione(Map<String, Nazione>nazioni, String destinazione){
        ArrayList<ArrayList> result = new ArrayList();
        
        nazioni.forEach((String a, Nazione n) -> {
            n.aeroporti.forEach((String key, Aeroporto aeroporto) -> {
                result.add(aeroporto.cercaPerDestinazione(destinazione));
            });
        });
        
        String stampa = "";
        for(ArrayList elem:result){
            for(int i = 0; i < elem.size(); i++){
                Volo temp = (Volo) elem.get(i++);
                stampa += "Codice volo: "+temp.codice_volo+"\nCompagnia: "+temp.compagnia+"\nData: "+temp.data+"\nDestinazione: "+temp.destinazione+"\n-----------------------------\n";
                //System.out.println("Codice volo: "+temp.codice_volo+" Compagnia: "+temp.compagnia+" Data: "+temp.data+" Destinazione: "+temp.destinazione);
                //System.out.println("-----------------------------");
            }
        }
        
        JOptionPane.showMessageDialog(null, stampa);
    }
}
