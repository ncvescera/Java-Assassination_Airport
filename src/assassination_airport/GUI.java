/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assassination_airport;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Nicolò Vescera
 */
public class GUI extends JFrame{
    JPanel      insert;
    
    //Dichiarazione JLables
    JLabel      lab_nazioni;
    JLabel      lab_aeroporto;
    JLabel      lab_compagnia;
    JLabel      lab_destinazione;
    JLabel      lab_data;
    JLabel      lab_codice;
    
    //Dichiarazioni JComboBoxes
    JComboBox   nazioni; // array associativo per nome-nazione oggetto-nazione GUARDARE MAP
    JComboBox   aeroporto;
    JComboBox   compagnia;
    
    JTextField  destinazione;
    JTextField  data;
    JTextField  codice;
    
    JButton     aggiungi;
  
    
    public GUI(){
        insert = new JPanel(new GridLayout(6,2));
        
        lab_nazioni = new JLabel("Nazione: ");
        nazioni = new JComboBox(Database.box_nazioni);
        
        
        lab_aeroporto = new JLabel("Aeroporto: ");
        aeroporto = new JComboBox(Database.areoporto_ICE);
        
        lab_compagnia = new JLabel("Compagnia aerea:");
        compagnia = new JComboBox(Database.compagnie_ICE);
        
        lab_destinazione = new JLabel("Destinazione: ");
        destinazione = new JTextField(20);
        
        lab_data = new JLabel("Data: ");
        data = new JTextField(20);
        
        lab_codice = new JLabel("Codice: ");
        codice = new JTextField(20);
        
        insert.add(lab_nazioni);
        insert.add(nazioni);
        insert.add(lab_aeroporto);
        insert.add(aeroporto);
        insert.add(lab_compagnia);
        insert.add(compagnia);
        insert.add(lab_destinazione);
        insert.add(destinazione);
        insert.add(lab_data);
        insert.add(data);
        insert.add(lab_codice);
        insert.add(codice);
        
        addActionListener();
        
        this.add(insert,"North");
        this.setVisible(true);
        this.setSize(500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addActionListener(){
        /* 
         * ACTION LISTENER NAZIONI
         * In base al contenuto di nazioni modifica il contenuto di aeroporto
        */
        nazioni.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = (String)nazioni.getSelectedItem();
                
                switch(cmd){
                    case "Islanda":
                        aeroporto.setModel(new DefaultComboBoxModel(Database.areoporto_ICE));
                        compagnia.setModel(new DefaultComboBoxModel(Database.compagnie_ICE));
                        break;
                    case "Finalndia":
                        aeroporto.setModel(new DefaultComboBoxModel(Database.areoporto_FIN));
                        compagnia.setModel(new DefaultComboBoxModel(Database.compagnie_FIN));
                        break;
                    case "Italia":
                        aeroporto.setModel(new DefaultComboBoxModel(Database.areoporto_ITA));
                        compagnia.setModel(new DefaultComboBoxModel(Database.compagnie_ITA));
                        break;
                    case "Germania":
                        aeroporto.setModel(new DefaultComboBoxModel(Database.areoporto_GER));
                        compagnia.setModel(new DefaultComboBoxModel(Database.compagnie_GER));
                        break;
                }   
            }
        });
    }
    
}
