package vn.devpro.javaweb29cuoikhoa.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_sale_order_product")
public class SaleOrderProduct extends BaseModel{
	// -----------Mapping many-to-one: product-to-category(quan he 1 nhieu)------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "sale_order_id")
		private SaleOrder sale_order;
		// -----------Mapping many-to-one: product-to-category(quan he 1 nhieu)------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "product_id")
		private Product product;
		@Column(name = "product_name", length = 300, nullable = true)
		private String product_name;
		@Column(name = "description", length = 500, nullable = true)
		private String description;
		@Column(name = "quantity", nullable = true)
		private int quantity;
		//-----------Mapping many-to-one: sale_order-to-user------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "create_by")
		private User userCreateSaleOrderProduct;
		//-----------Mapping many-to-one: sale_order-to-user------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "update_by")
		private User userUpdateSaleOrderProduct;
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "attribute_id")
		private Attribute attribute;
		public SaleOrderProduct() {
			super();
		}
		public SaleOrderProduct(Integer id, Date createDate, Date updateDate, Boolean status, SaleOrder sale_order,
				Product product, String product_name, String description, int quantity, User userCreateSaleOrderProduct,
				User userUpdateSaleOrderProduct) {
			super(id, createDate, updateDate, status);
			this.sale_order = sale_order;
			this.product = product;
			this.product_name = product_name;
			this.description = description;
			this.quantity = quantity;
			this.userCreateSaleOrderProduct = userCreateSaleOrderProduct;
			this.userUpdateSaleOrderProduct = userUpdateSaleOrderProduct;
		}
		public SaleOrder getSale_order() {
			return sale_order;
		}
		public void setSale_order(SaleOrder sale_order) {
			this.sale_order = sale_order;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public User getUserCreateSaleOrderProduct() {
			return userCreateSaleOrderProduct;
		}
		public void setUserCreateSaleOrderProduct(User userCreateSaleOrderProduct) {
			this.userCreateSaleOrderProduct = userCreateSaleOrderProduct;
		}
		public User getUserUpdateSaleOrderProduct() {
			return userUpdateSaleOrderProduct;
		}
		public void setUserUpdateSaleOrderProduct(User userUpdateSaleOrderProduct) {
			this.userUpdateSaleOrderProduct = userUpdateSaleOrderProduct;
		}
		public Attribute getAttribute() {
			return attribute;
		}
		public void setAttribute(Attribute attribute) {
			this.attribute = attribute;
		}
		
}
