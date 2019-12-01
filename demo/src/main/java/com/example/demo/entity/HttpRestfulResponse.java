package com.example.demo.entity;


public class HttpRestfulResponse  {
	private Object data;
    private boolean status;
    
    public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

    
}