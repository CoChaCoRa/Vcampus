package vCampus.server.biz;

import java.sql.SQLException;

import vCampus.server.exception.RecordExistedException;
import vCampus.vo.Admin;

public interface AdminServiceDao {
	Admin register(String ID,String password) throws RecordExistedException, SQLException;
	Admin login(String ID,String password);
	Admin update(Admin updatedAdmin);

}
