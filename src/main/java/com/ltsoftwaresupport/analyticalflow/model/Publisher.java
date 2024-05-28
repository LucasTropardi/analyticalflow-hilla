package com.ltsoftwaresupport.analyticalflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Table(name = "publisher", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@Entity(name = "Publisher")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String website;
    @NotNull
    private PublisherType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getWebsite() {
        return website;
    }

    public void setWebsite(@NotBlank String website) {
        this.website = website;
    }

    public @NotNull PublisherType getType() {
        return type;
    }

    public void setType(@NotNull PublisherType type) {
        this.type = type;
    }
}
