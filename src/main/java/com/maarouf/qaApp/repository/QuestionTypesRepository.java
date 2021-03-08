package com.maarouf.qaApp.repository;

import com.maarouf.qaApp.model.QuestionTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypesRepository extends CrudRepository<QuestionTypes,Long> {
}
