package controller;

import model.Comment;
import model.Post;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Stateless
public class CommentController {

    @PersistenceContext
    private EntityManager entityManager;

    public void create (User user , Post post, String contentComment){
        post = entityManager.merge(post);

        Comment commment = new Comment("");

        commment.setComment(contentComment);
        entityManager.persist(commment);
    }

    public List<Comment> byPost(Post post){
        String jpql = "Select c from Comment c where c.post =: post";
        TypedQuery<Comment> q = entityManager.createQuery(jpql, Comment.class);
        q.setParameter("post", post);
        return q.getResultList();

    }
}
