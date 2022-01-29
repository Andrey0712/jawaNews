package entities;

import lombok.Data;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_category")
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(length = 100,nullable = false)
private String name;
@OneToMany(mappedBy = "category")
    private List<Product> products= new ArrayList<>();


}
