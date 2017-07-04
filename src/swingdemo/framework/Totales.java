/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo.framework;

/**
 *
 * @author marcelo
 */
public class Totales {
        
        Double totalItems;
        Double totalIva;
        Double totalGeneral;

    public Totales() {
        totalItems = totalIva = totalGeneral = 0.0;
    }

    public Totales(Double totalItems, Double totalIva, Double totalGeneral) {
        this.totalItems = totalItems;
        this.totalIva = totalIva;
        this.totalGeneral = totalGeneral;
    }
    
    
        
}
