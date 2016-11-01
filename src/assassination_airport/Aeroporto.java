package assassination_airport;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolò Vescera
 */
public class Aeroporto {
    public String           nome;
    private ArrayList<Volo>  voli;
    
    public Aeroporto(String nome){
        this.nome = nome;
        this.voli = new ArrayList();
    }
    
    public void addVolo(Volo nuovo){
        if(nuovo != null && !nuovo.codice_volo.equals("") && !nuovo.compagnia.equals("") && !nuovo.data.equals("") && !nuovo.destinazione.equals("")){
            this.voli.add(nuovo);
            JOptionPane.showMessageDialog(null, "Volo aggiunto correttamente :D");
        }
        else{
            JOptionPane.showMessageDialog(null, "C'è stato un errore, impossibile aggiungere il volo :/");
            System.err.println("Errore! Null.pointer.exception!");
        }
    }
    
    public void printVoli(){
        for(Volo volo:this.voli){
            volo.print();
        }
    }
}
