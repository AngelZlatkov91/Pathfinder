package bg.softuni.workshopPathfinder.model.entity;

import bg.softuni.workshopPathfinder.model.enums.StringRole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
    private StringRole name;

    public Role(){}

    public StringRole getName() {
        return name;
    }

    public void setName(StringRole name) {
        this.name = name;
    }
}
