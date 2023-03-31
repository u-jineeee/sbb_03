package com.ll.sbb_03.answer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query("select "
            + "distinct a "
            + "from Answer a "
            + "left outer join SiteUser u1 on a.author=u1 "
            + "where "
            + "   a.content like %:kw% "
            + "   or u1.username like %:kw% ")
    Page<Answer> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
