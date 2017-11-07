package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dto.UserPostDto;
import model.DB;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager entityManager;

	public List<UserPostDto> getAllPost() {
		System.out.println("estoy en get all post");
		List<UserPostDto> userPostDto = new ArrayList<>();

		String hql = "Select u from User u";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);

		List<User> u = q.getResultList(); 
		for (User us : u) {
			for (Post ps : us.getPosts()) {
				userPostDto.add(new UserPostDto(us.getUsername(), ps.getDate(), ps.getMessage()));
			}

		}
		return userPostDto;
	}

	public void createPost(User user) {
		System.out.println("creando1");
	}

	public List<Post> getUserPost(User user) {
		
		return user.getPosts();
	}

}
