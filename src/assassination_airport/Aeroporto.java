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
            if(checkVolo(nuovo)){
                this.voli.add(nuovo);
                JOptionPane.showMessageDialog(null, "Volo aggiunto correttamente :D");
            }
            else
                JOptionPane.showMessageDialog(null, "Non posso aggiungere 2 voli identici !");
        }
        else{
            JOptionPane.showMessageDialog(null, "C'è stato un errore, impossibile aggiungere il volo :/");
            System.err.println("Errore! Null.pointer.exception!");
        }
    }
    
    //funzione per controllare che non ci siano 2 voli uguali
    private boolean checkVolo(Volo nuovo){
        boolean add = false;
        if(!this.voli.isEmpty()){
            for(Volo elem:this.voli){
                if(elem.codice_volo.equals(nuovo.codice_volo) || elem.data.equals(nuovo.data) && elem.compagnia.equals(nuovo.compagnia)  && elem.destinazione.equals(nuovo.destinazione)){
                    return false;
                }
                else
                    return true;
                }
            }
        
        //altrimenti 
        return true;
    }
    
    public void printVoli(){
        for(Volo volo:this.voli){
            volo.print();
        }
    }
}
