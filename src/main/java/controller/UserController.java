package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Servlet implementation class UserController
 */
import model.bo.Offre;
import model.bo.TypeOffre;
import model.bo.User;
import model.dao.DAOOffre;
import model.dao.DAOTypeOffre;
import model.dao.DAOUser;

//@WebServlet("/"))
@MultipartConfig(maxFileSize = 1024*1024*1024)
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {

	}

	public static String getAction(HttpServletRequest request) {
		String act[] = request.getRequestURL().toString().split("/");
		return act[act.length - 1];
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post : "+request.getPathInfo());
		switch (request.getPathInfo()) {
		case "/inserer":
			System.out.println("insertion");
			register(request, response);
			break;

		case "/login":
			try {
				authenticate(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/updateOffre":
			updateOffre(request, response);
			listOffres(request, response);
			break;
		case "/inscription":
			inscription(request, response);
			break;
		default:
			break;
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get : "+request.getPathInfo());
		switch (request.getPathInfo()) {
		case "/inserer":
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			break;
		case "/offres":
			listOffres(request, response);

			break;
		case "/login":
			response.sendRedirect("/login.jsp");
			break;

		case "/modifier":
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("offre", new DAOOffre().getOffreByID(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/modifier.jsp");
			dispatcher.forward(request, response);
			break;

		case "/supprimer":
			System.out.println("Dans /supprimer");

			deleteOffre(request, response);
			listOffres(request, response);
			break;

		default:
			break;
		}

	}
	

	private void inscription(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(nom, prenom, email, password, "u");
		System.out.println(user);
		new DAOUser().saveUser(user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

	}


	private void deleteOffre(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Dans deleteOffre()");
		int id = Integer.parseInt(request.getParameter("id"));
		Offre o = new Offre();
		o.setId(id);

		new DAOOffre().supprimerOffre(o);
	}

	public int typedeoffre(String s) {
		switch (s) {
		case "cdi":
			return 3;
		case "cdd":
			return 2;
		case "stage":
			return 1;
		default:
			return 0;
		}
	}

	private void updateOffre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String type = request.getParameter("inputType");
		int idtype = typedeoffre(type);
		int id = Integer.parseInt(request.getParameter("id"));

		Offre o = new Offre();
		o.setId(id);
		o.setTitre(titre);
		o.setDescription(description);
		TypeOffre to = new DAOTypeOffre().getTypeId(type);
		o.setType(to);

		new DAOOffre().updateOffre(o);

	}

	private void listOffres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Offre> lo = new DAOOffre().getListOffres();
		request.setAttribute("lo", lo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/offres.jsp");
		dispatcher.forward(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// pour garder les informations comme titre, description, type d'offre
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String type = request.getParameter("inputType");
		// acceder a la session pour utiliser les donnees d'utilisateur courant
		HttpSession session = request.getSession();
		// garder l'utilisateur cournat dans (u)
		User u = (User) session.getAttribute("user");
		// creatin de l'offre
		Offre o = new Offre(titre, description);
		// utilisation des objets persités
		TypeOffre to = new DAOTypeOffre().getTypeId(type);
		u = new DAOUser().getUserById(u.getId());

		o.setCreateur(u);
		o.setType(to);
		// insertion
		new DAOOffre().insererOffre(o);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/register-success.jsp");
		dispatcher.forward(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DAOUser loginDao = new DAOUser();
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		User user = loginDao.validate(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		if (user != null) {
			System.out.println("User valide ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("User non valide ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
