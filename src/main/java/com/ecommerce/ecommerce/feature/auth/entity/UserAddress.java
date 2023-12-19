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
@Table(name = "user_address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = true)
    private String complete_address;

    @Column(nullable = true)
    private String phone_number;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userDetails;

    @Override
    public String toString() {
        return "UserAddress{" +
                "id='" + id + '\'' +
                ", complete_address='" + complete_address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", userDetails=" + (userDetails != null ? userDetails.getId() : "null") +
                '}';
    }

}
