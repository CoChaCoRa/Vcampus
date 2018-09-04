package vCampus.server.biz;

import java.sql.SQLException;

import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public interface StudentServiceDao {
	Student register(String userName, String studentPassword) throws SQLException, RecordAlreadyExistException; 
	Student login(String userName, String studentPassword) throws RecordNotFoundException, WrongPasswordException;
	Student updatePassword(String userName, String newStudentPassword) throws SQLException, RecordNotFoundException;
	Student updateStudentInfo(Student updatedStudent) throws SQLException, RecordNotFoundException;
}
