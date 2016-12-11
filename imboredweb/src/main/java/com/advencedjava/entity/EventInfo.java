package com.advencedjava.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.advencedjava.api.dto.Datum;

public class EventInfo {
	int eventUid;
	
	//main info
	String link;

	String image;
	String title;
	String description;
	
	//location
	String placeName;
	String address;
	double lat;
	double lng;
	
	//time
	Date startDate;

	public EventInfo() {}

	public int getEventUid() {
		return eventUid;
	}

	public void setEventUid(int eventUid) {
		this.eventUid = eventUid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Validate and fill data
	 * @param jsonData object created automatically from JSON
	 * @return false if jsonData isn't valid.
	 */
	public Boolean fill(Datum jsonData) {
		try {
			//needed
			this.eventUid = Integer.parseInt(jsonData.getUid());
			
			//needed
			this.link = jsonData.getLink();
			if(link.isEmpty()) return false;
			
			//can be null
			if(jsonData.getImage() != null) {
				this.image = "http:" + (String) jsonData.getImage();
			}
			
			//needed
			this.title = jsonData.getTitle().getFr();
			if(title.isEmpty()) return false;
			
			this.description = jsonData.getDescription().getFr();
			
			this.placeName = jsonData.getLocations().get(0).getPlacename();
			
			//needed
			this.address = jsonData.getLocations().get(0).getAddress();
			if(this.address.isEmpty()) return false;

			//needed
			this.lat = Double.parseDouble(jsonData.getLocations().get(0).getLatitude());
			this.lng = Double.parseDouble(jsonData.getLocations().get(0).getLongitude());
			
			//needed
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy/hh:mm:ss");
			this.startDate = formatter.parse(jsonData.getLocations().get(0).getDates().get(0).getDate() + "/"
					+ jsonData.getLocations().get(0).getDates().get(0).getTimeStart());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
