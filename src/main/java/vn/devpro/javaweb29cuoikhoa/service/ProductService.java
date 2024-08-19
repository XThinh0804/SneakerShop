package vn.devpro.javaweb29cuoikhoa.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.javaweb29cuoikhoa.dto.Jw29Contant;
import vn.devpro.javaweb29cuoikhoa.dto.SearchModel;
import vn.devpro.javaweb29cuoikhoa.model.Product;
import vn.devpro.javaweb29cuoikhoa.model.ProductImage;

@Service
public class ProductService extends BaseService<Product>
							implements Jw29Contant{

	@Override
	public Class<Product> clazz() {
		return Product.class;
	}
	public List<Product> findAllActive(){
		String sql = "SELECT*FROM tbl_product WHERE status=1";
		return super.executeNativeSql(sql);
	}
	public List<Product> findAllActiveIsHot(){
		String sql = "SELECT*FROM tbl_product WHERE status=1 AND is_hot=1";
		return super.executeNativeSql(sql);
	}
	
	//Phương thức kiểm tra file có được upload không
	public boolean isUploadedFile(MultipartFile file) {
		if((file != null) && (!file.getOriginalFilename().isEmpty())) {
			return true;
		}
		return false;
	}
	
	//Phương thức kiểm tra danh sách file có được upload không
		public boolean isUploadedFiles(MultipartFile[] files) {
			if(files != null && files.length >0) {
				return true;
			}
			return false;
		}
		
	//Phương thức lưu sản phẩm vào DB
		@Transactional
		public void saveProduct(Product product, MultipartFile avatartFile,MultipartFile[] imageFiles)
		throws IOException{
			//Kiểm tra và lưu avatar
			if(isUploadedFile(avatartFile)) {
				//Có upload avatar thì lưu file vào thư mục Product/Avatar trên server
				String path = FOLDER_UPLOAD + "Product/Avatar/"+avatartFile.getOriginalFilename();
				File file = new File(path);
				avatartFile.transferTo(file);
				//Lưu đường dẫn vào db
				product.setAvatar("Product/Avatar/"+avatartFile.getOriginalFilename());
			}
			//Kiểm tra và lưu danh sách file ảnh
			if(isUploadedFiles(imageFiles)) {
				//có upload ảnh
				for(MultipartFile imageFile : imageFiles) {
					if(isUploadedFile(imageFile)) {
						//Có upload ảnh
						//Lưu file vào thư mục Product/Image trên server
						String path = FOLDER_UPLOAD + "Product/Image/"+imageFile.getOriginalFilename();
						File file = new File(path);
						imageFile.transferTo(file);
						//Lưu đường dẫn vào bảng tbl_image_product trong db
						ProductImage productImage = new ProductImage();
						productImage.setTitle(imageFile.getOriginalFilename());
						productImage.setCreateDate(new Date());
						productImage.setPath("Product/Image/"+imageFile.getOriginalFilename());
						product.addRelationalProductImage(productImage);
					}
				}
			}
			super.saveOrUpdate(product);
		}
		@Transactional
		public void saveEditProduct(Product product, MultipartFile avatartFile,MultipartFile[] imageFiles)
		throws IOException{
			Product dbProduct = super.getById(product.getId());
			//Kiểm tra và lưu avatar
			if(isUploadedFile(avatartFile)) {
				//Xóa avt cũ
				String path = FOLDER_UPLOAD + dbProduct.getAvatar();
				File file = new File(path);
				file.delete();
				//Lưu avt mới
				path = FOLDER_UPLOAD + "Product/Avatar/"+ avatartFile.getOriginalFilename();
				file = new File(path);
				avatartFile.transferTo(file);
				//Lưu đường dẫn vào db
				product.setAvatar("Product/Avatar/"+avatartFile.getOriginalFilename());
			}
			else {
				product.setAvatar(dbProduct.getAvatar());
			}
			//Kiểm tra và lưu danh sách file ảnh
			if(isUploadedFiles(imageFiles)) {
				//có upload ảnh
				for(MultipartFile imageFile : imageFiles) {
					if(isUploadedFile(imageFile)) {
						//Có upload ảnh
						//Lưu file vào thư mục Product/Image trên server
						String path = FOLDER_UPLOAD + "Product/Image/"+imageFile.getOriginalFilename();
						File file = new File(path);
						imageFile.transferTo(file);
						//Lưu đường dẫn vào bảng tbl_image_product trong db
						ProductImage productImage = new ProductImage();
						productImage.setTitle(imageFile.getOriginalFilename());
						productImage.setCreateDate(new Date());
						productImage.setPath("Product/Image/"+imageFile.getOriginalFilename());
						product.addRelationalProductImage(productImage);
					}
				}
			}
			super.saveOrUpdate(product);
		}
		public List<Product> searchProduct(SearchModel productSearch) {
			String sql = "SELECT * FROM tbl_product p WHERE 1=1";
			//Tìm theo status
			if(productSearch.getStatus() != 2) {
				sql += " AND p.status = " + productSearch.getStatus();
			}
			
			//Tìm theo category
			if(productSearch.getCategoryId() !=0) {
				sql += " AND p.category_id = " + productSearch.getCategoryId();
			}
			//Tìm theo keyword
			if(productSearch.getKeyword() != null) {
				sql += " AND (UPPER(p.name) like '%" + productSearch.getKeyword().toUpperCase() + "%'" +
						" OR UPPER(p.short_description) like '%"+productSearch.getKeyword().toUpperCase()+"%'"+
						" OR UPPER(p.seo) like '%"+productSearch.getKeyword().toUpperCase()+"%')";
			}
			return super.executeNativeSql(sql);
		}
		
		public List<Product> searchShopProduct(SearchModel productSearch){
			String sql = "SELECT * FROM tbl_product p WHERE 1=1";
			//Tìm theo price
			if(productSearch.getSearchPrice() == 1) {
				sql += " AND p.price > 0 AND p.price < 100";
			}
			if(productSearch.getSearchPrice() == 2) {
				sql += " AND p.price > 100 AND p.price < 200";
			}
			if(productSearch.getSearchPrice() == 3) {
				sql += " AND p.price > 200 AND p.price < 300";
			}
			if(productSearch.getSearchPrice() == 4) {
				sql += " AND p.price > 300 AND p.price < 400";
			}
			if(productSearch.getSearchPrice() == 5) {
				sql += " AND p.price > 400 AND p.price < 500";
			}
			//Tìm theo keyword
			if(productSearch.getKeyword() != null) {
				sql += " AND (UPPER(p.name) like '%" + productSearch.getKeyword().toUpperCase() + "%')";
			}
			return super.executeNativeSql(sql);
		}
}
