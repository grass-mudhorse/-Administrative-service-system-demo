package com.po;


public class Gift {
    private Integer id;

    private String giftname;

	private String giftkind;

    private Integer giftbudget;

    private Integer giftpri;
    
    private Integer isvalid;
    
    private String gifttempcon;

    
    
	public String getGifttempcon() {
		return gifttempcon;
	}

	public void setGifttempcon(String gifttempcon) {
		this.gifttempcon = gifttempcon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGiftname() {
		return giftname;
	}

	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}

	public String getGiftkind() {
		return giftkind;
	}

	public void setGiftkind(String giftkind) {
		this.giftkind = giftkind;
	}

	public Integer getGiftbudget() {
		return giftbudget;
	}

	public void setGiftbudget(Integer giftbudget) {
		this.giftbudget = giftbudget;
	}

	public Integer getGiftpri() {
		return giftpri;
	}

	public void setGiftpri(Integer giftpri) {
		this.giftpri = giftpri;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
}
