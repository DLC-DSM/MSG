package org.example.domain.mission.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.global.User.entity.UserEntity;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "mission_entity")
public class MissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, name = "mission_text")
    String text;

    @Column(nullable = false, name = "mission_date")
    Date date;

    @Setter
    @Column(name = "mission_completed")
    @ColumnDefault("false")
    boolean completed;

    @Column(nullable = false, name = "mission_coin")
    long coin;

    @ManyToOne
    UserEntity user;
}
