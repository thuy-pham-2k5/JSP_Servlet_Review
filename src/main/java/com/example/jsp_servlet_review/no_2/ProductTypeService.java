package com.example.jsp_servlet_review.no_2;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAllProduct ();
    List<ProductType> getAllType ();
    ProductType getProductTypeById (int id_product);
    void addNewProductType (String name, double price, int quantity, int id_type);
    void deleteProductTypeWithId (int id_product);
    void updateInfoProduct (int id_product, String name, double price, int quantity, int id_type);
    List<ProductType> searchProductByName (String keyword);
}
