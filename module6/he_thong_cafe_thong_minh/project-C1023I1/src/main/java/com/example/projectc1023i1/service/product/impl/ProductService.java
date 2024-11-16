package com.example.projectc1023i1.service.product.impl;
import com.example.projectc1023i1.model.product.Category;
import com.example.projectc1023i1.model.product.Product;
import com.example.projectc1023i1.repository.product.IProductRepository;
import com.example.projectc1023i1.service.product.ICategoryService;
import com.example.projectc1023i1.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryService categoryService;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> searchByName(String productName) {
        return productRepository.findProductsByProductNameContaining(productName);
    }

    @Override
    public Page<Product> searchByName(String productName, Pageable pageable) {
        if (productName == null){
            return productRepository.findAll(pageable);
        }
        return productRepository.findProductsByProductNameContaining(productName, pageable);
    }

    @Override
    public Product searchByCode(String productCode) {
        return productRepository.findProductByProductCode(productCode);
    }

    @Override
    public List<Product> searchByCategory(Category category) {
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Page<Product> searchByCategory(Category category, Pageable pageable) {
        if (category == null){
            return productRepository.findAll(pageable);
        }
        return productRepository.findProductsByCategory(category, pageable);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean existProductName(String productName) {
        return productRepository.existsProductByProductName(productName);
    }

    @Override
    public String generateNextProductCode() {
        return "";
    }

    @Override
    public Integer findMaxId() {
        return productRepository.findMaxProductCode();
    }

    @Override
    public Page<Product> findProductByCategory(Integer categoryId, Pageable pageable) {

        Page<Product> products = productRepository.findByCategoryId(categoryId, pageable);
//        return productRepository.findByCategoryId(categoryId,pageable);
        return productRepository.findByCategoryId(categoryId,pageable);
    }
}
