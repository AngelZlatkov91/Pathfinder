package bg.softuni.workshopPathfinder.model.entity;

import bg.softuni.workshopPathfinder.model.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
     @Column(name = "gpx_coordinates",nullable = false,columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false,name = "level")
    @Enumerated(value = EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false,unique = true)
    private String name;

    @ManyToOne
    private User author;
    @Column(name = "video_url",nullable = false)
    private String videoUrl;

    @OneToMany (targetEntity = Comment.class,mappedBy = "route",cascade = CascadeType.ALL)
    private Set<Comment> comments;

   @OneToMany (mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture> pictures;

   @ManyToMany
   private Set<Category> categories;

    public Route (){
        this.comments = new HashSet<>();
        this.categories = new HashSet<>();
        this.pictures = new HashSet<>();
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }




    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
