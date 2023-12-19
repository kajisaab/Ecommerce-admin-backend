package com.ecommerce.ecommerce.feature.auth.entity;

import com.ecommerce.ecommerce.feature.auth.enumConstant.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name= "userDetails")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean is_deleted;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean is_blocked;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean is_active;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private UserCredential userCredential;

    @CreatedDate
    private LocalDateTime created_At;

    @LastModifiedDate
    private LocalDateTime updated_At;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}