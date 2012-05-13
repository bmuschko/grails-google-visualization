/* Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.google.visualization.util

import grails.test.GrailsUnitTestCase
import java.text.SimpleDateFormat

/**
 * Data utility tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class DateUtilTests extends GrailsUnitTestCase {
    void testCreateDateForDate() {
        def date = DateUtil.createDate(1995, Calendar.NOVEMBER, 29)
        def dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        assertEquals "1995/11/29", dateFormat.format(date)
    }

    void testCreateDateForDateAndTime() {
        def date = DateUtil.createDate(1995, Calendar.NOVEMBER, 29, 1, 2, 3, 4)
        def dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss:SSS");
        assertEquals "1995/11/29 01:02:03:004", dateFormat.format(date)
    }

    void testRemoveTimeForNull() {
        try {
            DateUtil.removeTime(null)
            fail("A null date should not be allowed")
        }
        catch(IllegalArgumentException e) {
        }
    }

    void testCreateDateJavaScriptObject() {
        def date = DateUtil.createDate(1995, Calendar.NOVEMBER, 29)
        def dateJavaScriptObject = DateUtil.createDateJavaScriptObject(date)
        assertEquals "new Date(1995, 10, 29)", dateJavaScriptObject.toString()
    }

    void testCreateDateTimeJavaScriptObject() {
        def date = DateUtil.removeTime(DateUtil.createDate(1995, Calendar.NOVEMBER, 29))
        def dateTimeJavaScriptObject = DateUtil.createDateTimeJavaScriptObject(date)
        assertEquals "new Date(1995, 10, 29, 0, 0, 0, 0)", dateTimeJavaScriptObject.toString()
    }

    void testCreateTimeOfDayJavaScriptObject() {
        def date = DateUtil.createDate(1995, Calendar.NOVEMBER, 29, 1, 2, 3, 4)
        def timeOfDayJavaScriptObject = DateUtil.createTimeOfDayJavaScriptObject(date)
        assertEquals "[1, 2, 3, 4]", timeOfDayJavaScriptObject.toString()
    }
}
