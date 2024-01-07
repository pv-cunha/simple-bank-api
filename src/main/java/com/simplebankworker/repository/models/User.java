package com.simplebankworker.repository.models;

import com.simplebankworker.repository.enuns.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "sender")
    private Set<Transaction> sentTransactions = new HashSet<>();

    @OneToMany(mappedBy = "receiver")
    private Set<Transaction> receivedTransactions = new HashSet<>();

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime updatedAt;

    public boolean isANewUser() {
        return Objects.isNull(this.getId());
    }

}
