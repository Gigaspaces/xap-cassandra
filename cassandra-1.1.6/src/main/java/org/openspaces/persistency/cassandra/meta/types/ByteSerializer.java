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
package org.openspaces.persistency.cassandra.meta.types;

import me.prettyprint.cassandra.serializers.AbstractSerializer;
import me.prettyprint.hector.api.Serializer;

import java.nio.ByteBuffer;

/**
 * A {@link Serializer} implementation for {@link Byte} values.
 * 
 * @since 9.1.1
 * @author Dan Kilman
 */
public class ByteSerializer
    extends AbstractSerializer<Byte>
    implements Serializer<Byte> {

    private static final ByteSerializer INSTANCE = new ByteSerializer();
    
    public static Serializer<Byte> get() {
        return INSTANCE;
    }

    @Override
    public ByteBuffer toByteBuffer(Byte obj) {
        return ByteBuffer.wrap(new byte[] { obj });
    }

    @Override
    public Byte fromByteBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.get();
    }

}
