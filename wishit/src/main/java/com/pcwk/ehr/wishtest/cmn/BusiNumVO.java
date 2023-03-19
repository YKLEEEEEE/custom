package com.pcwk.ehr.wishtest.cmn;

public class BusiNumVO {
	private String busiNumC;

	public BusiNumVO(String busiNumC) {
		super();
		this.busiNumC = busiNumC;
	}

	public String getBusiNumC() {
		return busiNumC;
	}

	public void setBusiNumC(String busiNumC) {
		this.busiNumC = busiNumC;
	}

	@Override
	public String toString() {
		return "BusiNumVO [busiNumC=" + busiNumC + "]";
	}
	
	
}
