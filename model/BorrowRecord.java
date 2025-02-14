package com.example.campusbookshare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrow_record")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer book_id;

    @Column(nullable = false)
    private Integer borrower_id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date borrow_date;

    private Date return_date;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    // Getters and Setters
}