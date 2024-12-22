package com.scm.entities;


import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String userId;                                  //auto increment is not valid for string
    @Column(name="user_name",nullable=false)
    private String name;
    @Column(unique = true,nullable=false)
    private String email;
    private String password;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profilePic;
    private String phoneNumber;

    //INFORMATION
    private boolean enabled = false;
    private boolean emailVerified=false;
    private boolean passwordVerified=false;

    //for the providers
    private Providers provider = Providers.SELF;
    private String providerUserId;

    //mapping for contact
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)     //cascade all here satates id user is deleted all its realted will be deleted
                                                               // also fetch will only fetch  when needed
    private List<Contact> contacts = new ArrayList<>();


}
