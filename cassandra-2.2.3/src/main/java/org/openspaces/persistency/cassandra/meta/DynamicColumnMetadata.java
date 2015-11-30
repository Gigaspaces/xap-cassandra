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

import me.prettyprint.hector.api.Serializer;
import org.openspaces.persistency.cassandra.meta.mapping.node.TypeNode;
import org.openspaces.persistency.cassandra.meta.types.dynamic.PropertyValueSerializer;

/**
 * A {@link TypeNode} implementation representing a dynamic column for which no metadata 
 * exists on the matching Cassandra column family.
 * 
 * @since 9.1.1
 * @author Dan Kilman
 */
public class DynamicColumnMetadata extends AbstractColumnMetadata {
    
    private final String             fullName;
    private final PropertyValueSerializer dynamicPropertyValueSerializer;
    
    public DynamicColumnMetadata(String parentFullName, 
            String name, 
            PropertyValueSerializer dynamicPropertyValueSerializer) {
        this.dynamicPropertyValueSerializer = dynamicPropertyValueSerializer;
        fullName = (parentFullName != null ? parentFullName + "." : "") + name;
    }
    
    public DynamicColumnMetadata(
            String fullName,
            PropertyValueSerializer dynamicPropertyValueSerializer) {
        this.fullName = fullName;
        this.dynamicPropertyValueSerializer = dynamicPropertyValueSerializer;
    }
    
    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public PropertyValueSerializer getSerializer() {
        return dynamicPropertyValueSerializer;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented in dynamic columns");
    }

    @Override
    public Class<?> getType() {
        throw new UnsupportedOperationException("Not implemented in dynamic columns");
    }

}
