/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hotua
 */
@Entity
@Table (name = "customers")
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKH")
    private Integer makh;
    @Column(name = "TenKH")
    private String tenkh;
    private String username;
    private String pass;
    @Column(columnDefinition = "BIT")
    private Boolean sex;
    private String tel;
    @Column(name = "Address")
    private String addr;
    
    public Customer(){}
    
    public Customer(Integer makh, String tenkh, String username, String pass, Boolean sex, String tel, String add){
        this.makh = makh;
        this.tenkh = tenkh;
        this.username = username;
        this.pass = pass;
        this.sex = sex;
        this.tel = tel;
        this.addr = add;
    }
    
    public Customer(String tenkh, String username, String pass, Boolean sex){
        this.tenkh = tenkh;
        this.username = username;
        this.pass = pass;
        this.sex = sex;
        this.tel = "";
        this.addr = "";
    }

    public Integer getMakh() {
        return makh;
    }

    public void setMakh(Integer makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdd() {
        return addr;
    }

    public void setAdd(String add) {
        this.addr = add;
    }
    
    
}
