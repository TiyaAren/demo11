package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(schema = "users_schema", name = "t_accounts")
public class Account {
    @Id
    Long id;

    @Column(name = "t_title")
    String title;

    @ManyToOne
    @JoinColumn(name = "c_users_id")
    User user;
}
