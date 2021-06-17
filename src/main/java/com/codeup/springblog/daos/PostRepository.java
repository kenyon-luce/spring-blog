package com.codeup.springblog.daos;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> { //grabs post contents by id

    Post findByTitle(String title);
    Post findByTitleLike(String searchPattern);
}
