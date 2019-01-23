package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 5, max = 100, message = "Nazwa musi być dłuższa niż 5 znaków")
    @NotBlank
    private String title;

    @Column(length = 20, name = "meal_type")
    private String mealType;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<QuantityComponent> quantityComponents = new ArrayList<>();

    @Size(max = 1000)
    @NotBlank(message = "Pole nie może być puste")
    private String description;

    @Column(name = "time_of_day", length = 20)
    private String timeOfDay;

    @Column(length = 21)
    private String country;

    @Column(length = 15)
    private String diet;

    @Column(length = 50)
    private String signature;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //@NotNull
    private User user;

    private Date created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<QuantityComponent> getQuantityComponents() {
        return quantityComponents;
    }

    public void setQuantityComponents(List<QuantityComponent> quantityComponents) {
        this.quantityComponents = quantityComponents;
    }
}
