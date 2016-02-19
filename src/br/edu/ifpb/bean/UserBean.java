package br.edu.ifpb.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.banco.UserDAO;
import br.edu.ifpb.model.User;

@ManagedBean(name = "userBean", eager = true)
@RequestScoped

public class UserBean {
	
	private User user = new User();

	public List<User> getUsers() {
		return new UserDAO().getAll();
	}

	public void registerUser() {
		new UserDAO().insert(user);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("segunda_questao.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
