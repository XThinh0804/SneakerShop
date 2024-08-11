package vn.devpro.javaweb29cuoikhoa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_contact")
public class Contact extends BaseModel{
	@Column(name = "name", length = 120, nullable = true)
	private String name;

	@Column(name = "email", length = 200, nullable = true)
	private String email;
	@Column(name = "subject", length = 300, nullable = true)
	private String subject;
	@Column(name = "message", length = 1200, nullable = true)
	private String message;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private User userCreateContact;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private User userUpdateContact;
	public Contact() {
		super();
	}
	public Contact(Integer id, Date createDate, Date updateDate, Boolean status, String name, String email,
			String subject, String message, User userCreateContact, User userUpdateContact) {
		super(id, createDate, updateDate, status);
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.userCreateContact = userCreateContact;
		this.userUpdateContact = userUpdateContact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUserCreateContact() {
		return userCreateContact;
	}
	public void setUserCreateContact(User userCreateContact) {
		this.userCreateContact = userCreateContact;
	}
	public User getUserUpdateContact() {
		return userUpdateContact;
	}
	public void setUserUpdateContact(User userUpdateContact) {
		this.userUpdateContact = userUpdateContact;
	}

	
	
}
