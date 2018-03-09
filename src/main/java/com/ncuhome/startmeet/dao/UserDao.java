package com.ncuhome.startmeet.dao;

import com.ncuhome.startmeet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;


@Component
@SessionScope
public interface UserDao extends JpaRepository<User, Integer> {
    //随机查询
    //@Query(value = "SELECT * FROM `user` AS t1 JOIN (SELECT ROUND(RAND() * ((SELECT MAX(id) FROM `user`)-(SELECT MIN(id) FROM `user`))+(SELECT MIN(id) FROM `user`)) AS id) AS t2 WHERE t1.star_status = 'ABANDON' LIMIT 5;", nativeQuery = true)
    @Query(value = "SELECT * FROM user WHERE id != ?1 AND id >= (SELECT FLOOR( MAX(id) * RAND()) FROM user) ORDER BY id LIMIT 5",nativeQuery = true)
    List<User> findStarts(Integer id);

    User findUserById(Integer id);

    List<User> findTop10ByStarStatusEqualsOrderByLastChangeTimeAsc(String status);

}
