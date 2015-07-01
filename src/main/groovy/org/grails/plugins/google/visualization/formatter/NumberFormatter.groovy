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
package org.grails.plugins.google.visualization.formatter

/**
 * Number formatter
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class NumberFormatter extends StandardFormatter {
    def decimalSymbol
    def fractionDigits
    def groupingSymbol
    def negativeColor
    def negativeParens
    def pattern
    def prefix
    def suffix

    NumberFormatter(column) {
        super(column)
    }

    @Override
    def getObject() {
        'google.visualization.NumberFormat'
    }

    @Override
    def getFormatterOptions() {
        ['decimalSymbol': decimalSymbol, 'fractionDigits': fractionDigits, 'groupingSymbol': groupingSymbol,
         'negativeColor': negativeColor, 'negativeParens': negativeParens, 'pattern': pattern, 'prefix': prefix, 'suffix': suffix]
    }
}
