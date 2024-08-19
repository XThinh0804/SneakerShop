package vn.devpro.javaweb29cuoikhoa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import vn.devpro.javaweb29cuoikhoa.model.Role;
import vn.devpro.javaweb29cuoikhoa.model.SaleOrder;
import vn.devpro.javaweb29cuoikhoa.model.SaleOrderProduct;

@Entity
@Table(name = "tbl_user")
public class User extends BaseModel implements UserDetails{
	@Column(name = "username", length = 120, nullable = false)
	private String username;

	@Column(name = "password", length = 120, nullable = false)
	private String password;

	@Column(name = "name", length = 120, nullable = true)
	private String name;

	@Column(name = "email", length = 200, nullable = true)
	private String email;

	@Column(name = "mobile", length = 60, nullable = true)
	private String mobile;

	@Column(name = "address", length = 300, nullable = true)
	private String address;

	@Column(name = "avatar", length = 300, nullable = true)
	private String avatar;

	@Column(name = "description", length = 500, nullable = true)
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "create_by")
	private User userCreateUser;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "update_by")
	private User userUpdateUser;
	// SaleOrder-User
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<SaleOrder> saleOrders = new ArrayList<SaleOrder>();

	public void addRelationalSaleOrder(SaleOrder saleOrder) {
		saleOrders.add(saleOrder);
		saleOrder.setUser(this);
	}

	public void removeRelationalSaleOrder(SaleOrder saleOrder) {
		saleOrders.remove(saleOrder);
		saleOrder.setUser(null);
	}

	// User-Role
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	private List<Role> roles = new ArrayList<Role>();

	public void addRelationalUserRole(Role role) {
		role.getUsers().add(this);
		roles.add(role);
	}

	public void removeRelationalUserRole(Role role) {
		role.getUsers().remove(this);
		roles.remove(role);
	}

	// ---------Mapping one-to-many: userCreate,userUpdate-----------
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateCategory")
	private List<Category> createCategories = new ArrayList<Category>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateCategory")
	private List<Category> updateCategories = new ArrayList<Category>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateProduct")
	private List<Product> createProducts = new ArrayList<Product>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateProduct")
	private List<Product> updateProducts = new ArrayList<Product>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateAttribute")
	private List<Attribute> createAttribute = new ArrayList<Attribute>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateAttribute")
	private List<Attribute> updateAttribute = new ArrayList<Attribute>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateContact")
	private List<Contact> createContact = new ArrayList<Contact>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateContact")
	private List<Contact> updateContact = new ArrayList<Contact>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateProductImage")
	private List<ProductImage> createProductImage = new ArrayList<ProductImage>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateProductImage")
	private List<ProductImage> updateProductImage = new ArrayList<ProductImage>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateRole")
	private List<Role> createRole = new ArrayList<Role>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateRole")
	private List<Role> updateRole = new ArrayList<Role>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateSaleOrder")
	private List<SaleOrder> createSaleOrders = new ArrayList<SaleOrder>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateSaleOrder")
	private List<SaleOrder> updateSaleOrders = new ArrayList<SaleOrder>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateSaleOrderProduct")
	private List<SaleOrderProduct> createSaleOrderProducts = new ArrayList<SaleOrderProduct>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateSaleOrderProduct")
	private List<SaleOrderProduct> updateSaleOrderProducts = new ArrayList<SaleOrderProduct>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateUser")
	private List<User> createUser = new ArrayList<User>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateUser")
	private List<User> updateUser = new ArrayList<User>();

	public User() {
		super();
	}

	public User(Integer id, Date createDate, Date updateDate, Boolean status, String username, String password,
			String name, String email, String mobile, String address, String avatar, String description,
			User userCreateUser, User userUpdateUser, List<SaleOrder> saleOrders, List<Role> roles,
			List<Category> createCategories, List<Category> updateCategories, List<Product> createProducts,
			List<Product> updateProducts, List<Attribute> createAttribute, List<Attribute> updateAttribute,
			List<Contact> createContact, List<Contact> updateContact, List<ProductImage> createProductImage,
			List<ProductImage> updateProductImage, List<Role> createRole, List<Role> updateRole,
			List<SaleOrder> createSaleOrders, List<SaleOrder> updateSaleOrders,
			List<SaleOrderProduct> createSaleOrderProducts, List<SaleOrderProduct> updateSaleOrderProducts,
			List<User> createUser, List<User> updateUser) {
		super(id, createDate, updateDate, status);
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.avatar = avatar;
		this.description = description;
		this.userCreateUser = userCreateUser;
		this.userUpdateUser = userUpdateUser;
		this.saleOrders = saleOrders;
		this.roles = roles;
		this.createCategories = createCategories;
		this.updateCategories = updateCategories;
		this.createProducts = createProducts;
		this.updateProducts = updateProducts;
		this.createAttribute = createAttribute;
		this.updateAttribute = updateAttribute;
		this.createContact = createContact;
		this.updateContact = updateContact;
		this.createProductImage = createProductImage;
		this.updateProductImage = updateProductImage;
		this.createRole = createRole;
		this.updateRole = updateRole;
		this.createSaleOrders = createSaleOrders;
		this.updateSaleOrders = updateSaleOrders;
		this.createSaleOrderProducts = createSaleOrderProducts;
		this.updateSaleOrderProducts = updateSaleOrderProducts;
		this.createUser = createUser;
		this.updateUser = updateUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCreateCategories() {
		return createCategories;
	}

	public void setCreateCategories(List<Category> createCategories) {
		this.createCategories = createCategories;
	}

	public List<Category> getUpdateCategories() {
		return updateCategories;
	}

	public void setUpdateCategories(List<Category> updateCategories) {
		this.updateCategories = updateCategories;
	}

	public List<Product> getCreateProducts() {
		return createProducts;
	}

	public void setCreateProducts(List<Product> createProducts) {
		this.createProducts = createProducts;
	}

	public List<Product> getUpdateProducts() {
		return updateProducts;
	}

	public void setUpdateProducts(List<Product> updateProducts) {
		this.updateProducts = updateProducts;
	}

	public List<SaleOrder> getSaleOrders() {
		return saleOrders;
	}

	public void setSaleOrders(List<SaleOrder> saleOrders) {
		this.saleOrders = saleOrders;
	}

	public List<SaleOrder> getCreateSaleOrders() {
		return createSaleOrders;
	}

	public void setCreateSaleOrders(List<SaleOrder> createSaleOrders) {
		this.createSaleOrders = createSaleOrders;
	}

	public List<SaleOrder> getUpdateSaleOrders() {
		return updateSaleOrders;
	}

	public void setUpdateSaleOrders(List<SaleOrder> updateSaleOrders) {
		this.updateSaleOrders = updateSaleOrders;
	}

	public List<SaleOrderProduct> getCreateSaleOrderProducts() {
		return createSaleOrderProducts;
	}

	public void setCreateSaleOrderProducts(List<SaleOrderProduct> createSaleOrderProducts) {
		this.createSaleOrderProducts = createSaleOrderProducts;
	}

	public List<SaleOrderProduct> getUpdateSaleOrderProducts() {
		return updateSaleOrderProducts;
	}

	public void setUpdateSaleOrderProducts(List<SaleOrderProduct> updateSaleOrderProducts) {
		this.updateSaleOrderProducts = updateSaleOrderProducts;
	}

	public List<Attribute> getCreateAttribute() {
		return createAttribute;
	}

	public void setCreateAttribute(List<Attribute> createAttribute) {
		this.createAttribute = createAttribute;
	}

	public List<Attribute> getUpdateAttribute() {
		return updateAttribute;
	}

	public void setUpdateAttribute(List<Attribute> updateAttribute) {
		this.updateAttribute = updateAttribute;
	}

	public List<Contact> getCreateContact() {
		return createContact;
	}

	public void setCreateContact(List<Contact> createContact) {
		this.createContact = createContact;
	}

	public List<Contact> getUpdateContact() {
		return updateContact;
	}

	public void setUpdateContact(List<Contact> updateContact) {
		this.updateContact = updateContact;
	}

	public List<ProductImage> getCreateProductImage() {
		return createProductImage;
	}

	public void setCreateProductImage(List<ProductImage> createProductImage) {
		this.createProductImage = createProductImage;
	}

	public List<ProductImage> getUpdateProductImage() {
		return updateProductImage;
	}

	public void setUpdateProductImage(List<ProductImage> updateProductImage) {
		this.updateProductImage = updateProductImage;
	}

	public List<Role> getCreateRole() {
		return createRole;
	}

	public void setCreateRole(List<Role> createRole) {
		this.createRole = createRole;
	}

	public List<Role> getUpdateRole() {
		return updateRole;
	}

	public void setUpdateRole(List<Role> updateRole) {
		this.updateRole = updateRole;
	}

	public List<User> getCreateUser() {
		return createUser;
	}

	public void setCreateUser(List<User> createUser) {
		this.createUser = createUser;
	}

	public List<User> getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(List<User> updateUser) {
		this.updateUser = updateUser;
	}

	public User getUserCreateUser() {
		return userCreateUser;
	}

	public void setUserCreateUser(User userCreateUser) {
		this.userCreateUser = userCreateUser;
	}

	public User getUserUpdateUser() {
		return userUpdateUser;
	}

	public void setUserUpdateUser(User userUpdateUser) {
		this.userUpdateUser = userUpdateUser;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
