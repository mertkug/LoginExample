package com.rateandreview.models;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="post_id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private ApplicationUser owner;
    private String text;
    private Integer likes;

    public Post(String text) {
        this.text = text;
    }

    public Post(ApplicationUser owner, String text, Integer likes) {
        this.owner = owner;
        this.text = text;
        this.likes = likes;
    }

    public Post() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public void setOwner(ApplicationUser owner) {
        this.owner = owner;
    }
}
