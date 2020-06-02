/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv5.ass.repository;

import java.util.List;
import jv5.ass.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hotua
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{  

    Long countByLoaisp(Boolean loaisp);
    
    Product findAllByMasp(Integer masp);
    
    Product findByTensp(String tensp);
    
    @Query("FROM Product where tensp like :tensp")
    List<Product> findAllByTensp(@Param("tensp") String tensp);
    
    
    @Query("from Product where loaisp = :loaisp order by tensp asc")
    List<Product> sortProductAscName(@Param("loaisp") Boolean loaisp);
    
    @Query("from Product where loaisp = :loaisp order by tensp desc")
    List<Product> sortProductDescName(@Param("loaisp") Boolean loaisp);
    
    @Query("from Product where loaisp = :loaisp order by gia asc")
    List<Product> sortProductAscGia(@Param("loaisp") Boolean loais);
    
    @Query("from Product where loaisp = :loaisp order by gia desc")
    List<Product> sortProductDescGia(@Param("loaisp") Boolean loaisp);
    
    
    @Query("from Product order by tensp asc")
    List<Product> sortProduct2ascName();
    
    @Query("from Product order by tensp desc")
    List<Product> sortProduct2descName();
    
    @Query("from Product order by gia asc")
    List<Product> sortProduct2ascGia();
    
    @Query("from Product order by gia desc")
    List<Product> sortProduct2descGia();
    
    List<Product> findAllByLoaisp(Boolean loaisp);
    
    void deleteByMasp(Integer masp);
}
