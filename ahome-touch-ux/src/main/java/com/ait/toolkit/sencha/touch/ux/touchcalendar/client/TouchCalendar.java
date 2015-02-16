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
package com.ait.toolkit.sencha.touch.ux.touchcalendar.client;

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.IsComponent;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.TouchCalendarViewMode;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.handlers.PeriodChangeHandler;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.handlers.SelectionChangeHandler;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.nativepeers.NativeTouchCalendar;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.events.CalendarEventType;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * Container with a calendar like dataview
 */
public class TouchCalendar implements IsComponent {

	protected Store store;
	protected NativeTouchCalendar nativePeer;

	public TouchCalendar() {
		nativePeer = NativeTouchCalendar.create();
	}

	protected TouchCalendar(JavaScriptObject obj) {
		nativePeer = NativeTouchCalendar.createPeer(obj);
	}

	public TouchCalendar(JsDate selectedDate) {
		nativePeer = NativeTouchCalendar.create(selectedDate);
	}

	/**
	 * Create a calender with events. Note that per default the event type is
	 * 'simple'.
	 * 
	 * @param eventStore
	 */
	public TouchCalendar(Store eventStore) {
		nativePeer = NativeTouchCalendar.create(eventStore,
				CalendarEventType.SIMPLE);
	}

	public TouchCalendar(Store eventStore, CalendarEventType eventType) {
		nativePeer = NativeTouchCalendar.create(eventStore, eventType);
	}

	public TouchCalendar(Store eventStore, CalendarEventType eventType,
			String eventTemplate) {
		if (eventType.equals(CalendarEventType.SIMPLE)) {
			eventTemplate = "";
		}
		nativePeer = NativeTouchCalendar.create(eventStore, eventType,
				eventTemplate);
	}

	public TouchCalendar(Store eventStore, CalendarEventType eventType,
			String eventTemplate, JsDate selectedDate) {
		if (eventType.equals(CalendarEventType.SIMPLE)) {
			eventTemplate = "";
		}
		nativePeer = NativeTouchCalendar.create(eventStore, eventType,
				eventTemplate, selectedDate);
	}

	public TouchCalendar(Store eventStore, CalendarEventType eventType,
			JsDate selectedDate) {
		nativePeer = NativeTouchCalendar.create(eventStore, eventType,
				selectedDate);
	}

	/**
	 * The mode the Calendar will be displayed in. Possible values 'month',
	 * 'week' or 'day'.
	 * 
	 * @param value
	 */
	public void setViewMode(TouchCalendarViewMode viewMode) {
		nativePeer.setViewMode(viewMode);
	}

	public TouchCalendarViewMode getViewMode() {
		return nativePeer.getViewMode();
	}

	/**
	 * The Starting day of the week. (0 = Sunday, 1 = Monday ... etc)
	 * 
	 * @param value
	 */
	public void setWeekStart(int value) {
		nativePeer.setWeekStart(value);
	}

	/**
	 * The number of minutes the Day View's time slot will increment by.
	 * Defaults to 30 minutes.
	 * 
	 * @param value
	 */
	public void setDayTimeSlotSize(int value) {
		nativePeer.setDayTimeSlotSize(value);
	}

	/**
	 * 
	 * refresh
	 * 
	 * @param value
	 */
	public void refresh() {
		nativePeer.refresh();
	}

	/**
	 * 
	 * refresh
	 * 
	 * @param value
	 */
	public void refreshDelta(int delta) {
		nativePeer.refreshDelta(delta);
	}

	/**
	 * Fires when the calendar changes to a different date period.(i,e switch
	 * using the arrows)
	 * 
	 * @param handler
	 */
	public void addPeriodChangeHlander(PeriodChangeHandler handler) {
		nativePeer.addPeriodChangeHlander(handler);
	}

	/**
	 * Fires when the calendar selected date is changed
	 * 
	 * @param handler
	 */
	public void addSelectionChangeHlander(SelectionChangeHandler handler) {
		nativePeer.addSelectionChangeHlander(handler);
	}

	@Override
	public Component asComponent() {
		return this.nativePeer;
	}

}
