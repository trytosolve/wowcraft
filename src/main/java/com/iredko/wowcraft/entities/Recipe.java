package com.iredko.wowcraft.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Recipe")
@Table(name = "recipes", schema = "craft", catalog = "")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeReagent> reagents = new ArrayList<RecipeReagent>();

    public Recipe() {
    }

    public Recipe(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeReagent> getReagents() {
        return reagents;
    }

    public void setReagents(List<RecipeReagent> reagents) {
        this.reagents = reagents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        return reagents != null ? reagents.equals(recipe.reagents) : recipe.reagents == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (reagents != null ? reagents.hashCode() : 0);
        return result;
    }
}
