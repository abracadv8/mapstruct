/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.bugs._881z;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class Issue881Mapper {

    public static final Issue881Mapper INSTANCE = Mappers.getMapper( Issue881Mapper.class );

    public abstract Source map( Target target );
    public abstract Target map( Source target );

    public abstract Source[] map1( List<Target> target );
    //public abstract Target[] map2( List<Source> target );

    /*@Mappings( {
        @Mapping( source = "sources", target = "targets" )
    } )
    public abstract ArrayContainerTarget map( ArrayOfSource source );
    */

    @Mappings( {
        @Mapping( source = "sources.sources", target = "targets" )
    } )
    public abstract ArrayContainerTarget map( ArrayContainerSource source );

}
