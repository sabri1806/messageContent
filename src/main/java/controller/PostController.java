package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dto.UserPostDto;
import model.Comment;
import model.DB;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager entityManager;

	public List<UserPostDto> getAllPost() {
		List<UserPostDto> userPostDto = new ArrayList<>();

		String hql = "Select u from User u";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);

		List<User> u = q.getResultList();
		for (User us : u) {
			for (Post ps : us.getPosts()) {
				String result = "";
				for (Comment c :ps.getComments()){
					result += "-" + c.getComment();
				}
				userPostDto.add(new UserPostDto(ps.getId(),us.getUsername(), ps.getDate(), ps.getMessage(), ps.getComments(), ps.getImage()));
			}

		}
		return userPostDto;
	}

	public Post getPostById(int id) {

		String hql = "Select p from Post p where p.id = :id";
		TypedQuery<Post> q = entityManager.createQuery(hql, Post.class);
		q.setParameter("id", id);

		List<Post> p = q.getResultList();

		return p.get(0);
	}

	public void save(Post post) {

		entityManager.merge(post);
		entityManager.flush();
	}

	public List<UserPostDto> getAllMyPost(User user) {
		List<UserPostDto> userPostDto = new ArrayList<>();

		for (Post ps : user.getPosts()) {
			String result = "";
			for (Comment c :ps.getComments()){
				result += "-" + c.getComment();
			}
			userPostDto.add(new UserPostDto(ps.getId(),user.getUsername(), ps.getDate(), ps.getMessage(), ps.getComments(), ps.getImage()));
		}

		
		return userPostDto;
	}


	public void deletePost(int postId) {
		Post p = getPostById(postId);
		entityManager.remove(p);
	}

}
