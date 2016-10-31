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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Studenti
 */
public class GUI extends JFrame{
    JPanel      insert;
    
    JLabel      lab_nazioni;
    JLabel      lab_aeroporto;
    
    JComboBox   nazioni; // array associativo per nome-nazione oggetto-nazione GUARDARE MAP
    JComboBox   aeroporto;
    JComboBox   compagnia;
    
    JTextField  destinazione;
    
    String[] box_nazioni = {"Islanda","Finalndia","Italia","Germania"};
    
    String[] areoporto_ITA = {"Fiumicino","Malpensa"};
    String[] areoporto_FIN = {"Tervettuola","Liukkumakkyi"};
    String[] areoporto_GER = {"Gherfrung","Rammstain"};
    String[] areoporto_ICE = {"Rekydottir","Siguriondottir"};
    
    public GUI(){
        insert = new JPanel(new GridLayout(6,2));
        
        lab_nazioni = new JLabel("Nazione: ");
        nazioni = new JComboBox(box_nazioni);
        
        
        lab_aeroporto = new JLabel("Aeroporto: ");
        aeroporto = new JComboBox(areoporto_ICE);
        
        insert.add(lab_nazioni);
        insert.add(nazioni);
        insert.add(lab_aeroporto);
        insert.add(aeroporto);
        
        addActionListener();
        
        this.add(insert,"North");
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addActionListener(){
        /* 
         * Action listener di nazioni  
         * In base al contenuto di nazioni modifica il contenuto di aeroporto
        */
        nazioni.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = (String)nazioni.getSelectedItem();
                System.out.println(cmd);
                switch(cmd){
                    case "Islanda":
                        aeroporto.setModel(new DefaultComboBoxModel(areoporto_ICE));
                        break;
                    case "Finalndia":
                        aeroporto.setModel(new DefaultComboBoxModel(areoporto_FIN));
                        break;
                    case "Italia":
                        aeroporto.setModel(new DefaultComboBoxModel(areoporto_ITA));
                        break;
                    case "Germania":
                        aeroporto.setModel(new DefaultComboBoxModel(areoporto_GER));
                        break;
                }   
                
                //SwingUtilities.updateComponentTreeUI(GUI.this);
            }
        });
    }
    
}
