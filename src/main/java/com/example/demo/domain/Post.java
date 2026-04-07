package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //실간
    @Column(name = "post_id")
    private long id;
    private String title;
    private String content;
    private String author;
    private long viewcount;
    @CreatedDate
    private LocalDateTime createdAt;

    public void viewCount() {
        viewcount++;
}
}





