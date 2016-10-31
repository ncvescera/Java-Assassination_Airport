/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assassination_airport;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Studenti
 */
public class Assassination_Airport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, Nazione> nazioni = new HashMap<>();
        for (String nazione : Database.nazioni) {
            //Nazione tmp = new Nazione(nazione);
            nazioni.put(nazione, new Nazione(nazione));
        }
        
        new GUI(nazioni);
        
        System.out.println(nazioni.toString());
    }
    
}
