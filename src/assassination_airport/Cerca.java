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
        //dichiarazione ed inizializzazione dell'arrylist che conterrà i risultati
        ArrayList<ArrayList> result = new ArrayList();
        
        //lambda expression per accedere a tutti gli aeroporti di tutte le nazioni
        nazioni.forEach((String a, Nazione n) -> {
            n.aeroporti.forEach((String key, Aeroporto aeroporto) -> {
                result.add(aeroporto.cercaPerCodice(codice));
            });
        });
        
        //stampa dei risultati tramite JOptionPane
        String stampa = "";
        for(ArrayList elem:result){
            for(int i = 0; i < elem.size(); i++){
                Volo temp = (Volo) elem.get(i++);
                stampa += "Codice volo: "+temp.codice_volo+"\nCompagnia: "+temp.compagnia+"\nData: "+temp.data+"\nDestinazione: "+temp.destinazione+"\n-----------------------------\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, stampa);
        
    }
    
    static public void destinazione(Map<String, Nazione>nazioni, String destinazione){
        //dichiarazione ed inizializzazione dell'arrylist che conterrà i risultati
        ArrayList<ArrayList> result = new ArrayList();
        
        //lambda expression per accedere a tutti gli aeroporti di tutte le nazioni
        nazioni.forEach((String a, Nazione n) -> {
            n.aeroporti.forEach((String key, Aeroporto aeroporto) -> {
                //aggiunge i risultati della ricerca all'array creato in precedenza
                result.add(aeroporto.cercaPerDestinazione(destinazione));
            });
        });
        
        //stampa dei risultati tramite JOptionPane
        String stampa = "";
        for(ArrayList elem:result){
            for(int i = 0; i < elem.size(); i++){
                Volo temp = (Volo) elem.get(i++);
                stampa += "Codice volo: "+temp.codice_volo+"\nCompagnia: "+temp.compagnia+"\nData: "+temp.data+"\nDestinazione: "+temp.destinazione+"\n-----------------------------\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, stampa);
    }
}
