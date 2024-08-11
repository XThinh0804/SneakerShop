package vn.devpro.javaweb29cuoikhoa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb29cuoikhoa.model.Role;
import vn.devpro.javaweb29cuoikhoa.model.User;

@Service
public class RoleService extends BaseService<Role> {
	@Override
	public Class<Role> clazz() {
		return Role.class;
	}
	
	public List<Role> findAllActive(){
		String sql = "SELECT*FROM tbl_role WHERE status=1";
		return super.executeNativeSql(sql);
	}
	
	@Transactional
	public void deleteRole(int id) {
		super.deleteById(id);
	}
}
