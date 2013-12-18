package com.abuabdul.knodex.model;

import java.io.Serializable;

public class KnodexForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13234234L;
	
	private String indexSentence;
	private String indexBy;

	public String getIndexSentence() {
		return indexSentence;
	}

	public void setIndexSentence(String indexSentence) {
		this.indexSentence = indexSentence;
	}

	public String getIndexBy() {
		return indexBy;
	}

	public void setIndexBy(String indexBy) {
		this.indexBy = indexBy;
	}

}
