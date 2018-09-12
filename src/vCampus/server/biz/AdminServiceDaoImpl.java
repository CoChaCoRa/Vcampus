package vCampus.server.biz;



import java.util.ArrayList;

import vCampus.server.dao.AdminDao;
import vCampus.server.dao.AdminDaoImpl;
import vCampus.server.dao.CourseChooseDao;
import vCampus.server.dao.CourseChooseDaoImpl;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Admin;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;


public class AdminServiceDaoImpl implements AdminServiceDao{

	private AdminDao ad = new AdminDaoImpl();
	private CourseChooseDao ccd = new CourseChooseDaoImpl();
	
	
	@Override
	public Admin register(String ID, String password) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ad.insertAdmin(ID, password)) {
				Admin newAdmin = ad.selectAdmin(ID);
				return newAdmin;
			}
			
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return null;
	}
	
	
	
	
	@Override
	public Admin login(String ID, String password) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Admin admin = ad.selectAdmin(ID);
			if(admin == null) throw new RecordNotFoundException();
			
			if(admin.getPassword().equals(password)) {
				return admin;
			}
			
			else throw new WrongPasswordException();
			
		} 
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (WrongPasswordException e) {
			// TODO: handle exception
			throw new WrongPasswordException();
		}
		
	}
	
	
	
	
	@Override
	public Admin updatePassword(String ID, String password) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ad.updatePassword(ID, password)) {
				return ad.selectAdmin(ID);
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	
	
	
	
	@Override
	public boolean destroy(String ID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ad.deleteAdmin(ID)) return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#courseQueryAdmin(java.lang.String)
	 */
	@Override
	public ArrayList<CourseChoose> courseQueryAdmin(String courseID) {
		// TODO Auto-generated method stub
		ArrayList<CourseChoose> res = ccd.courseQueryByCourse(courseID);
		if(res != null) return res;
		return null;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#addCoursebyAdmin(vCampus.vo.CourseInformation)
	 */
	@Override
	public boolean addCoursebyAdmin(CourseInformation newCourse)
			throws RecordNotFoundException, RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ccd.addCourseByAdmin(newCourse)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#updateCoursebyAdmin(vCampus.vo.CourseInformation)
	 */
	@Override
	public boolean updateCoursebyAdmin(CourseInformation updatedCourse) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ccd.updateCourseByAdmin(updatedCourse)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#deleteCoursebyAdmin(java.lang.String)
	 */
	@Override
	public boolean deleteCoursebyAdmin(String courseID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ccd.deleteCourseByAdmin(courseID)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#queryAccountByUserName(java.lang.String)
	 */
	@Override
	public double queryAccountByUserName(String userName) {
		// TODO Auto-generated method stub
		return ad.queryAccountByUserName(userName);
		
	}
	
}
