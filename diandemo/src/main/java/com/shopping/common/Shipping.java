package com.shopping.common;

import java.util.Date;

public class Shipping {

   private Integer id;
   private Integer userId;
   private String receiverName;
   private String receiverPhone;
   private String receiverMobile;
   private String receiverProvince;
   private String receiverCity;
   private String receiverDistrict;
   private String receiverAddress;
   private String receiverZip;
   private Date createTime;
   private Date updateTime;
   
   public Integer getId() {
       return id;
   }
   public void setId(Integer id) {
       this.id = id;
   }
   public Integer getUserId() {
       return userId;
   }

   public void setUserId(Integer userId) {
       this.userId = userId;
   }

   
   public String getReceiverName() {
       return receiverName;
   }

   public void setReceiverName(String receiverName) {
       this.receiverName = receiverName == null ? null : receiverName.trim();
   }

   public String getReceiverPhone() {
       return receiverPhone;
   }

  
   public void setReceiverPhone(String receiverPhone) {
       this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
   }

 
   public String getReceiverMobile() {
       return receiverMobile;
   }

  
   public void setReceiverMobile(String receiverMobile) {
       this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
   }

 
   public String getReceiverProvince() {
       return receiverProvince;
   }

   public void setReceiverProvince(String receiverProvince) {
       this.receiverProvince = receiverProvince == null ? null : receiverProvince.trim();
   }

   public String getReceiverCity() {
       return receiverCity;
   }

 
   public void setReceiverCity(String receiverCity) {
       this.receiverCity = receiverCity == null ? null : receiverCity.trim();
   }

   public String getReceiverDistrict() {
       return receiverDistrict;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column neuedu_shopping.receiver_district
    *
    * @param receiverDistrict the value for neuedu_shopping.receiver_district
    *
    * @mbg.generated
    */
   public void setReceiverDistrict(String receiverDistrict) {
       this.receiverDistrict = receiverDistrict == null ? null : receiverDistrict.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column neuedu_shopping.receiver_address
    *
    * @return the value of neuedu_shopping.receiver_address
    *
    * @mbg.generated
    */
   public String getReceiverAddress() {
       return receiverAddress;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column neuedu_shopping.receiver_address
    *
    * @param receiverAddress the value for neuedu_shopping.receiver_address
    *
    * @mbg.generated
    */
   public void setReceiverAddress(String receiverAddress) {
       this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column neuedu_shopping.receiver_zip
    *
    * @return the value of neuedu_shopping.receiver_zip
    *
    * @mbg.generated
    */
   public String getReceiverZip() {
       return receiverZip;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column neuedu_shopping.receiver_zip
    *
    * @param receiverZip the value for neuedu_shopping.receiver_zip
    *
    * @mbg.generated
    */
   public void setReceiverZip(String receiverZip) {
       this.receiverZip = receiverZip == null ? null : receiverZip.trim();
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column neuedu_shopping.create_time
    *
    * @return the value of neuedu_shopping.create_time
    *
    * @mbg.generated
    */
   public Date getCreateTime() {
       return createTime;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column neuedu_shopping.create_time
    *
    * @param createTime the value for neuedu_shopping.create_time
    *
    * @mbg.generated
    */
   public void setCreateTime(Date createTime) {
       this.createTime = createTime;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method returns the value of the database column neuedu_shopping.update_time
    *
    * @return the value of neuedu_shopping.update_time
    *
    * @mbg.generated
    */
   public Date getUpdateTime() {
       return updateTime;
   }

   /**
    * This method was generated by MyBatis Generator.
    * This method sets the value of the database column neuedu_shopping.update_time
    *
    * @param updateTime the value for neuedu_shopping.update_time
    *
    * @mbg.generated
    */
   public void setUpdateTime(Date updateTime) {
       this.updateTime = updateTime;
   }
	public Shipping(Integer id, Integer userId, String receiverName, String receiverPhone, String receiverMobile,
			String receiverProvince, String receiverCity, String receiverDistrict, String receiverAddress,
			String receiverZip, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverMobile = receiverMobile;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverDistrict = receiverDistrict;
		this.receiverAddress = receiverAddress;
		this.receiverZip = receiverZip;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Shipping [id=" + id + ", userId=" + userId + ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", receiverMobile=" + receiverMobile + ", receiverProvince=" + receiverProvince
				+ ", receiverCity=" + receiverCity + ", receiverDistrict=" + receiverDistrict + ", receiverAddress="
				+ receiverAddress + ", receiverZip=" + receiverZip + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
}