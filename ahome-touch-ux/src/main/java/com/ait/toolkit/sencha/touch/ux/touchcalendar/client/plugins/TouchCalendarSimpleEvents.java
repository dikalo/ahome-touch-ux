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
package com.ait.toolkit.sencha.touch.ux.touchcalendar.client.plugins;

import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.AbstractCalendarPlugin;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This plugin can be added to an TouchCalendar instance to allow a store to be
 * bound to the calendar so events can be shown in a similar style to the iPhone
 * with a dot added to each day to represent the presence of an event.
 * 
 */
public class TouchCalendarSimpleEvents extends AbstractCalendarPlugin {

    public TouchCalendarSimpleEvents() {
        jsObj = createNativePeer();
    }

    public TouchCalendarSimpleEvents(JavaScriptObject obj) {
        jsObj = obj;
    }

    private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.ux.TouchCalendarSimpleEvents({});
    }-*/;

}
