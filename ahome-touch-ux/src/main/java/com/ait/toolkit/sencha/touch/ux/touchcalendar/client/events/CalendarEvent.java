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
package com.ait.toolkit.sencha.touch.ux.touchcalendar.client.events;

import com.ait.toolkit.data.client.BaseModel;
import com.google.gwt.core.client.JsDate;

/**
 * Base class for calender event. Extend this class to create custom events
 * 
 */
public class CalendarEvent extends BaseModel {

	private final String NAME = "event";
	private final String START = "start";
	private final String END = "end";

	public CalendarEvent() {

	}

	public CalendarEvent(String name, JsDate start, JsDate end) {
		setName(name);
		setStart(start);
		setEnd(end);
	}

	public void setName(String name) {
		set(NAME, name);
	}

	public void setStart(JsDate start) {
		set(START, start);
	}

	public void setEnd(JsDate end) {
		set(END, end);
	}

	public String getName() {
		return get(NAME);
	}

	public JsDate getStart() {
		return getFromCache(START);
	}

	public JsDate getEnd() {
		return getFromCache(END);
	}

}
