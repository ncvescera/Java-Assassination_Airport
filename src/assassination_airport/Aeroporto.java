/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assassination_airport;

import java.util.ArrayList;

/**
 *
 * @author Studenti
 */
public class Aeroporto {
    public String           nome;
    private ArrayList<Volo>  voli;
    
    public Aeroporto(String nome){
        this.nome = nome;
        this.voli = new ArrayList();
    }
    
    public void addVolo(Volo nuovo){
        if(nuovo != null)
            this.voli.add(nuovo);
        else
            System.err.println("Errore! Null.pointer.exception!");
    }
    
    public void printVoli(){
        for(Volo volo:this.voli){
            volo.print();
        }
    }
}
