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
@Table(name = "products")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSP")
    private Integer masp;
    @Column(name = "TenSP")
    private String tensp;
    @Column(name = "LoaiSP", columnDefinition = "BIT")
    private Boolean loaisp;
    @Column(name = "Gia")
    private Integer gia;
    @Column(name = "Anh")
    private String anh;

    public Product(){}
    
    public Product(Integer masp, String tensp, Boolean loaisp, Integer gia, String anh){
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.anh = anh;
    }
    
    public Product(String tensp, Boolean loaisp, Integer gia, String anh){
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.anh = anh;
    }
    
    public Integer getMasp() {
        return masp;
    }

    public void setMasp(Integer masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public Boolean getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(Boolean loaisp) {
        this.loaisp = loaisp;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
