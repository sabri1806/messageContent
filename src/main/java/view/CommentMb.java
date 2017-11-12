package view;

import controller.CommentController;
import model.Comment;
import model.Post;
import model.User;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentMb {

    private CommentController commentController;

    private AuthMb authMb;

    private String content;

    public void create(Post post){
        User user = authMb.getCurrentUser();
        commentController.create(user, post, content);
    }

    public List<Comment> listByPost(Post post){
        return commentController.byPost(post);
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthMb getAuthMb() {
        return authMb;
    }

    public void setAuthMb(AuthMb authMb) {
        this.authMb = authMb;
    }

}
