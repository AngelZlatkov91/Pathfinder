package bg.softuni.workshopPathfinder.model.entity;

import bg.softuni.workshopPathfinder.model.enums.NameCategories;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Column(columnDefinition = "TEXT")
  private String description;
    @Column(nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
  private NameCategories name;


    public Category (){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NameCategories getName() {
        return name;
    }

    public void setName(NameCategories name) {
        this.name = name;
    }

}
