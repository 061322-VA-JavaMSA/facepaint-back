package com.revature.facepaint.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	@Column(name="showcase_art")
	private String imageID;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, Role role, String imageID) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.imageID = imageID;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the imageID
	 */
	public String getImageID() {
		return imageID;
	}
	/**
	 * @param imageID the imageID to set
	 */
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, imageID, password, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(imageID, other.imageID) && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", imageID="
				+ imageID + "]";
	}
	
	

}
