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

/**
 * Date utility
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
final class DateUtil {
    private DateUtil() {}
  
    static createDate(year, month, day) {
        def calendar = new GregorianCalendar()
        calendar.set(year, month, day)
        calendar.getTime()
    }

    static createDate(year, month, day, hour, minute, second, millisecond) {
        def calendar = new GregorianCalendar()
        calendar.set(year, month, day, hour, minute, second)
        calendar.set(Calendar.MILLISECOND, millisecond)
        calendar.getTime()
    }

    static removeTime(date) {
        if(date == null) {
            throw new IllegalArgumentException("The argument 'date' cannot be null.");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);

        // Remove the hours, minutes, seconds and milliseconds.
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.getTime();
    }

    static createDateJavaScriptObject(date) {
        def calendar = new GregorianCalendar()
        calendar.setTime(date)
        def year = calendar.get(Calendar.YEAR)
        def month = calendar.get(Calendar.MONTH)
        def day = calendar.get(Calendar.DAY_OF_MONTH)
        "new Date(${year}, ${month}, ${day})"
    }

    static createDateTimeJavaScriptObject(date) {
        def calendar = new GregorianCalendar()
        calendar.setTime(date)
        def year = calendar.get(Calendar.YEAR)
        def month = calendar.get(Calendar.MONTH)
        def day = calendar.get(Calendar.DAY_OF_MONTH)
        def hours = calendar.get(Calendar.HOUR_OF_DAY)
        def minutes = calendar.get(Calendar.MINUTE)
        def seconds = calendar.get(Calendar.SECOND)
        def milliseconds = calendar.get(Calendar.MILLISECOND)
        "new Date(${year}, ${month}, ${day}, ${hours}, ${minutes}, ${seconds}, ${milliseconds})"
    }

    static createTimeOfDayJavaScriptObject(date) {
        def calendar = new GregorianCalendar()
        calendar.setTime(date)
        def hours = calendar.get(Calendar.HOUR_OF_DAY)
        def minutes = calendar.get(Calendar.MINUTE)
        def seconds = calendar.get(Calendar.SECOND)
        def milliseconds = calendar.get(Calendar.MILLISECOND)
        "[${hours}, ${minutes}, ${seconds}, ${milliseconds}]"
    }
}