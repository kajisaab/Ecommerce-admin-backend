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

    @Column()
    private String state;

    @Column()
    private String country;

    @Column()
    private String province;

    @Column()
    private String wardNo;

    @Column()
    private String street;

    @Column()
    private String municipality;

    @Column()
    private String ruralMunicipality;

    @Column()
    private String zipCode;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userDetails;

}
