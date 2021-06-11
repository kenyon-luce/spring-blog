package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findByTitle(String title); //lists ads where title equals search

    //you can string together all kinds of methods, including filter and delete

    Ad findByTitleLike(String searchPattern); //find by title LIKE "%searchPattern%"
}
