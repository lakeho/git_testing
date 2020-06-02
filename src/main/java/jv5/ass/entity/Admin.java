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
@Table(name = "admin")
public class Admin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaAD")
    private Integer idad;
    private String username;
    private String pass;
    
    public Admin(){}
    
    public Admin(Integer idad, String username, String pass){
        this.idad = idad;
        this.username  = username;
        this.pass = pass;
    }

    public Integer getIdad() {
        return idad;
    }

    public void setIdad(Integer idad) {
        this.idad = idad;
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
    
    
}
