package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public interface AcademicAffairsService {

	/**
	 * 寰楀埌鎵�鏈夊紓甯哥殑浠ｇ爜鎻愮ず锛屾祬鏄炬槗鎳�
	 * @param 
	 * @return String
	 */
	public String getExceptionCode();
	
	
	
	
	/**
	 * 鏍规嵁courseID寰楀埌鍏蜂綋鐨勮绋嬭缁嗕俊鎭紙鍏蜂綋瑙丆ourseInformation绫伙級
	 * 鑻ユ病鏈夎繖闂ㄨ鐨勪俊鎭紝杩斿洖寮傚父鐘舵�佺爜RecordNotFoundException
	 * @param courseID
	 * @return CourseInformation
	 */
	public CourseInformation findCourseInformation(String courseID);

	//academic affairs service for student
	
	
	//浠ヤ笅寮�濮嬩负瀛︾敓鐨勬暀鍔″鎻愪緵鐨勬柟娉�
	/**
	 * 寰楀埌缂撳瓨涓鐢熸墍鏈夐�夌殑璇剧▼鐨勭畝鍗曚俊鎭垪琛紙鍏蜂綋瑙丆ourseChoose绫伙級
	 * 
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> getCacheStudentCourse();
	
	
	
	
	/**
	 * 
	 * 璁块棶鏈嶅姟鍣ㄥ緱鍒版渶鏂扮殑瀛︾敓鎵�鏈夐�夌殑璇剧▼鐨勭畝鍗曚俊鎭垪琛�
	 * 
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> studentGetAllCourses();
	
	
	
	
	/**
	 * 寰楀埌瀛︾敓鎵�鏈夐�夌殑璇剧▼璇︾粏淇℃伅锛屾柟渚垮埗浣滆绋嬭〃
	 * 
	 * @return ArrayList<CourseInformation>
	 */
	public ArrayList<CourseInformation> studentGetTimeTable();
	
	
	
	
	/**
	 * 
	 * 鍒ゆ柇瀛︾敓鏄惁閫夋嫨杩欓棬璇�
	 * 鑻ユ病鏈夎繖闂ㄨ鐨勪俊鎭紝杩斿洖寮傚父鐘舵�佺爜RecordNotFoundException
	 * @param courseID
	 * @return boolean
	 */
	public boolean isStudentChosenCourse(String courseID);
	
	
	
	
	
	/**
	 * 
	 * 鏍规嵁courseID杩斿洖璇ョ敓鏈夊叧杩欓棬璇剧殑绠�鍗曡绋嬩俊鎭�
	 * 鑻ユ病鏈夎繖闂ㄨ鐨勪俊鎭紝杩斿洖寮傚父鐘舵�佺爜RecordNotFoundException
	 * @param courseID
	 * @return CourseChoose
	 */
	public CourseChoose studentGetCourse(String courseID);
	
	
	
	
	
	/**
	 * 杩斿洖杩欓棬璇捐鐢熺殑鎴愮哗
	 * 鑻ユ病鏈夎繖闂ㄨ鐨勪俊鎭紝杩斿洖寮傚父鐘舵�佺爜RecordNotFoundException
	 * @param courseID
	 * @return double
	 */
	public double studentGetCourseGrade(String courseID);
	
	
	
	/**
	 * 杩斿洖璇ュ鐢熸墍鏈夌殑璇剧▼鎴愮哗
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> studentGetAllCourseGrades();
	
	
	
	/**
	 * 杩斿洖璇ョ敓鐨凣PA锛岄拡瀵规墍鏈夋湁鎴愮哗鐨勮绋�
	 * @return double
	 */
	public double studentGetGPA();
	
	
	
	
	
	
	
	
	public ArrayList<CourseInformation> studentGetAllAvailableCourses();
	
	
	
	
	/**
	 * 
	 * 瀛︾敓閫塁ourseID璇�,鎴愬姛閫夋嫨杩斿洖true锛屽け璐ヨ繑鍥瀎alse
	 * 濡傛灉宸茬粡閫夋嫨浜嗭紝杩斿洖RecordAlreadyExistException寮傚父鐘舵�佺爜
	 * 濡傛灉浜烘暟宸茬粡婊′簡锛岃繑鍥濷utOfLimitException寮傚父鐘舵�佺爜
	 * 濡傛灉娌℃湁杩欓棬璇撅紝杩斿洖RecordNotFoundException寮傚父鐘舵�佺爜
	 * @param CourseID
	 * @return boolean
	 */
	public boolean studentAddCourse(String CourseID);
	
	
	
	
	/**
	 * 瀛︾敓閫�璇炬牴鎹瓹ourseID锛屾垚鍔熻繑鍥瀟rue锛屽け璐ヨ繑鍥瀎alse
	 * 濡傛灉宸茬粡閫�閫変簡锛岃繑鍥炲紓甯哥姸鎬佺爜RecordNotFoundException
	 * 濡傛灉杩樻病鏈変汉閫夋嫨杩欓棬璇撅紝杩斿洖鐘舵�佸紓甯哥爜OutOfLimitException
	 * @param CourseID
	 * @return boolean
	 */
	public boolean studentDeleteCourse(String CourseID);
	
	
	
	
	//涓嬮潰寮�濮嬫暀甯堢殑鏁欏姟澶勬彁渚涚殑鏂规硶
	
	//academic affairs service for teacher
	/**
	 * 缁欏嚭鏁欏笀鎵�鏈夌殑鎺堣淇℃伅锛岃繑鍥炵殑姣忎竴涓墍鏁欑殑璇剧▼鐨勬墍鏈夊鐢熺殑淇℃伅锛屼笉寤鸿鐩存帴璋冪敤璇ユ柟娉�
	 * 鐢ㄤ笅闈㈢殑
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> teacherGetAllCourses();
	
	
	
	
	
	/**
	 * 
	 * 鏇存柊瀛︾敓鐨勬垚缁╋紝鎴愬姛杩斿洖true锛屽け璐ヨ繑鍥瀎alse
	 * 鍏蜂綋鍙傛暟瑕佸弬瑙佷竴涓� <CourseChoose>绫�
	 * @param ArrayList<CourseChoose> gradesSheet
	 * @return boolean
	 */
	public boolean updateStudentGrades(ArrayList<CourseChoose> gradesSheet);
	
	
	
	
	/**
	 * 杩斿洖鏁欏笀鎵�鏈夋暀鐨勮绋嬪悕鍒楄〃
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTeacherCourse();
	
	
	
	/**
	 * 
	 * 杩斿洖璇剧▼courseID鐨勬墍鏈夊鐢熶俊鎭紙涓昏鏄垚缁╋級锛屽綋鍋氭煡鐪嬭繖闂╟ourseID鐨勫叏鐝垚缁╁崟
	 * 濡傛灉鏁欏笀娌℃湁鏁欐巿courseID杩欓棬璇撅紝杩斿洖寮傚父鐘舵�佺爜RecordNotFoundException
	 * @param courseID
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> getStudentSheetForCourse(String courseID);
	
	
	
	
	/**
	 * 淇敼娣诲姞瀛︾敓鎴愮哗锛岄拡瀵筩ourseID杩欓棬璇�
	 * 濡傛灉鏁欏笀娌℃湁鏁欐巿courseID杩欓棬璇撅紝杩斿洖寮傚父鐘舵�佺爜RecordNotFoundException
	 * @param courseID
	 * @param gradesSheet
	 * @return boolean
	 */
	public boolean updateStudentGradesForCourse(String courseID,ArrayList<CourseChoose> gradesSheet);
	
	
	
	//academic affairs service for admin
	
	//涓嬮潰寮�濮嬫槸绠＄悊鍛樿皟鐢ㄧ殑鏁欏姟澶勬柟娉�
	
	
	/**
	 * 鏌ョ湅杩欓棬璇綾ourseID鐨勯�夎鎯呭喌
	 * @param courseID
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> adminGetAllCourses(String courseID);
	
	
	
	/**
	 * 娣诲姞璇剧▼锛屾垚鍔熻繑鍥瀟rue锛屽け璐ヨ繑鍥瀎alse
	 * 濡傛灉璇剧▼宸茬粡瀛樺湪锛屽紓甯哥姸鎬佺爜涓篟ecordAlreadyExistException
	 * 鑻ュ寘鍚殑鑰佸笀淇℃伅涓嶅瓨鍦紝寮傚父鐘舵�佺爜涓篟ecordNotFoundException
	 * @param newCourse
	 * @return
	 */
	public boolean addCourseByAdmin(CourseInformation newCourse);
	
	
	
	
	
	
	/**
	 * 淇敼璇剧▼鍩烘湰淇℃伅
	 * 鑻ヨ绋媔d淇℃伅鎴栬�呭寘鍚殑鑰佸笀淇℃伅涓嶅瓨鍦紝寮傚父鐘舵�佺爜涓篟ecordNotFoundException
	 * 
	 * @param updatedCourse
	 * @return
	 */
	public boolean updateCourseByAdmin(CourseInformation updatedCourse);
	
	
	
	
	/**
	 * 淇敼璇剧▼鍩烘湰淇℃伅
	 * 鑻ヨ绋嬩笉瀛樺湪锛屽紓甯哥姸鎬佺爜涓篟ecordNotFoundException
	 * @param courseID
	 * @return
	 */
	public boolean deleteCourseByAdmin(String courseID);
	
	
}
