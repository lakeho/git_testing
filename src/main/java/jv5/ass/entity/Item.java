/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.entity;

import java.io.Serializable;

/**
 *
 * @author hotua
 */
public class Item implements Serializable{
    private Product sp;
    private int quantity;
    private int total;
    public Item(){}
    public Item(Product sp, int quantity){
        this.sp = sp;
        this.quantity = quantity;
        total = setTotal(sp, quantity);
    }
    public Product getSp(){
        return this.sp;
    }
    public void setSp(Product sp){
        this.sp = sp;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int sl){
        quantity = sl;
    }
    public int getTotal(){
        return this.total;
    }
    public int setTotal(Product sp, int quantity){
        return total = sp.getGia()*quantity;
    }
}
