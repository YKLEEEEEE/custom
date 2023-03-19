package com.pcwk.ehr.wishtest.domain;

public class AccountVO {
	private String busiNumA;
	private String factory;
	private String tradeBank;
	private String accountNum;
	
	public AccountVO() {}

	public AccountVO(String busiNumA, String factory, String tradeBank, String accountNum) {
		super();
		this.busiNumA = busiNumA;
		this.factory = factory;
		this.tradeBank = tradeBank;
		this.accountNum = accountNum;
	}

	public String getBusiNumA() {
		return busiNumA;
	}

	public void setBusiNumA(String busiNumA) {
		this.busiNumA = busiNumA;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getTradeBank() {
		return tradeBank;
	}

	public void setTradeBank(String tradeBank) {
		this.tradeBank = tradeBank;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	@Override
	public String toString() {
		return "AccountVO [busiNumA=" + busiNumA + ", factory=" + factory + ", tradeBank=" + tradeBank + ", accountNum="
				+ accountNum + ", toString()=" + super.toString() + "]";
	}
	

	
	
	
}
