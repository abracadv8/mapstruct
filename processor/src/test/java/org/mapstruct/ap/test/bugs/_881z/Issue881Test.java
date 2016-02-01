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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

/**
 * Reproducer for https://github.com/mapstruct/mapstruct/issues/306.
 *
 * @author Sjaak Derksen
 */
@IssueKey( "306" )
@WithClasses( { Issue881Mapper.class,
    Source.class, Target.class,
    ArrayOfSource.class, ArrayOfTarget.class,
    ArrayContainerSource.class, ArrayContainerTarget.class } )
@RunWith( AnnotationProcessorTestRunner.class )
public class Issue881Test {

    @Test
    public void shouldNotThrowNPEOnHasCompatibleCopyConstructor() {
    }


    private ArrayOfSource sourcesList() {
        ArrayOfSource array = new ArrayOfSource();
        array.getSources().add( new Source( "s1", 1 ) );
        array.getSources().add( new Source( "s2", 2 ) );
        array.getSources().add( new Source( "s3", 3 ) );
        return array;
    }

    private Source[] sourcesArray() {
        Source[] sources = new Source[3];
        sources[0] = new Source( "s4", 4 );
        sources[1] = new Source( "s5", 5 );
        sources[2] = new Source( "s6", 6 );
        return sources;
    }

    private ArrayOfTarget targetsList() {
        ArrayOfTarget array = new ArrayOfTarget();
        array.getTargets().add( new Target( "t1", 1 ) );
        array.getTargets().add( new Target( "t2", 2 ) );
        array.getTargets().add( new Target( "t3", 3 ) );
        return array;
    }

    private Target[] targetsArray() {
        Target[] targets = new Target[3];
        targets[0] = new Target( "t4", 4 );
        targets[1] = new Target( "t5", 5 );
        targets[2] = new Target( "t6", 6 );
        return targets;
    }
}
