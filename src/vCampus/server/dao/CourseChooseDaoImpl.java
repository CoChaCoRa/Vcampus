package vCampus.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import vCampus.server.exception.*;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public class CourseChooseDaoImpl implements CourseChooseDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
    
    private ArrayList<CourseChoose> ResultSetToCourseChooseArrayList(){
		try {
	    	ArrayList<CourseChoose> list=new ArrayList<CourseChoose>();
			CourseChoose c;
			do {
				c=new CourseChoose();
				c.setCourseID(rs.getString("courseID"));
				c.setCourseName(rs.getString("courseName"));
				c.setStudentName(rs.getString("studentName"));
				c.setTeacherName(rs.getString("teacherName"));
				c.setScore(rs.getDouble("score"));
				list.add(c);
			}while(rs.next());
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
    
    private CourseInformation ResultSetToCourseInformation() {
    	try {
        	CourseInformation course=new CourseInformation();
    		course.setCourseDate(rs.getTimestamp("courseDate"));
    		course.setCourseHour(rs.getInt("courseHour"));
    		course.setCourseID(rs.getString("courseID"));
    		course.setCourseName(rs.getString("courseName"));
    		course.setCoursePlace(rs.getString("coursePlace"));
    		course.setCredit(rs.getDouble("credit"));
    		course.setCurrentAmount(rs.getInt("currentAmount"));
    		course.setDeptName(rs.getString("deptName"));
    		course.setExamPlace(rs.getString("examPlace"));
    		course.setExamTime(rs.getTimestamp("examTime"));
    		course.setPersonLimit(rs.getInt("personLimit"));
    		course.setTeacherEcardNumber(rs.getString("teacherEcardNumber"));
    		course.setTeacherName(rs.getString("teacherName"));
    		course.setWeekIndex(rs.getInt("weekIndex"));
    		return course;
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
				return ResultSetToCourseInformation();
			}
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	return null;
    }
    
    @Override
	public ArrayList<CourseChoose> courseQueryByStudent(String studentName){
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE studentName='"+studentName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<CourseChoose> courseQueryByTeacher(String teacherName){
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE teacherName='"+teacherName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CourseChoose> courseQueryByCourse(String courseID){
		try {
			String sql="SELECT * FROM tbl_coursechoose WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
    public boolean addCourseByStudent(String studentName,String courseID)
    		throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException{
		try {
			String sql1="SELECT * FROM tbl_courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int currentAmount=rs.getInt("currentAmount");
				int personLimit=rs.getInt("personLimit");
				String courseName=rs.getString("courseName");
				String teacherName=rs.getString("teacherName");
				
				String sql2="SELECT * FROM tbl_coursechoose WHERE courseID='"+courseID+"' AND "
						+"studentName='"+studentName+"'";
				stmt=DBC.con.prepareStatement(sql2);
				rs = stmt.executeQuery();
				if(rs.next())throw new RecordAlreadyExistException();
				
				if(currentAmount==personLimit)throw new OutOfLimitException();
				currentAmount++;
				//UPDATE tbl_courseinformation
				String sql="UPDATE tbl_courseinformation SET currentAmount = "+currentAmount+" WHERE courseID='"+courseID+"'";
				stmt=DBC.con.prepareStatement(sql);
				stmt.executeUpdate();

				//UPDATE tbl_coursechoose
				String sqll="INSERT INTO tbl_coursechoose (courseID,courseName,studentName,teacherName,score)"
						+"VALUES (?,?,?,?,?)";
				stmt=DBC.con.prepareStatement(sqll);
				stmt.setString(1,courseID);
				stmt.setString(2,courseName);
				stmt.setString(3,studentName);
				stmt.setString(4, teacherName);
				stmt.setDouble(5, 0.0);
				stmt.executeUpdate();
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
			String sql1="SELECT * FROM tbl_courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int currentAmount=rs.getInt("currentAmount");
				
				String sql2="SELECT * FROM tbl_coursechoose WHERE courseID='"+courseID+"' AND "
						+"studentName='"+studentName+"'";
				stmt=DBC.con.prepareStatement(sql2);
				rs = stmt.executeQuery();
				if(!(rs.next()))throw new RecordNotFoundException();
				
				if(currentAmount==0)throw new OutOfLimitException();
				currentAmount--;
				//UPDATE tbl_courseinformation
				String sql="UPDATE tbl_courseinformation SET currentAmount = "+currentAmount
						+" WHERE courseID='"+courseID+"'";
				stmt=DBC.con.prepareStatement(sql);
				stmt.executeUpdate();
				
				//UPDATE tbl_coursechoose
				String sqll="DELETE FROM tbl_coursechoose WHERE courseID = '"+courseID
						+"' AND studentName='"+studentName+"'";
				stmt=DBC.con.prepareStatement(sqll);
				stmt.executeUpdate();
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
			for(int i=0;i<length;i++) {
				String sql="SELECT * FROM tbl_coursechoose WHERE courseID='"+scoreList.get(i).getCourseID()
						+"' AND studentName='"+scoreList.get(i).getStudentName()+"'";
				stmt=DBC.con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					String sql1="UPDATE tbl_coursechoose SET score = "+scoreList.get(i).getScore()
						+" WHERE courseID = '"+scoreList.get(i).getCourseID()+"' AND studentName='"
						+scoreList.get(i).getStudentName()+"'";
					stmt=DBC.con.prepareStatement(sql1);
					
					stmt.executeUpdate();
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
				+"examTime, examPlace, personLimit, currentAmount,weekIndex) "
				+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, course.getCourseID());
			stmt.setString(2, course.getCourseName());
			stmt.setString(3, course.getDeptName());
			stmt.setString(4, course.getTeacherEcardNumber());
			stmt.setString(5, course.getTeacherName());
			stmt.setInt(6, course.getCourseHour());
			stmt.setDouble(7, course.getCredit());
			stmt.setTimestamp(8, course.getCourseDate());
			stmt.setString(9, course.getCoursePlace());
			stmt.setTimestamp(10, course.getExamTime());
			stmt.setString(11, course.getExamPlace());
			stmt.setInt(12, course.getPersonLimit());
			stmt.setInt(13, course.getCurrentAmount());
			stmt.setInt(14, course.getWeekIndex());
			stmt.executeUpdate();
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
			String sql = "UPDATE tbl_courseinformation SET courseName =?,deptName =?,"
				+"teacherEcardNumber=?,teacherName=?,courseHour=?, credit=?,courseDate=?,"
				+"coursePlace=?,examTime=?,examPlace=?,personLimit=?,currentAmount=?,weekIndex=? "
				+"WHERE courseID = ?";
			/*
			// the format of time
			String strFormat="yyyy-MM-dd HH:mm:ss"; 
			DateFormat df = new SimpleDateFormat(strFormat);
			String str1,str2;
			str1 = df.format(course.getCourseDate());
			str2 = df.format(course.getExamTime());
			*/
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, course.getCourseName());
			stmt.setString(2, course.getDeptName());
			stmt.setString(3, course.getTeacherEcardNumber());
			stmt.setString(4, course.getTeacherName());
			stmt.setInt(5, course.getCourseHour());
			stmt.setDouble(6, course.getCredit());
			stmt.setTimestamp(7, course.getCourseDate());
			stmt.setString(8, course.getCoursePlace());
			stmt.setTimestamp(9, course.getExamTime());
			stmt.setString(10, course.getExamPlace());
			stmt.setInt(11, course.getPersonLimit());
			stmt.setInt(12, course.getCurrentAmount());
			stmt.setInt(13, course.getWeekIndex());
			stmt.setString(14, course.getCourseID());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;	
		}
		return true;
	}

	@Override
	public boolean deleteCourseByAdmin(String courseID) throws RecordNotFoundException {
		try{
			CourseInformation course1=findCourse(courseID);
			if(course1==null)throw new RecordNotFoundException();
			
			String sql="DELETE FROM tbl_coursechoose WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();

			String sql1="DELETE FROM tbl_courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;	
		}
		return true;
	}
}
