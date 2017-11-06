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

	@Inject
	private DB db;

	@Inject
	private UserController userController;

	@PersistenceContext
	private EntityManager entityManager;

	// create(User user,String content)
	// Crea un post en la base de datos
	// Le asigna la fecha actual
	// Le asigna un id automático.

	// all():List<Post>
	// Devuelve todos los post

	// by(User user): List<Post>
	// Devuelve todos los post de un usuario

	public void getPost(String username, String message) {

	}

	public List<UserPostDto> getAllPost() {
		System.out.println("estoy en get all post");
		List<UserPostDto> userPostDto = new ArrayList<>();

		String hql = "Select u from User u";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);
		//q.setParameter("message", userPostDto);// en este caso no seria userPostDto??

		List<User> u = q.getResultList(); // este p deberia estar del lado de userController.getAll..!?

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
		// List<Post> userPost = new ArrayList<>();
		// for(Post p : getAllPost() ) {
		// if(p.getUserId()== user.getId()) {
		// userPost.add(p);
		// }
		//
		// }
		return user.getPosts();
	}

}
