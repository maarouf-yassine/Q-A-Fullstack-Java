package com.maarouf.qaApp.repository;

import com.maarouf.qaApp.model.Answers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<Answers,Long> {

    @Query(
            value = "SELECT * FROM answers",
            countQuery = "SELECT count(*) FROM answers",
            nativeQuery = true
    )
    Page<Answers> findAllAnswersWithPagination(Pageable pageable);

    @Query(
            value = "SELECT * FROM answers WHERE answers.qid=?1",
            countQuery = "SELECT COUNT(*) FROM answers",
            nativeQuery = true
    )
    Page<Answers> getAnswersOfQuestion(Pageable pageable,Long qid);


}
