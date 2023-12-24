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

@Data()
@Builder()
@NoArgsConstructor()
@Entity()
@AllArgsConstructor()
@EntityListeners(AuditingEntityListener.class)
public class OtpSetting extends DBEntity {

    @Column()
    private String expiry_date_time;

    @Column()
    private int otp;

    @OneToOne()
    @JoinColumn(name = "user_credential_id")
    private UserCredential userCredential;

}
