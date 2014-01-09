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

package com.abuabdul.knodex.dao;

import java.util.List;

/**
 * @author abuabdul
 * 
 * @param <T>
 * 
 *            This is the repository interface contracts to interact with the
 *            MongoDB Database. It has finder methods to look up the documents
 *            from MongoDB.
 */
public interface KxDocumentDAO<T> {

	public T save(T entity);

	public T findOne(String id);

	public List<T> findAll();

	public List<T> findByKey(String key);

	public boolean exists(String key);

	public Long count();

	public void delete(T entity);

	public boolean deleteById(String id);

}
