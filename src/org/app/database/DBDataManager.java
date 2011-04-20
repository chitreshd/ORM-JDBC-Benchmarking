/**
 * 
 */
package org.app.database;

import org.app.data.AData;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 * 
 * The interface intents to provide CRUD functionality
 * over java data objects while interacting with database.
 *
 */
public interface DBDataManager {
	
	public AData get(String symbol) throws Exception;
	public void put(AData dObject) throws Exception;
	public void update(AData dObject);
	public void delete(String symbol);

}
