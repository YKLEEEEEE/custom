package com.pcwk.ehr.wishtest.cmn;

public class SearchVO extends DTO {
	
	private String searchWordBn;//검색어(default = "")
	private String searchWordC;//검색어(default = "")
	

	
	public SearchVO() {}



	public SearchVO(String searchWordBn, String searchWordC) {
		super();
		this.searchWordBn = searchWordBn;
		this.searchWordC = searchWordC;
	}



	public String getSearchWordBn() {
		return searchWordBn;
	}



	public void setSearchWordBn(String searchWordBn) {
		this.searchWordBn = searchWordBn;
	}



	public String getSearchWordC() {
		return searchWordC;
	}



	public void setSearchWordC(String searchWordC) {
		this.searchWordC = searchWordC;
	}



	@Override
	public String toString() {
		return "SearchVO [searchWordBn=" + searchWordBn + ", searchWordC=" + searchWordC + ", toString()="
				+ super.toString() + "]";
	}






	
}
