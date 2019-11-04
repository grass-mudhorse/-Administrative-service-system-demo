package com.po;


public class Restaurant {
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public Integer getRestaurantsize() {
		return restaurantsize;
	}

	public void setRestaurantsize(Integer restaurantsize) {
		this.restaurantsize = restaurantsize;
	}

	public Integer getRestaurantnum() {
		return restaurantnum;
	}

	public void setRestaurantnum(Integer restaurantnum) {
		this.restaurantnum = restaurantnum;
	}

	public String getRestaurantloc() {
		return restaurantloc;
	}

	public void setRestaurantloc(String restaurantloc) {
		this.restaurantloc = restaurantloc;
	}

	public Integer getRestaurantpri() {
		return restaurantpri;
	}

	public void setRestaurantpri(Integer restaurantpri) {
		this.restaurantpri = restaurantpri;
	}

	public String getRestaurantcon() {
		return restaurantcon;
	}

	public void setRestaurantcon(String restaurantcon) {
		this.restaurantcon = restaurantcon;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public String getRestauranttempcon() {
		return restauranttempcon;
	}

	public void setRestauranttempcon(String restauranttempcon) {
		this.restauranttempcon = restauranttempcon;
	}

	private Integer id;

    private String restaurantname;

	private Integer restaurantsize;

    private Integer restaurantnum;

    private String restaurantloc;

    private Integer restaurantpri;
    
    private String restaurantcon;
    
    private Integer isvalid;
    
    private String restauranttempcon;

}
