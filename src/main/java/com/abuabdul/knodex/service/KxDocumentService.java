/*
 * Copyright 2013-2014 abuabdul.com
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

package com.abuabdul.knodex.service;

import java.util.List;
import java.util.SortedMap;

/**
 * @author abuabdul
 * 
 * @param <T>
 * 
 *            This is the Document Service level contract interface. Document
 *            Service class implements this interface to interact with MongoDB
 *            repositories layer classes.
 */
public interface KxDocumentService<T> {

	public boolean indexASentence(T entity);

	public boolean removeASentence(String id);

	public List<T> listSentencesByIndexer(String key);

	public SortedMap<String, List<T>> listAllSentences();

	public Long getTotalRecordsSize();

}
