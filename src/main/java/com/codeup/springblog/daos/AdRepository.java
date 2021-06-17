package com.codeup.springblog.daos;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findByTitle(String title); //lists ads where title equals search

    //you can string together all kinds of methods, including filter and delete

    Ad findByTitleLike(String searchPattern); //find by title LIKE "%searchPattern%"
}
