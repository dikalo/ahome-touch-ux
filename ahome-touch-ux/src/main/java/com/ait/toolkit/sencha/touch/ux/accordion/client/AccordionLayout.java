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
package com.ait.toolkit.sencha.touch.ux.accordion.client;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.layout.AbstractBox;
import com.ait.toolkit.sencha.touch.client.layout.Type;
import com.google.gwt.core.client.JavaScriptObject;

class AccordionLayout extends AbstractBox {

	protected JavaScriptObject jso;
	private Component expandedItem;

	AccordionLayout() {
		setType(Type.ACCORDION);
		setMode(AccordionMode.MULTI);
	}

	void setMode(AccordionMode mode) {
		_setMode(mode.getValue());
	}

	private native void _setMode(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.ux.accordion.client.AccordionLayout::getJSO()();
		if (jso.setMode) {
			jso.setMode(value);
		} else {
			jso.mode = value;
		}

	}-*/;

	AccordionMode getMode() {
		return AccordionMode.fromValue(_getMode());
	}

	private native String _getMode() /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.ux.accordion.client.AccordionLayout::getJSO()();
		jso.getMode();
	}-*/;

	void setExpandedItem(Component component) {
		this.expandedItem = component;
		_setExpandedItem(component.getJsObj());
	}

	Component getExpandedItem() {
		return this.expandedItem;
	}

	private native void _setExpandedItem(JavaScriptObject component) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.ux.accordion.client.AccordionLayout::getJSO()();
		jso.setExpandedItem(component);
	}-*/;

}
