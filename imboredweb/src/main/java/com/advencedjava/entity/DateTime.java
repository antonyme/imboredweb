package com.advencedjava.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateTime {
	@DateTimeFormat(pattern="dd-MMM-YYYY")
	private Date date;
	
	public DateTime() {}
	
	public DateTime(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
