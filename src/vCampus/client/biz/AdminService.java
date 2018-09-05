package vCampus.client.biz;

import vCampus.vo.Admin;

/**
 * @author Administrator
 *
 */
public interface AdminService {

	public Admin getCacheAdmin();
	public String getExceptionCode();
	public boolean register(String userName,String password,String confirmedPassword);
	public boolean login(String userName,String password);
	public boolean updateInfo(Admin updatedAdmin);
	
}
