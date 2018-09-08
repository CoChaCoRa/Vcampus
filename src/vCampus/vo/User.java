package vCampus.vo;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private String sex;
    private String realName;
    private String idCard;//ID card
    private String deptName;//department name
    private String emailAddress;//email
    private String phoneNumber;//phone number
    private String bankAccount;//bank account
    private double account;//balance in bank account
    private double money;//balance in Ecard

    public void setPassword(String password){
    	this.password=password;
    }
    public void setSex(String sex){
    	this.sex=sex;
    }
    public void setRealName(String realName) {
    	this.realName=realName;
    }
    public void setUserName(String userName){
    	this.userName=userName;
    }
    public void setIdCard(String idCard){
    	this.idCard=idCard;
    }
    public void setDeptName(String deptName){
    	this.deptName=deptName;
    }
    public void setEmailAddress(String emailAddress){
    	this.emailAddress=emailAddress;
    }
    public void setPhoneNumber(String phoneNumber){
    	this.phoneNumber=phoneNumber;
    }
    public void setBankAccount(String bankAccount){
    	this.bankAccount=bankAccount;
    }
    public void setAccount(double account){
    	this.account=account;
    }
    public void setMoney(double money){
    	this.money=money;
    }
    
    public String getPassword(){
    	return password;
    }
    public String getSex(){
    	return sex;
    }
    public String getRealName() {
    	return realName;
    }
    public String getUserName(){
    	return userName;
    } 
    public String getIdCard(){
    	return idCard;
    }
    public String getDeptName(){
    	return deptName;
    }
    public String getEmailAddress(){
    	return emailAddress;
    }
    public String getPhoneNumber(){
    	return phoneNumber;
    }
    public String getBankAccount(){
    	return bankAccount;
    }
    public double getAccount(){
    	return account;
    }
    public double getMoney(){
    	return money;
    }
    
}