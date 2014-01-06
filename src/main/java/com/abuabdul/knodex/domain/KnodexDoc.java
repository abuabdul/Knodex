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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="knodexdoc")
@CompoundIndexes({ @CompoundIndex(name = "indexBy_sentences", def = "{'key': 1, 'indexBy': 1}") })
public class KnodexDoc {

	@Id
	private String id;

	@Indexed
	private String key;

	@Indexed
	private String indexBy;

	private String indexSentence;

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

	@Override
	public String toString() {
		return "KnodexDocument [id=" + id + ", key=" + key + ", indexBy=" + indexBy + ", indexSentence = " + indexSentence + "]";
	}

}
