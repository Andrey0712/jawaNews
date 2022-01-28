package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
