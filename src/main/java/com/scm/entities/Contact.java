package com.scm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {


    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private boolean favorite = false;
    private String websiteLink;
    private String linkedInLink;
    // private List<String> socialLinks=new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "contact", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();


}
