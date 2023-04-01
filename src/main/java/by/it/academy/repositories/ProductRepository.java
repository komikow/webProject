package by.it.academy.repositories;

import by.it.academy.entity.Product;

import java.util.List;

public interface ProductRepository {
    void createProduct(Product product);

    List<Product> readProducts();

    void deleteProduct(String modelToDelete);

    void updateProduct(String modelToUpdate, int newPrice);
}
