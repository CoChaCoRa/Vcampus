package vCampus.vo;

import java.io.Serializable;

import vCampus.vo.User;

public class Teacher extends User implements Serializable {
    private String teacherEcardNumber;
    private String professionalTitle;

    public void setTeacherEcardNumber(String teacherEcardNumber){
    	this.teacherEcardNumber=teacherEcardNumber;
    }
    public void setProfessionalTitle(String professionalTitle){
    	this.professionalTitle=professionalTitle;
    }

    public String getTeacherEcardNumber(){
    	return teacherEcardNumber;
    }
    public String getProfessionalTitle(){
    	return professionalTitle;
    }
    
}