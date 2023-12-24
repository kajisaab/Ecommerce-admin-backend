package com.ecommerce.ecommerce.feature.auth.entity;

import com.ecommerce.ecommerce.common.DBEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data()
@Builder()
@NoArgsConstructor()
@Entity()
@AllArgsConstructor()
@EntityListeners(AutoCloseable.class)
public class UserAddress extends DBEntity {

    @Column(nullable = true)
    private String completeAddress;

    @Column(nullable = true)
    private String phoneNumber;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userDetails;

}
