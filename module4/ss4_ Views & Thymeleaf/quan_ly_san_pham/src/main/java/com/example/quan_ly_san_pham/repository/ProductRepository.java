package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"iPhone 6", 2300000, "Điện thoại","Apple"));
        productList.add(new Product(2,"iPhone 7", 2300000, "Điện thoại","Apple"));
        productList.add(new Product(3,"iPhone 8", 2300000, "Điện thoại","Apple"));
        productList.add(new Product(4,"iPhone 9", 2300000, "Điện thoại","Samsung"));
        productList.add(new Product(5,"iPhone 10", 2300000, "Điện thoại","Xioami"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                break;
            }
        }
    }
    @Override
    public void delete(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : productList) {
            if (product.getNameProduct().equalsIgnoreCase(name)) {
                results.add(product);
            }
        }
        return results;
    }

}
