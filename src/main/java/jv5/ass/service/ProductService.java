/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.service;

import java.util.List;
import jv5.ass.entity.Product;

/**
 *
 * @author hotua
 */
public interface ProductService {
    List<Product> listPaging(int a, int b, int t);
    //a=trang can duyet, b=so phan tu can duyet, t=loai san pham
    
    List<Product> sorting1(boolean a, boolean b, boolean type);
    //a: sort theo ten;b: asc or desc; t: sort theo loai
    
    List<Product> sorting2(boolean a, boolean b);
    //a: sort theo ten; b: asc or desc;
    
    Integer countSp(int t);
    //t=loai san pham
    
    Boolean verifySave(Product p);
}
