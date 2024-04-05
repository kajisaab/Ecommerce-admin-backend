package com.ecommerce.ecommerce.feature.auth.entity;

import com.ecommerce.ecommerce.feature.auth.enumConstant.RoleEnum;
import com.ecommerce.ecommerce.feature.auth.enumConstant.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name= "userDetails", indexes = {
        @Index(name = "email_index", columnList = "email")
})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean isDeleted;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean isBlocked;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private UserCredential userCredential;

    @Column()
    private String refreshToken;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        if (userCredential != null) {
            return userCredential.getPassword();

        }
        return null; // or throw an exception if userCredential is null

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
