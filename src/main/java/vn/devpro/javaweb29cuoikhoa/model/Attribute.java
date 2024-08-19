package vn.devpro.javaweb29cuoikhoa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_attribute")
public class Attribute extends BaseModel{
	@Column(name = "size", nullable = false)
	private int size;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	//-----------Mapping many-to-one: product-to-user------------------
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "create_by")
			private User userCreateAttribute;
	//-----------Mapping many-to-one: product-to-user------------------
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "update_by")
			private User userUpdateAttribute;
			//-----------Mapping many-to-one: product-to-attribute(quan he 1 nhieu)------------------
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "product_id")
			private Product product;
			@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "attribute")
			private Set<SaleOrderProduct> listSaleOrderProduct = new HashSet<SaleOrderProduct>();
			public void addRelationalSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
				listSaleOrderProduct.add(saleOrderProduct);
				saleOrderProduct.setAttribute(this);;
			}
			public void removeRelationalSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
				listSaleOrderProduct.remove(saleOrderProduct);
				saleOrderProduct.setAttribute(null);
			}
			public Attribute() {
				super();
			}


			public Attribute(Integer id, Date createDate, Date updateDate, Boolean status, int size, int quantity,
					User userCreateAttribute, User userUpdateAttribute, Product product) {
				super(id, createDate, updateDate, status);
				this.size = size;
				this.quantity = quantity;
				this.userCreateAttribute = userCreateAttribute;
				this.userUpdateAttribute = userUpdateAttribute;
				this.product = product;
			}


			public int getSize() {
				return size;
			}


			public void setSize(int size) {
				this.size = size;
			}


			public int getQuantity() {
				return quantity;
			}


			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}


			public User getUserCreateAttribute() {
				return userCreateAttribute;
			}


			public void setUserCreateAttribute(User userCreateAttribute) {
				this.userCreateAttribute = userCreateAttribute;
			}


			public User getUserUpdateAttribute() {
				return userUpdateAttribute;
			}


			public void setUserUpdateAttribute(User userUpdateAttribute) {
				this.userUpdateAttribute = userUpdateAttribute;
			}


			public Product getProduct() {
				return product;
			}


			public void setProduct(Product product) {
				this.product = product;
			}


			
			
}
