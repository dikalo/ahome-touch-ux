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
package com.ait.toolkit.sencha.touch.ux.rating.client;

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.ui.Field;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

public class Rating extends Field implements HasValue<Integer>,
		IsEditor<LeafValueEditor<Integer>> {

	private LeafValueEditor<Integer> editor;
	private int itemsCount = 5;
	private boolean showClearIcon = true;

	public Rating() {
		super();
	}

	protected Rating(JavaScriptObject obj) {
		super(obj);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var count = this.@com.ait.toolkit.sencha.touch.ux.rating.client.Rating::itemsCount;
		var icon = this.@com.ait.toolkit.sencha.touch.ux.rating.client.Rating::showClearIcon;
		config.inputCls = 'x-rating-star-input';
		config.itemCls = 'x-rating-star';
		config.itemHoverCls = 'x-rating-star-hover';
		config.clearIcon = icon;
		config.itemsCount = count;
		return new $wnd.Ext.ux.touch.Rating(config);
	}-*/;

	public Rating(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	public Rating(boolean showClearIcon) {
		this.showClearIcon = showClearIcon;
	}

	public Rating(int itemsCount, boolean showClearIcon) {
		this(itemsCount);
		this.showClearIcon = showClearIcon;
	}

	@Override
	public String getXType() {
		return XType.RATING.getValue();
	}

	/**
	 * Fires just after user selected new value
	 * 
	 * @param handler
	 */
	public native void addChangeHandler(ChangeHandler handler) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						'change',
						$entry(function(rating, newValue, oldValue) {
							var r = @com.ait.toolkit.sencha.touch.ux.rating.client.Rating::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rating);
							handler.@com.ait.toolkit.sencha.touch.ux.rating.client.ChangeHandler::onChange(Lcom/ait/toolkit/sencha/touch/ux/rating/client/Rating;II)(r,newValue,oldValue);
						}));
	}-*/;

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Integer> handler) {
		return null;
	}

	@Override
	public LeafValueEditor<Integer> asEditor() {
		if (editor == null) {
			editor = TakesValueEditor.of(this);
		}
		return editor;
	}

	@Override
	public void setValue(Integer value) {
		_setValue(value);
	}

	/**
	 * Sets the number of selected stars
	 */
	@Override
	public void setValue(Integer value, boolean fireEvents) {
		_setValue(value);
	}

	/**
	 * Gets the number of selected stars
	 */
	@Override
	public Integer getValue() {
		return _getValue();
	}

	private native int _getValue() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return (field.getValue() + 1);
		}
	}-*/;

	private native void _setValue(int value) /*-{
		if (value <= 0) {
			value = 1;
		}
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValue(value - 1);
		}
	}-*/;

}
