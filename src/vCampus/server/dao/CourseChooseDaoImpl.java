package vCampus.server.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.sql.SQLException;

import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public class CourseChooseDaoImpl implements CourseChooseDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
    ResultSetMetaData resultSetMetaData;
    int iNumCols;
	
    public ArrayList<CourseChoose> ResultSetToArrayList(ResultSet rs1){
    	ArrayList<CourseChoose> list=new ArrayList<CourseChoose>();
		try {
			CourseChoose c;
			while(rs1.next()) {
				c=new CourseChoose();
				c.setCourseID(rs1.getString("courseID"));
				c.setCourseName(rs1.getString("courseName"));
				c.setStudentName(rs1.getString("studentName"));
				c.setTeacherName(rs1.getString("teacherName"));
				c.setScore(rs1.getDouble("score"));
				list.add(c);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
    
    @Override
	public ArrayList<CourseChoose> courseQueryByStudent(String studentName) throws RecordNotFoundException,SQLException {
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE studentName='"+studentName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToArrayList(rs);
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<CourseChoose> courseQueryByTeacher(String teacherName) throws RecordNotFoundException,SQLException {
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE teacherName='"+teacherName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToArrayList(rs);
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CourseChoose> courseQueryByCourse(String courseID) throws RecordNotFoundException, SQLException {
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToArrayList(rs);
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public boolean addCourseByStudent(String studentName, String courseID) throws RecordNotFoundException,SQLException {
		try {
			String sql="SELECT * FROM tbl_courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int currentAmount=rs.getInt("currentAmount");
				int personLimit=rs.getInt("personLimit");
				if(currentAmount==personLimit)return false;
				currentAmount++;
				String sql1="UPDATE tbl_courseinformation SET currentAmount = "+currentAmount+" WHERE courseID='"+courseID+"'";
				stmt=DBC.con.prepareStatement(sql);
				rs = stmt.executeQuery();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCourseByStudent(String studentName, String courseID)
			throws RecordNotFoundException, SQLException {
		try {
			String sql="SELECT * FROM tbl_courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int currentAmount=rs.getInt("currentAmount");
				int personLimit=rs.getInt("personLimit");
				if(currentAmount==personLimit)return false;
				currentAmount++;
				String sql1="UPDATE tbl_courseinformation SET currentAmount = "+currentAmount+" WHERE courseID='"+courseID+"'";
				stmt=DBC.con.prepareStatement(sql);
				rs = stmt.executeQuery();
			}else throw new RecordNotFoundException();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			throw new RecordNotFoundException();
		}
		return true;
	}

	@Override
	public boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)
			throws RecordNotFoundException, SQLException {
		
		
		
		return false;
	}

	@Override
	public boolean addCourseByAdmin(CourseInformation course) throws RecordNotFoundException, SQLException {
		
		
		
		return false;
	}

	@Override
	public boolean updateCourseByAdmin(CourseInformation course) throws RecordNotFoundException, SQLException {
		
		
		
		return false;
	}
}

