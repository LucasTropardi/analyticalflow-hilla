package com.ltsoftwaresupport.analyticalflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Lucas Tropardi
 * 27 de Mai. de 2024
 */
@Table(name = "review_game")
@Entity(name = "ReviewGame")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReviewGame {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @NotBlank
    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "content", length = 600)
    @NotEmpty
    private String content;

    @Column(name = "rating")
    @Max(5)
    @Min(1)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Platform platform;

    @Column(nullable = false)
    @NotNull
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public @NotEmpty String getContent() {
        return content;
    }

    public void setContent(@NotEmpty String content) {
        this.content = content;
    }

    @Max(5)
    @Min(1)
    public int getRating() {
        return rating;
    }

    public void setRating(@Max(5) @Min(1) int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public @NotNull LocalDateTime getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDateTime date) {
        this.date = date;
    }
}
