package com.yigiter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "t_customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name can not be null")
    @NotBlank(message = "First name can not be blank")
    @Size(min = 2, max = 50)
    private String name;

    @NotNull(message = "Last name can not be null")
    @NotBlank(message = "Last name can not be blank")
    @Size(min = 2, max = 50)
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private Set<Product> products;
}
