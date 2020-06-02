/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.cart;

import java.util.HashMap;
import jv5.ass.entity.Item;

/**
 *
 * @author hotua
 */
public class Cart extends HashMap<Integer,Item>{
    public void addProduct(Item sp, int inputQuantity){
        int key = sp.getSp().getMasp();
        if(this.containsKey(key)){
            int quantity = ((Item)this.get(key)).getQuantity();
            ((Item)this.get(key)).setQuantity(quantity+inputQuantity);
        }else{
            this.put(key, sp);
        }
    }
    
    public void updateQuantity(int key, int quantity){
        if(this.containsKey(key)){
            this.get(key).setQuantity(quantity);
        }
    }
    
    public boolean removeProduct(int code){
        if(this.containsKey(code)){
            this.remove(code);
            return true;
        }
        return false;
    }
    
    public void removeAll(){
        this.removeAll();
    }
    
//    public int sumMoney(Item sp){
//        
//    }
    
    public Cart(){
        super();
    }
}
