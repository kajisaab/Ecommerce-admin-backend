package com.ecommerce.ecommerce.feature.auth.entity;

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
@Table(name = "userCredential")
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "int default 5")
    private int maxLoginAttempts;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int loginAttempts;

    @Column()
    private String passwordHistory;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean isDeleted;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userDetails;

    @OneToOne(mappedBy = "userCredential", cascade = CascadeType.ALL)
    private OtpSetting otpSetting;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "UserCredential{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", max_login_attempts=" + maxLoginAttempts +
                ", login_attempts=" + loginAttempts +
                ", passwordHistory='" + passwordHistory + '\'' +
                ", is_deleted=" + isDeleted +
                ", userDetails=" + (userDetails != null ? userDetails.getId() : "null") +
                ", otpSetting=" + otpSetting +
                ", created_At=" + createdAt +
                ", updated_At=" + updatedAt +
                '}';
    }
}


