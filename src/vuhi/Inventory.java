/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuhi;

/**
 *
 * @author hieud
 */
public class Inventory {
    private String id;
    private String name;
    private int qoh;
    private int rop;
    private double sellPrice;
    
    
    public Inventory(){}
    
    public Inventory(String id, String name, double sellPrice){
        this.id = id;
        this.name = name;
        this.sellPrice = sellPrice;
}
    
    public Inventory(String id, String name, int qoh, int rop, double sellPrice){
        this.id = id;
        this.name = name;
        this.qoh = qoh;
        this.rop = rop;
        this.sellPrice = sellPrice;

    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the qoh
     */
    public int getQoh() {
        return qoh;
    }

    /**
     * @param qoh the qoh to set
     */
    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    /**
     * @return the rop
     */
    public int getRop() {
        return rop;
    }

    /**
     * @param rop the rop to set
     */
    public void setRop(int rop) {
        this.rop = rop;
    }

    /**
     * @return the sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * @param sellPrice the sellPrice to set
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    @Override
    public String toString(){
        return id + " " + name + ", QOH: " + qoh + " Price: $" + sellPrice;
    }
    
   
}
