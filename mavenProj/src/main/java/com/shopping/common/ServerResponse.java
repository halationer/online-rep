package com.shopping.common;

public class ServerResponse <T>{
	private int status;
	private String msg;
	private T data;
	
	private  ServerResponse () {
		
	}
	private  ServerResponse (int status) {
		this.status=status;
	}
	private  ServerResponse (int status,String msg) {
		this.msg=msg;
		this.status=status;
	}
	private  ServerResponse (int status,T data) {
		this.data=data;
		this.status=status;
	}
	private  ServerResponse (int status,T data, String msg) {
		this.msg=msg;
		this.data=data;
		this.status=status;
	}
	public static ServerResponse serverResponseBySuccess()
	{
		return new ServerResponse(ResponseCode.SUCESS);
	}
	public static <T>ServerResponse serverResponseBySuccess(T data)
	{
		return new ServerResponse(ResponseCode.SUCESS,data);
	}
	public static <T>ServerResponse serverResponseBySuccess(T data,String msg)
	{
		return new ServerResponse(ResponseCode.SUCESS,data,msg);
	}
	public static ServerResponse serverResponseByError()
	{
		return new ServerResponse(ResponseCode.ERROR);
	}
	public static ServerResponse serverResponseByError(String msg)
	{
		return new ServerResponse(ResponseCode.ERROR,msg);
	}
	public static ServerResponse serverResponseByError(int status)
	{
		return new ServerResponse(status);
	}
	public static ServerResponse serverResponseByError(int status,String msg)
	{
		return new ServerResponse(status,msg);
	}
	public  boolean isSuccess()
	{
		return this.status==ResponseCode.SUCESS;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
