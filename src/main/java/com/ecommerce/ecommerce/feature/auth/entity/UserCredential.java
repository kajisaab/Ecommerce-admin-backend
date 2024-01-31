package com.ecommerce.ecommerce.feature.auth.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserCredential extends DBEntity {

    @Column(nullable = false, columnDefinition = "int default 5")
    private int maxLoginAttempts;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int loginAttempts;

    @Column(nullable = false)
    private String password;

    @Column()
    private String passwordHistory;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userDetails;

    @OneToOne(mappedBy = "userCredential", cascade = CascadeType.ALL)
    private OtpSetting otpSetting;


    @Override
    public String toString() {
        return "UserCredential{" +
                "max_login_attempts=" + maxLoginAttempts +
                ", login_attempts=" + loginAttempts +
                ", passwordHistory='" + passwordHistory + '\'' +
                ", password='" + password +
                '}';
    }
}


