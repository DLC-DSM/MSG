package org.example.domain.mission.repository;

import org.example.domain.mission.entity.MissionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MissionRepository extends CrudRepository<MissionEntity, Long> {

    List<MissionEntity> findAllByDateAfter(Date day);

    MissionEntity findAllById(long id);

    //@Query(value = "select MissionEntity from MissionEntity where completed == true")
    List<MissionEntity> findAllByCompleted(boolean isCompleted);

    //@Query(value = "delete from MissionEntity where date < ?1 and completed == false")
    //void deleteByDateAfterAndCompleted(Date date);
}
