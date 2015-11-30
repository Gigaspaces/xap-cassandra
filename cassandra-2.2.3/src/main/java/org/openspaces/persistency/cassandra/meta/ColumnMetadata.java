/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openspaces.persistency.cassandra.meta;

import antlr.ByteBuffer;
import me.prettyprint.hector.api.Serializer;
import org.openspaces.persistency.cassandra.meta.mapping.node.TypeNode;
import org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer;

/**
 * A common interface for column based {@link TypeNode} implementations.
 * 
 * @since 9.1.1
 * @author Dan Kilman
 */
public interface ColumnMetadata {
    
    /**
     * @return The full column name as it appears on the Cassandra column family.
     */
    String getFullName();
    
    /**
     * @return The serializer to convert the column value from/to {@link ByteBuffer} representation.
     */
    PropertyValueSerializer getSerializer();
}
