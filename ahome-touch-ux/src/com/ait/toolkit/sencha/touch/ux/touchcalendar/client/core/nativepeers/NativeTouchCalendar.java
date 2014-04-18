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
package com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.nativepeers;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.AbstractCalendarPlugin;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.TouchCalendarViewMode;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.handlers.PeriodChangeHandler;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.handlers.SelectionChangeHandler;
import com.ait.toolkit.sencha.touch.ux.touchcalendar.client.events.CalendarEventType;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * Container with a calendar like dataview
 */
public class NativeTouchCalendar extends Container {

	protected NativeTouchCalendar(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.ux.TouchCalendarView();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	public static NativeTouchCalendar create() {
		return new NativeTouchCalendar(_createNativePeer());
	}

	public static NativeTouchCalendar createPeer(JavaScriptObject obj) {
		return new NativeTouchCalendar(obj);
	}

	public static NativeTouchCalendar create(Store store, CalendarEventType type) {
		return new NativeTouchCalendar(_createNativePeer(store.getJsObj(),
				type.getValue(), JsDate.create(), ""));
	}

	public static NativeTouchCalendar create(Store store,
			CalendarEventType type, String eventTemplate) {
		return new NativeTouchCalendar(_createNativePeer(store.getJsObj(),
				type.getValue(), JsDate.create(), eventTemplate));
	}

	public static NativeTouchCalendar create(Store store,
			CalendarEventType type, JsDate selectedDate) {
		return new NativeTouchCalendar(_createNativePeer(store.getJsObj(),
				type.getValue(), selectedDate, ""));
	}

	public static NativeTouchCalendar create(Store store,
			CalendarEventType type, String eventTemplate, JsDate selectedDate) {
		return new NativeTouchCalendar(_createNativePeer(store.getJsObj(),
				type.getValue(), selectedDate, eventTemplate));
	}

	public static NativeTouchCalendar create(JsDate initialValue) {
		return new NativeTouchCalendar(_createNativePeer(initialValue));
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.TouchCalendarView(config);
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

	public TouchCalendarViewMode getViewMode() {
		return TouchCalendarViewMode.fromValue(_getViewMode());
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
		dataView.setViewMode(value);
	}-*/;

	private native String _getViewMode()/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataView.getViewMode();
	}-*/;

	/**
	 * Fires when the calendar changes to a different date period.(i,e switch
	 * using the arrows)
	 * 
	 * @param handler
	 */
	public native void addPeriodChangeHlander(PeriodChangeHandler handler)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView
				.on(
						"periodchange",
						$entry(function(cal, min, max, dir) {
							//var calendarView = @com.ait.toolkit.sencha.touch.ux.touchcalendar.client.TouchCalendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cal);
							handler.@com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.handlers.PeriodChangeHandler::onPeriodChange(Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;Ljava/lang/String;)(min, max. dir);

						}));
	}-*/;

	/**
	 * Fires when the calendar selected date is changed
	 * 
	 * @param handler
	 */
	public native void addSelectionChangeHlander(SelectionChangeHandler handler)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView
				.on(
						"selectionchange",
						$entry(function(cal, newDate, prevDate) {
							//var calendarView = @com.ait.toolkit.sencha.touch.ux.touchcalendar.client.TouchCalendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cal);
							handler.@com.ait.toolkit.sencha.touch.ux.touchcalendar.client.core.handlers.SelectionChangeHandler::onSelectionChange(Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JsDate;)(newDate,prevDate);

						}));
	}-*/;

	/**
	 * Add plugins to this calendar. Note the a store with Calendar events must
	 * be bound to the calender first
	 * 
	 * @param plugins
	 */
	public void addPlugin(AbstractCalendarPlugin... plugins) {
		Object[] objects = new Object[plugins.length];
		for (int i = 0; i < plugins.length; i++) {
			objects[i] = plugins[i].getJsObj();
		}
		_addPlugin(JsoHelper.convertToJavaScriptArray(objects));
	}

	private native void _addPlugin(JavaScriptObject value)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.setPlugins(value);
	}-*/;

	private native void setStore(JavaScriptObject value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setStore(value);
	}-*/;

	private static native JavaScriptObject _createNativePeer()/*-{
		return new $wnd.Ext.ux.TouchCalendarView({
			viewMode : 'month',
			weekStart : 1,
			value : new Date()
		});
	}-*/;

	private static native JavaScriptObject _createNativePeer(JsDate initialValue)/*-{
		return new $wnd.Ext.ux.TouchCalendarView({
			viewMode : 'month',
			weekStart : 0,
			value : initialValue
		});
	}-*/;

	private static native JavaScriptObject _createNativePeer(
			JavaScriptObject storeValue, String pluginType, JsDate currentDate,
			String eventTemplate)/*-{
		var plugin = null;
		if (pluginType == 'simple') {
			plugin = new $wnd.Ext.ux.TouchCalendarSimpleEvents();
		} else if (pluginType == 'advanced' && eventTemplate) {
			plugin = new $wnd.Ext.ux.TouchCalendarEvents({
				eventBarTpl : new $wnd.Ext.XTemplate(eventTemplate)
			});
		} else if (pluginType == 'advanced' && !eventTemplate) {
			plugin = new $wnd.Ext.ux.TouchCalendarEvents({
				eventBarTpl : new $wnd.Ext.XTemplate('{event}')
			});
		}
		return new $wnd.Ext.ux.TouchCalendarView({
			viewMode : 'month',
			weekStart : 0,
			value : currentDate,
			eventStore : storeValue,
			plugins : [ plugin ]
		});
	}-*/;

}
