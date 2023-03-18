package by.it.academy.services;

import by.it.academy.entity.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> readProducts();

    void deleteProduct(String modelToDelete);

    void updateProduct(String modelToUpdate, int newPrice);
}
