package ru.kpfu.itis.gunkin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.gunkin.entities.Comment;
import ru.kpfu.itis.gunkin.repositories.CommentRepository;
import ru.kpfu.itis.gunkin.services.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void createComment(Comment comment) {
        commentRepository.saveAndFlush(comment);
    }

    @Override
    public void removeComment(long id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> getNewsComments(long id) {
        return commentRepository.getNewsComments(id);
    }
}
