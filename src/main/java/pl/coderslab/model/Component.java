package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "components")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Size(min = 2, max = 50)
//    @NotBlank
//    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "component", fetch = FetchType.EAGER)
    private List<QuantityComponent> quantityComponents = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuantityComponent> getQuantityComponents() {
        return quantityComponents;
    }

    public void setQuantityComponents(List<QuantityComponent> quantityComponents) {
        this.quantityComponents = quantityComponents;
    }
}
