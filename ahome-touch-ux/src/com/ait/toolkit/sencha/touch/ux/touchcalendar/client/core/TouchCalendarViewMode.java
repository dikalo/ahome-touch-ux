/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core;

public enum TouchCalendarViewMode {
    DAY("day"), MONTH("month"), WEEK("week");

    private String value;

    private TouchCalendarViewMode(String mode) {
        this.value = mode;
    }

    public String getValue() {
        return value;
    }

    public static TouchCalendarViewMode fromValue(String value) {
        if (value.equalsIgnoreCase(TouchCalendarViewMode.DAY.value)) {
            return TouchCalendarViewMode.DAY;
        } else if (value.equalsIgnoreCase(TouchCalendarViewMode.MONTH.value)) {
            return TouchCalendarViewMode.MONTH;
        } else if (value.equalsIgnoreCase(TouchCalendarViewMode.WEEK.value)) {
            return TouchCalendarViewMode.WEEK;
        }
        return null;
    }
}
