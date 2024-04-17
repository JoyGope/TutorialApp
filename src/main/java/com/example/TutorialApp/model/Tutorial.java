package com.example.TutorialApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tutorials")
public class Tutorial {

    public Tutorial(){

    }

    public Tutorial(String title, String description, Boolean publishedStatus){
      //  super();
        this.title=title;
        this.description=description;
        this.publishedStatus= publishedStatus;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is required.")
    @Column(name = "title", length = 120, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", length = 1000)
    private String description;

    @Column(columnDefinition="bit default 0")
    private Boolean publishedStatus;

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishedStatus=" + publishedStatus +
                '}';
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublishedStatus() {
       return publishedStatus;
  }

   public void setPublishedStatus(Boolean publishedStatus) {
      this.publishedStatus = publishedStatus;
  }


}
