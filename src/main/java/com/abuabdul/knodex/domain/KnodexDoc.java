/*
 * Copyright 2013 abuabdul.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.abuabdul.knodex.domain;

public class KnodexDoc {

	private String id;
	private String indexSentence;
	private String indexBy;
	private String key;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
