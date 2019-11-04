package com.po;


public class Meet {

	private Integer id;

    private String meetname;

	private String meetsize;

    private String meetloc;

    private Integer meetpri;

    private String meetcon;
    
    private Integer isvalid;
    
    private String meettempcon;

    
    
	public String getMeettempcon() {
		return meettempcon;
	}

	public void setMeettempcon(String meettempcon) {
		this.meettempcon = meettempcon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeetname() {
		return meetname;
	}

	public void setMeetname(String meetname) {
		this.meetname = meetname;
	}

	public String getMeetsize() {
		return meetsize;
	}

	public void setMeetsize(String meetsize) {
		this.meetsize = meetsize;
	}

	public String getMeetloc() {
		return meetloc;
	}

	public void setMeetloc(String meetloc) {
		this.meetloc = meetloc;
	}

	public Integer getMeetpri() {
		return meetpri;
	}

	public void setMeetpri(Integer meetpri) {
		this.meetpri = meetpri;
	}

	public String getMeetcon() {
		return meetcon;
	}

	public void setMeetcon(String meetcon) {
		this.meetcon = meetcon;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
   
}
