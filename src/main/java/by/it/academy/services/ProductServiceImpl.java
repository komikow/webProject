package by.it.academy.services;

import by.it.academy.entity.Product;
import by.it.academy.repositories.ProductRepository;
import by.it.academy.repositories.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public void deleteProduct(String modelToDelete) {
        productRepository = new ProductRepositoryImpl();
        productRepository.deleteProduct(modelToDelete);
    }

    @Override
    public void createProduct(Product product) {
        productRepository = new ProductRepositoryImpl();
        productRepository.createProduct(product);
    }

    @Override
    public List<Product> readProducts() {
        productRepository = new ProductRepositoryImpl();
        return productRepository.readProducts();
    }

    @Override
    public void updateProduct(String modelToUpdate, int newPrice) {
        productRepository = new ProductRepositoryImpl();
        productRepository.updateProduct(modelToUpdate, newPrice);
    }
}
