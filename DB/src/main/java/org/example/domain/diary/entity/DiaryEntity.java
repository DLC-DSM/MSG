package org.example.domain.diary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "diary_entity")
public class DiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(columnDefinition = "text", nullable = false, name = "diary_text")
    String content;

    @Column(nullable = false, name = "diary_date")
    Date date;

    @Column(nullable = false, name = "diary_img")
    String img;
}
