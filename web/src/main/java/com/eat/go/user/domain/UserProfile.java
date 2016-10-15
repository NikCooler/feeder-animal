package com.eat.go.user.domain;

import com.eat.go.common.Identifiable;

import javax.persistence.*;


@Entity
@Table(name = "user_profile")
public class UserProfile extends Identifiable {

    @Column(name = "photo_url")
    private String photoUrl;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
