package com.ecommerce.ecommerce.feature.auth.entity;

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
@Table(name = "userAddress")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = true)
    private String completeAddress;

    @Column(nullable = true)
    private String phoneNumber;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userDetails;

    @Override
    public String toString() {
        return "UserAddress{" +
                "id='" + id + '\'' +
                ", complete_address='" + completeAddress + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                ", userDetails=" + (userDetails != null ? userDetails.getId() : "null") +
                '}';
    }

}
