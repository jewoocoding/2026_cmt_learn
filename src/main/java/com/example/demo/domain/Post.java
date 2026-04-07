package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//이게 왜 안먹지?
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
    @LastModifiedDate
    private LocalDateTime updatedAt;


    public String getTitle() {

        return title;
    }
    public String getContent() {
        return content;
    }

    public String getAuthor() {

        return author;
    }

    public void viewCount() {
        viewcount++;
}
}





