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

public interface RecordIndexer {
	/**
	 * indexData is used to add a record to an index, to make is searchable.
	 * 
	 * @param ids
	 *            A list of Strings containing ids to use to index the record. If a record is of an
	 *            implementing type, the ids might contain both the combination of implementing
	 *            recordType and id, and the abstract recordType and id.
	 * 
	 * @param collectedData
	 *            A {@link DataGroup} that contains the index information for the record
	 * 
	 * @param record
	 *            A {@link DataGroup}, the record to index
	 *
	 */
	void indexData(List<String> ids, DataGroup collectedData, DataGroup record);

	/**
	 * deleteFromIndex is used to delete a record from an index.
	 * 
	 * @param type
	 *            A String with the recordType of the record to delete
	 * 
	 * @param id
	 *            A String with the id of the record to delete
	 */
	void deleteFromIndex(String type, String id);
}
