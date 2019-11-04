package com.po;

public class Place {
    private Integer id;

    private String placename;

	private String placesize;

    private String placeloc;

    private Integer placepri;

    private String placecon;
    
	private Integer isvalid;
    
    private String placetempcon;
    
    
	public String getPlacetempcon() {
		return placetempcon;
	}

	public void setPlacetempcon(String placetempcon) {
		this.placetempcon = placetempcon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getPlacesize() {
		return placesize;
	}

	public void setPlacesize(String placesize) {
		this.placesize = placesize;
	}

	public String getPlaceloc() {
		return placeloc;
	}

	public void setPlaceloc(String placeloc) {
		this.placeloc = placeloc;
	}

	public Integer getPlacepri() {
		return placepri;
	}

	public void setPlacepri(Integer placepri) {
		this.placepri = placepri;
	}

	public String getPlacecon() {
		return placecon;
	}

	public void setPlacecon(String placecon) {
		this.placecon = placecon;
	}

    public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
   
}
