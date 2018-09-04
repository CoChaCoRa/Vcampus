package vCampus.server.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import vCampus.server.exception.*;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public class CourseChooseDaoImpl implements CourseChooseDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
    
    private ArrayList<CourseChoose> ResultSetToCourseChooseArrayList(ResultSet rs1){
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
    
    private CourseInformation ResultSetToCourseInformation(ResultSet rs1) {
    	CourseInformation course=new CourseInformation();
    	try {
    		course.setCourseDate(rs1.getTimestamp("courseDate"));
    		course.setCourseHour(rs1.getInt("courseHour"));
    		course.setCourseID(rs1.getString("courseID"));
    		course.setCourseName(rs1.getString("courseName"));
    		course.setCoursePlace(rs1.getString("coursePlace"));
    		course.setCredit(rs1.getDouble("credit"));
    		course.setCurrentAmount(rs1.getInt("currentAmount"));
    		course.setDeptName(rs1.getString("deptName"));
    		course.setExamPlace(rs1.getString("examPlace"));
    		course.setExamTime(rs1.getTimestamp("examTime"));
    		course.setPersonLimit(rs1.getInt("personLimist"));
    		course.setTeacherEcardNumber(rs1.getString("teacherEcardNumber"));
    		course.setTeacherName(rs1.getString("teacherName"));
    	}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	return null;
    }
    
    @Override
    public CourseInformation findCourse(String courseID){
    	try {
    		String sql= "select * from tbl_courseinformation where courseID ="+ "'"+ courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToCourseInformation(rs);
			}
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	return null;
    }
    
    @Override
	public ArrayList<CourseChoose> courseQueryByStudent(String studentName) throws RecordNotFoundException {
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE studentName='"+studentName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList(rs);
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<CourseChoose> courseQueryByTeacher(String teacherName) throws RecordNotFoundException {
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE teacherName='"+teacherName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList(rs);
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CourseChoose> courseQueryByCourse(String courseID) throws RecordNotFoundException {
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList(rs);
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
    public boolean addCourseByStudent(String studentName,String courseID)throws RecordNotFoundException{
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
			throws RecordNotFoundException ,OutOfLimitException{
		try {
			String sql="SELECT * FROM tbl_courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int currentAmount=rs.getInt("currentAmount");
				int personLimit=rs.getInt("personLimit");
				if(currentAmount==0)throw new OutOfLimitException();
				currentAmount--;
				//UPDATE tbl_courseinformation
				String sql1="UPDATE tbl_courseinformation SET currentAmount = "+currentAmount+" WHERE courseID='"+courseID+"'";
				stmt=DBC.con.prepareStatement(sql1);
				rs = stmt.executeQuery();
				//UPDATE tbl_coursechoose
				String sql2="UPDATE tbl_courseinformation SET currentAmount = "+currentAmount+" WHERE courseID='"+courseID+"'";
				stmt=DBC.con.prepareStatement(sql1);
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
	public boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)
			throws RecordNotFoundException {
		try {
			int length=scoreList.size();
			for(int i=1;i<=length;i++) {
				String sql="SELECT * FROM tbl_courseinformation WHERE courseID='"+scoreList.get(i).getCourseID()+"'";
				stmt=DBC.con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					String sql1="UPDATE tbl_coursechoose SET score = '"+scoreList.get(i).getScore()
						+"' WHERE courseID = '"+scoreList.get(i).getCourseID()+"'";
					stmt=DBC.con.prepareStatement(sql1);
					rs = stmt.executeQuery();
				}else throw new RecordNotFoundException();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addCourseByAdmin(CourseInformation course) throws RecordAlreadyExistException {
		try{
			CourseInformation course1=findCourse(course.getCourseID());
			if(course1!=null)throw new RecordAlreadyExistException();
			String sql = "INSERT INTO tbl_courseinformation (courseID, courseName, deptName, "
				+"teacherEcardNumber, teacherName, courseHour, credit, courseDate, coursePlace, "
				+"examTime, examPlace, personLimit, currentAmount) VALUES ( '"
				+course.getCourseID()+"' , '"+course.getCourseName()+"' , '"+course.getDeptName()+"' , '"
				+course.getTeacherEcardNumber()+"' , '"+course.getTeacherName()+"' , '"+course.getCourseHour()+"' , '"
				+course.getCredit()+"' , '"+course.getCourseDate()+"' , '"+course.getCoursePlace()+"' , '"
				+course.getExamTime()+"' , '"+course.getExamPlace()+"' , '"+course.getPersonLimit()+"' , '"
				+course.getCurrentAmount()+"' )";
			stmt=DBC.con.prepareStatement(sql);
			int rs = stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateCourseByAdmin(CourseInformation course) throws RecordNotFoundException {
		try{
			CourseInformation course1=findCourse(course.getCourseID());
			if(course1==null)throw new RecordNotFoundException();
			String sql = "UPDATE tbl_courseinformation SET courseName = ?,  deptName = ?, "
				+"teacherEcardNumber = ?, teacherName = ?, courseHour = ?, credit = ?, courseDate = ?, "
				+"coursePlace = ?, examTime = ?, examPlace = ?, personLimit = ?, currentAmount = ? "
				+"WHERE courseID = ?";
			// the format of time
			String strFormat="yyyy-MM-dd HH:mm:ss"; 
			DateFormat df = new SimpleDateFormat(strFormat);
			String str1,str2;
			str1 = df.format(course.getCourseDate());
			str2 = df.format(course.getExamTime());
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, course.getCourseName());
			stmt.setString(2, course.getDeptName());
			stmt.setString(3, course.getTeacherEcardNumber());
			stmt.setString(4, course.getTeacherName());
			stmt.setString(5, Integer.toString(course.getCourseHour()));
			stmt.setString(6, Double.toString(course.getCredit()));
			stmt.setString(7, str1);
			stmt.setString(8, course.getCoursePlace());
			stmt.setString(9, str2);
			stmt.setString(10, course.getExamPlace());
			stmt.setString(11, Integer.toString(course.getPersonLimit()));
			stmt.setString(12, Integer.toString(course.getCurrentAmount()));
			stmt.setString(13, course.getCourseID());
			int rs = stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}
}
