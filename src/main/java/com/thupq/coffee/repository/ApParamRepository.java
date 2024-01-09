package com.thupq.coffee.repository;

import com.thupq.coffee.entity.ApParam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApParamRepository extends MongoRepository<ApParam, Long> {
    List<ApParam> findByParGroup(String parGroup);

    List<ApParam> findByParGroupAndParType(String parGroup, String parType);

}
