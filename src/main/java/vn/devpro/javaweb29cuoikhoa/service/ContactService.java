package vn.devpro.javaweb29cuoikhoa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb29cuoikhoa.model.Contact;

@Service
public class ContactService  extends BaseService<Contact>{
	@Override
	public Class<Contact> clazz(){
		return Contact.class;
	}
	
	public List<Contact> findAllActive(){
		String sql = "SELECT*FROM tbl_contact WHERE status=1";
		return super.executeNativeSql(sql);
	}
	
	@Transactional
	public void deleteContact(int id) {
		super.deleteById(id);
	}
}
