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

@Data()
@Builder()
@NoArgsConstructor()
@Entity()
@AllArgsConstructor()
@EntityListeners(AuditingEntityListener.class)
@Table(name = "otp_setting")
public class OtpSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column()
    private String expiry_date_time;

    @Column()
    private int otp;

    @OneToOne()
    @JoinColumn(name = "user_credential_id")
    private UserCredential userCredential;

    @CreatedDate
    private LocalDateTime created_At;

    @LastModifiedDate
    private LocalDateTime updated_At;

    @Override
    public String toString() {
        return "OtpSetting{" +
                "id='" + id + '\'' +
                ", expiry_date_time='" + expiry_date_time + '\'' +
                ", otp=" + otp +
                ", userCredential=" + (userCredential != null ? userCredential.getId() : "null") +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                '}';
    }
}
