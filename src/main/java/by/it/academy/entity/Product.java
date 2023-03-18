package by.it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "\"PRODUCT\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Product.getAll", query = "SELECT c from Product c")
public class Product {
    @Id
    @SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    @Column(name = "\"PRODUCT_ID\"", unique = true, nullable = false)
    private int product_id;

    @Column(name = "\"MODEL\"")
    private String model;

    @Column(name = "\"SPECIFICATIONS\"")
    private String specifications;

    @Column(name = "\"GUARANTEE\"")
    private int guarantee;

    @Column(name = "\"PRICE\"")
    private int price;

    @Column(name = "\"QUANTITY\"")
    private int quantity;

    public Product(String model, String specifications, int guarantee, int price, int quantity) {
        this.model = model;
        this.specifications = specifications;
        this.guarantee = guarantee;
        this.price = price;
        this.quantity = quantity;
    }

}
