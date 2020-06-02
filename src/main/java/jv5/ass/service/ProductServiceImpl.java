/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.service;

import java.util.ArrayList;
import java.util.List;
import jv5.ass.entity.Product;
import jv5.ass.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hotua
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepo;
    
    @Override
    public List<Product> listPaging(int a, int b, int t) {
        List<Product> list = new ArrayList<>();
        List<Product> listPaging = new ArrayList<>();
        if(t==0||t==1){
            if(t==0){
                list = productRepo.findAllByLoaisp(Boolean.FALSE);
            }else{
                list = productRepo.findAllByLoaisp(Boolean.TRUE);
            }
        }else{
            list = productRepo.findAll();
        }
        for(int i = (a-1)*b;i<=((a-1)*b+b-1);i++){
            if(i>=list.size()){
                break;
            }
            listPaging.add(list.get(i));
        }
        return listPaging;
    }

    @Override
    public Integer countSp(int t) {
        List<Product> list;
        int soSp = 0;
        if(t==0||t==1){
            if(t==0){
                list = productRepo.findAllByLoaisp(Boolean.FALSE);
            }else{
                list = productRepo.findAllByLoaisp(Boolean.TRUE);
            }
        }else{
            list = productRepo.findAll();
        }
        soSp = list.size();
        return soSp;
    }

    @Override
    public List<Product> sorting1(boolean a, boolean b, boolean type) {//a:by name or price; b:asc or desc; t:type
        if(a==true&&b==true){
            return productRepo.sortProductAscName(type);
        }else if(a==false&&b==true){
            return productRepo.sortProductDescName(type);
        }else if(a==false&&b==false){
            return productRepo.sortProductDescGia(type);
        }else{
            return productRepo.sortProductAscGia(type);
        }
    }

    @Override
    public List<Product> sorting2(boolean a, boolean b) {//nt
        if(a==true&&b==true){
            return productRepo.sortProduct2ascName();
        }else if(a==false&&b==true){
            return productRepo.sortProduct2descName();
        }else if(a==true&&b==false){
            return productRepo.sortProduct2ascGia();
        }else{
            return productRepo.sortProduct2descGia();
        }
    }
    
    @Override
    public Boolean verifySave(Product p) {
    	try {
    		productRepo.save(p);
    		return true;
    	}catch(Throwable t) {
    		t.printStackTrace();
    		return false;
    	}
    }


    
}
