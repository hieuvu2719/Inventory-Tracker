/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuhi;

import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class InventoryList {
    private ArrayList<Inventory> invList = new ArrayList<>();
    
    public InventoryList(){}
    
    /**
     *
     * @param inventory
     */
    public void add(Inventory inventory){
        invList.add(inventory);
    }
    
    /**
     *
     * @param index
     * @return inventory inside invList
     */
    public Inventory get(int index){
        if(index>=invList.size()){
            return null;
        }
        else{
            return invList.get(index);
        }
    }
    
    /**
     *
     * @return length of invList
     */
    public int length(){
        return invList.size();
    }
    
    
}
