/*
 * Copyright 2017 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.cora.search;

import java.util.List;

import se.uu.ub.cora.data.DataGroup;

/**
 * RecordSearch searches for data in an index.
 * <p>
 * Implementations of RecordSearch are generally not threadsafe.
 */
public interface RecordSearch {
	/**
	 * searchUsingListOfRecordTypesToSearchInAndSearchData is used to search an index for records
	 * matching the searchData
	 * 
	 * @param recordTypes
	 *            A List of recordTypes to include in the search
	 * 
	 * @param searchData
	 *            A {@link DataGroup} including the data to compose the search query from
	 * 
	 * @return A SearchResult with the information returned from the search
	 */
	SearchResult searchUsingListOfRecordTypesToSearchInAndSearchData(List<String> recordTypes,
			DataGroup searchData);
}