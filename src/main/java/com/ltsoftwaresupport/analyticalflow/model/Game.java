package com.ltsoftwaresupport.analyticalflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Table(name = "game", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@Entity(name = "Game")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "publisher_id",
            foreignKey = @ForeignKey(name ="game_publisher_fk"))
    @NotNull
    private Publisher publisher;

    @NotNull
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "website")
    private String website;

    @ElementCollection(targetClass = Platform.class)
    @JoinTable(name = "platform", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "platform", nullable = false)
    private Set<Platform> platform = new HashSet<>();

    @Lob
    @Column(name = "image", nullable = false, columnDefinition = "mediumblob")
    private byte[] image;

    @NotBlank
    @Column(name = "brief", length = 600)
    private String brief;

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

    public @NotNull Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(@NotNull Publisher publisher) {
        this.publisher = publisher;
    }

    public @NotNull LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@NotNull LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Platform> getPlatform() {
        return platform;
    }

    public void setPlatform(Set<Platform> platform) {
        this.platform = platform;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public @NotBlank String getBrief() {
        return brief;
    }

    public void setBrief(@NotBlank String brief) {
        this.brief = brief;
    }
}