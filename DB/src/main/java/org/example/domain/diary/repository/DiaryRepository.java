package org.example.domain.diary.repository;

import org.example.domain.diary.entity.DiaryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends CrudRepository<DiaryEntity, Long> {
    DiaryEntity findById(long id);
    List<DiaryEntity> findAll();
}
