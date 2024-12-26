package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

        @Id
        private String userId;

        @Column(name = "user_name", nullable = false)
        private String name;

        @Column(unique = true, nullable = false)
        private String email;

        private String password; // Excluding Lombok's getter/setter for password

        @Column(length = 1000)
        private String about;

        @Column(length = 1000)
        private String profilePic;

        private String phoneNumber;

        private boolean enabled = false;

        private boolean emailVerified = false;

        private boolean phoneVerified = false;

        @Enumerated(value = EnumType.STRING)
        private Providers provider = Providers.SELF;

        private String providerUserId;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
        private List<Contact> contacts = new ArrayList<>();

        @ElementCollection(fetch = FetchType.EAGER)
        private List<String> roleList = new ArrayList<>();

        private String emailToken;

        // Getter and Setter for 'userId'
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        // Getter and Setter for 'name'
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Getter and Setter for 'email'
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // Getter and Setter for 'password'
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // Getter and Setter for 'about'
        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        // Getter and Setter for 'profilePic'
        public String getProfilePic() {
            return profilePic;
        }

        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        // Getter and Setter for 'phoneNumber'
        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        // Getter and Setter for 'enabled'
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        // Getter and Setter for 'emailVerified'
        public boolean isEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        // Getter and Setter for 'phoneVerified'
        public boolean isPhoneVerified() {
            return phoneVerified;
        }

        public void setPhoneVerified(boolean phoneVerified) {
            this.phoneVerified = phoneVerified;
        }

        // Getter and Setter for 'provider'
        public Providers getProvider() {
            return provider;
        }

        public void setProvider(Providers provider) {
            this.provider = provider;
        }

        // Getter and Setter for 'providerUserId'
        public String getProviderUserId() {
            return providerUserId;
        }

        public void setProviderUserId(String providerUserId) {
            this.providerUserId = providerUserId;
        }

        // Getter and Setter for 'contacts'
        public List<Contact> getContacts() {
            return contacts;
        }

        public void setContacts(List<Contact> contacts) {
            this.contacts = contacts;
        }

        // Getter and Setter for 'roleList'
        public List<String> getRoleList() {
            return roleList;
        }

        public void setRoleList(List<String> roleList) {
            this.roleList = roleList;
        }

        // Getter and Setter for 'emailToken'
        public String getEmailToken() {
            return emailToken;
        }

        public void setEmailToken(String emailToken) {
            this.emailToken = emailToken;
        }

        // Method to implement 'UserDetails' interface

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<SimpleGrantedAuthority> roles = roleList.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList());
            return roles;
        }

        @Override
        public String getUsername() {
            return this.email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

//        @Override
//        public boolean isEnabled() {
//            return this.enabled;
//        }


}
