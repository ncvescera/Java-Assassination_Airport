/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assassination_airport;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Studenti
 */
public class GUI extends JFrame{
    JPanel      insert;
    
    JComboBox   nazioni; // array associativo per nome-nazione oggetto-nazione GUARDARE MAP
    JComboBox   aeroporto;
    JComboBox   compagnia;
    
    JTextField  destinazione;
    
    String[] box_nazioni = {"Islanda","Finalndia","Italia","Germania"};
    
    String[] areoporti_ITA = {"Fiumicino","Malpensa"};
    String[] areoporto_FIN = {"Tervettuola","Liukkumakkyi"};
    String[] areoporto_GER = {"Gherfrung","Rammstain"};
    String[] areoporto_ICE = {"Rekydottir","Siguriondottir"};
    
    
    
}
