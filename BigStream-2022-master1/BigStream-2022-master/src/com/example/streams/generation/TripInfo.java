package com.example.streams.generation;

import com.google.gson.Gson;

public class TripInfo {

	//private String trackingId;
	//private Coordinate pickupPoint;
	//private Coordinate dropPoint;
	private String product;
	private String sellerName;
	private String customerName;
	private String location;
	//private String deliveryManName;
	//private double estimatedDeliveryTime;
	private String status;
	private String warehouse;
	
	
	public String getname() {
		return customerName;
	}


	public void setName(String name ){
		customerName = name;
	}

	public String getsname() {
		return sellerName;
	}


	public void setsName(String sname ){
		sellerName = sname;
	}

	public String getstats() {
		return status;
	}

	public String getloc() {
		return location;
	}


	public void setLoc(String loc ){
		location = loc;
	}


	public void setStatus(String stats ){
		status = stats;
	}

	public String getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(String ware ){
		warehouse = ware;
	}
	public String getproduct() {
		return product;
	}


	public void setProduct(String prod ){
		product = prod;
	}

/*
	public Coordinate getPickupPoint() {
		return pickupPoint;
	}


	public void setPickupPoint(Coordinate pickupPoint) {
		this.pickupPoint = pickupPoint;
	}


	public Coordinate getDropPoint() {
		return dropPoint;
	}


	public void setDropPoint(Coordinate dropPoint) {
		this.dropPoint = dropPoint;
	}


	public String getTypeOfVehicle() {
		return typeOfVehicle;
	}


	public void setTypeOfVehicle(String typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getPrimaryPassangerName() {
		return primaryPassangerName;
	}


	public void setPrimaryPassangerName(String primaryPassangerName) {
		this.primaryPassangerName = primaryPassangerName;
	}


	public String getPrimaryPassangerContact() {
		return primaryPassangerContact;
	}


	public void setPrimaryPassangerContact(String primaryPassangerContact) {
		this.primaryPassangerContact = primaryPassangerContact;
	}


	public double getEstimatedPrice() {
		return estimatedPrice;
	}


	public void setEstimatedPrice(double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}*/


	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	/*
	public static class Coordinate{
		private double lon;
		private double lat;
		public double getLon() {
			return lon;
		}
		public void setLon(double lon) {
			this.lon = lon;
		}
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		@Override
		public String toString() {
			return String.format("%s,%s", lat, lon);
		}
		
		
	}*/
}
