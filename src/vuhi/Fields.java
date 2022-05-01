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
public enum Fields {
    ITEM_ID("Inventory ID"),
    ITEM_NAME("Item Name"),
    QOH("Qty. On Hand"),
    ROP("Re-Order Point"),
    PRICE("Unit Price");
    
    private String caption;
    
    private Fields(String caption){
        this.caption=caption;
    }

    /**
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }
    
    
}
