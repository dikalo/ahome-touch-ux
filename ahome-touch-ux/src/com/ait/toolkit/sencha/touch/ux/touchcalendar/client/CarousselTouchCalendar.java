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

import com.ait.toolkit.sencha.touch.client.ui.Carousel;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.TouchCalendarViewMode;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This extension wraps the
 * com.ait.toolkit.sencha.touch.ux.touchcalendar.CarousselTouchCalendar in a
 * com.emitrom.touch4j.client.containers.Carousel component and allows the
 * calendar to respond to swipe gestures to switch the displayed period.
 * 
 * WARNING : This class is still experimental as for Touch4j 2.0.1 Do NOT use it
 * for production code !!!
 */
public class CarousselTouchCalendar extends Carousel {

	protected CarousselTouchCalendar(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.ux.TouchCalendar();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	public CarousselTouchCalendar() {
		setViewMode(TouchCalendarViewMode.MONTH);

	}

	public CarousselTouchCalendar(TouchCalendarViewMode viewMode) {
		setViewMode(viewMode);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.xtype = 'calendar';
		config.viewConfig = {
			mode : 'month',
			weekStart : 1,
			value : new Date()
		};
		return new $wnd.Ext.ux.TouchCalendar(config);
	}-*/;

	/**
	 * The mode the Calendar will be displayed in. Possible values 'month',
	 * 'week' or 'day'.
	 * 
	 * @param value
	 */
	public void setViewMode(TouchCalendarViewMode viewMode) {
		_setViewMode(viewMode.getValue());
	}

	/**
	 * The Starting day of the week. (0 = Sunday, 1 = Monday ... etc)
	 * 
	 * @param value
	 */
	public native void setWeekStart(int value)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.setWeekStart(value);
	}-*/;

	/**
	 * The number of minutes the Day View's time slot will increment by.
	 * Defaults to 30 minutes.
	 * 
	 * @param value
	 */
	public native void setDayTimeSlotSize(int value)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.setDayTimeSlotSize(value);
	}-*/;

	/**
	 * 
	 * refresh
	 * 
	 * @param value
	 */
	public native void refresh()/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.refresh();
	}-*/;

	public TouchCalendarViewMode getViewMode() {
		return TouchCalendarViewMode.fromValue(_getViewMode());
	}

	/**
	 * 
	 * refresh
	 * 
	 * @param value
	 */
	public native void refreshDelta(int delta)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.refreshDelta(delta);
	}-*/;

	private native void _setViewMode(String value)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.setMode(value);
	}-*/;

	private native String _getViewMode()/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataView.getMode();
	}-*/;

}
