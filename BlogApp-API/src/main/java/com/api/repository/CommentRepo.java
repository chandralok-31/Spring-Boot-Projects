package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
