package assassination_airport;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Map;
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
    JPanel      top_insert;
    JPanel      insert;
    
    //Dichiarazione JLables
    JLabel      lab_nazioni;
    JLabel      lab_aeroporto;
    JLabel      lab_compagnia;
    JLabel      lab_destinazione;
    JLabel      lab_data;
    JLabel      lab_codice;
    
    //Dichiarazioni JComboBoxes
    JComboBox   nazioni;
    JComboBox   aeroporto;
    JComboBox   compagnia;
    
    //Dichiarazione JTextFields
    JTextField  destinazione;
    JTextField  data;
    JTextField  codice;
    
    //Dichiarazione Buttons
    JButton     aggiungi;
  
    //Array associativo di nazioni che viene passato a questa classe
    Map<String, Nazione> assoc_nazioni;
    
    public GUI(Map assoc_nazioni){
        this.assoc_nazioni = assoc_nazioni;
        
        //inizializzazione pennelli per inserimento dati
        top_insert = new JPanel(new GridLayout(1,2));
        insert = new JPanel(new GridLayout(6,2));
        
        //inizializazione label e combobox NAZIONE
        lab_nazioni = new JLabel("Nazione: ");
        nazioni = new JComboBox(Database.nazioni);
        
        //inizializazione label e combobox AEROPORTO
        lab_aeroporto = new JLabel("Aeroporto: ");
        aeroporto = new JComboBox(Database.areoporto_ICE);
        
        //inizializazione label e combobox COMPAGNIA AEREA
        lab_compagnia = new JLabel("Compagnia aerea:");
        compagnia = new JComboBox(Database.compagnie_ICE);
        
        //inizializazione label e textfield DESTINAZIONE
        lab_destinazione = new JLabel("Destinazione: ");
        destinazione = new JTextField(20);
        
        //inizializazione label e textfield DATA
        lab_data = new JLabel("Data: ");
        data = new JTextField(20);
        
        //inizializazione label e textfield CODICE VOLO
        lab_codice = new JLabel("Codice: ");
        codice = new JTextField(20);
        
        //inizializzazione del bottono AGGIUNGI
        aggiungi = new JButton("Aggiungi !");
        aggiungi.setFont(new Font("Arial", Font.PLAIN, 40));
        
        //aggiunta degli elementi al panel INSERT
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
       
        //aggiunta del panel INSERT al panel TOP_INSERT
        top_insert.add(insert);
        top_insert.add(aggiungi);
        
        //chiamata alla funzione che aggiunge gli ACTIONLISTENERS
        addActionListener();
        
        //aggiunta del panle TOP_INSERT al FRAME
        this.add(top_insert,"North");
        
        //set dei valori principali del frame
        this.setVisible(true);
        this.setSize(500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addActionListener(){
        /*
            ACTION LISTENER NAZIONI
            In base al contenuto di nazioni modifica il contenuto di aeroporto
        */
        nazioni.addActionListener((ActionEvent e) -> {
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
        });
        
        /*
            ACTION LISTENER AGGIUNGI
            Aggoinge il volo al relativo aeroporto della relativa nazione scelta.
        */
        aggiungi.addActionListener((ActionEvent e) -> {
            //Creazione del volo
            System.out.println(codice.getText()+" "+(String)compagnia.getSelectedItem()+" "+destinazione.getText()+" "+data.getText());
            Volo temp = new Volo(codice.getText(),(String)compagnia.getSelectedItem(),destinazione.getText(),data.getText());
            //Aggiunta del volo al relativo oggetto scelto tramite interfaccia grafica
            assoc_nazioni.get(nazioni.getSelectedItem()).aeroporti.get(aeroporto.getSelectedItem()).addVolo(temp);
            //Stampa delle nazioni
            assoc_nazioni.forEach((String s, Nazione a) -> {
                a.print();
            });
        });
    }
    
}
