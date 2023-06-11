package com.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @SequenceGenerator(name = "cartId",sequenceName = "cartId")
    @GeneratedValue(generator = "cartId")
    private long cartId = 0L;
    private LocalDateTime allotDate;
    private LocalDateTime submitDate;
    private Double lateFine = 0.0;
    private String issueName ;
    private Long bookId ;
}
