package com.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @SequenceGenerator(name = "cartId", sequenceName = "cartId")
    @GeneratedValue(generator = "cartId")
    private long cartId = 0L;
    private LocalDateTime allotDate;
    private LocalDateTime submitDate;
    private Double lateFine = 0.0;
    private String issueName;
    private Long bookId;
}
