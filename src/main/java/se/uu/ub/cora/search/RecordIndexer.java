/*
 * Copyright 2017, 2024 Uppsala University Library
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

import se.uu.ub.cora.data.DataRecordGroup;
import se.uu.ub.cora.data.collected.IndexTerm;

/**
 * RecordIndexer indexes data in an index.
 * <p>
 * Implementations of RecordIndexer are generally not threadsafe.
 */
public interface RecordIndexer {
	/**
	 * indexData adds a record to an index, to make is searchable. Implementations SHOULD ensure
	 * that the indexed data is immediately available in searches as soon as this method returns.
	 * 
	 * @param recordType
	 *            A String with the recordType to index
	 * @param recordId
	 *            A String with the recordId to index
	 * @param indexTerms
	 *            A list of {@link IndexTerm} that contains the index term information for the
	 *            record
	 * @param dataRecordGroup
	 *            A {@link DataRecordGroup}, the record to index
	 * 
	 */
	void indexData(String recordType, String recordId, List<IndexTerm> indexTerms,
			DataRecordGroup dataRecordGroup);

	/**
	 * indexDataWithoutExplicitCommit adds a record to an index, to make is searchable.
	 * Implementations do not have to ensure that the indexed data is immediately available in
	 * searches as soon as this method returns. Implementations of this method are free to delay the
	 * availability of the indexed data for a reasonable period of time, for reasons such as improve
	 * performance.
	 * 
	 * @param recordType
	 *            A String with the recordType to index
	 * @param recordId
	 *            A String with the recordId to index
	 * @param indexTerms
	 *            A list of {@link IndexTerm} that contains the index term information for the
	 *            record
	 * @param dataRecordGroup
	 *            A {@link DataRecordGroup}, the record to index
	 */
	// TODO: create and use a new method to get a recordType and recordId. Combined the id inside
	// the method as: recordtype_recordId
	void indexDataWithoutExplicitCommit(String recordType, String recordId,
			List<IndexTerm> indexTerms, DataRecordGroup dataRecordGroup);

	/**
	 * deleteFromIndex deletes a record from an index. Implementations SHOULD ensure that the
	 * indexed data is immediately removed from searches as soon as this method returns.
	 * 
	 * @param type
	 *            A String with the recordType of the record to delete
	 * 
	 * @param id
	 *            A String with the id of the record to delete
	 */
	void deleteFromIndex(String type, String id);
}
