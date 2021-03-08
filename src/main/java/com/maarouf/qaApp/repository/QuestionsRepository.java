package com.maarouf.qaApp.repository;

import com.maarouf.qaApp.model.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Questions,Long> {
    @Query(
            value = "SELECT * FROM questions",
            countQuery = "SELECT count(*) FROM questions",
            nativeQuery = true)
    Page<Questions> findAllQuestionsWithPagination(Pageable pageable);


    @Query(
            value = "SELECT * FROM questions WHERE questions.typeid=?1",
            countQuery = "SELECT COUNT(*) FROM questions",
            nativeQuery = true
    )
    Page<Questions> findQuestionsByType(Pageable pageable, Long typeid);

    @Query(
            value = "SELECT * FROM questions WHERE questions.qtext LIKE %?1%",
            countQuery = "SELECT COUNT(*) FROM questions",
            nativeQuery = true
    )
    Page<Questions> searchForQuestions(Pageable pageable,String keyWord);
}
