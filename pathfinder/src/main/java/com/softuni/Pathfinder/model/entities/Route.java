package com.softuni.Pathfinder.model.entities;

import com.softuni.Pathfinder.model.enums.UserLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gpx_coordinates", nullable = false)
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private UserLevel level;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private User author;

    @OneToMany(targetEntity = Comment.class,mappedBy = "route")
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class,mappedBy = "route")
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    public Route(){
        this.categories = new HashSet<>();
        this.pictures = new HashSet<>();
        this.comments = new HashSet<>();
    }
}
