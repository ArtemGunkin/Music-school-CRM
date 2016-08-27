package ru.kpfu.itis.gunkin.services;

import ru.kpfu.itis.gunkin.entities.Comment;

import java.util.List;

public interface CommentService {

    void createComment(Comment comment);

    void removeComment(long id);

    List<Comment> getNewsComments(long id);
}
