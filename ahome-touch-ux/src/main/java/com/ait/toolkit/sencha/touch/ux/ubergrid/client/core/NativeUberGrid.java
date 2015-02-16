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
package com.ait.toolkit.sencha.touch.ux.ubergrid.client.core;

import java.util.List;

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class NativeUberGrid extends Container {

	protected NativeUberGrid(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		
    }-*/;

	protected NativeUberGrid() {
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.UberGrid.Panel(config);
	}-*/;

	public static NativeUberGrid newInstance(Store store,
			List<UberGridColumn> cols) {
		JavaScriptObject obj = _createNative(store.getJsObj(),
				UberGridColumn.fromValues(cols));
		return new NativeUberGrid(obj);
	}

	public static NativeUberGrid newInstance(Store store,
			List<UberGridColumn> cols, List<String> features) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : features) {
			values.push(s);
		}
		JavaScriptObject obj = _createNative(store.getJsObj(),
				UberGridColumn.fromList(cols), values);
		return new NativeUberGrid(obj);
	}

	@Override
	public String getXType() {
		return "ubergrid";
	}

	public void setBuffered(boolean value) {
		this.setAttribute("buffered", value, true);
	}

	public void setColumnLines(boolean value) {
		this.setAttribute("columnLines", value, true);
	}

	public void setRowCls(UberGridRowFunction fn) {
		this.setAttribute("getRowCls", _getRowCls(fn), true);
	}

	public void setHeaderHeight(double value) {
		this.setAttribute("headerHeight", value, true);
	}

	public void setLockedFlex(int value) {
		this.setAttribute("lockedFlex", value, true);
	}

	public void setLockedWidth(double value) {
		this.setAttribute("lockedWidth", value, true);
	}

	public void setNormalFlex(int value) {
		this.setAttribute("normalFlex", value, true);
	}

	public void swrRightFlex(int value) {
		this.setAttribute("rightFlex", value, true);
	}

	public void setRightWidth(double value) {
		this.setAttribute("rightWidth", value, true);
	}

	public void setRowHeight(double value) {
		this.setAttribute("rowHeight", value, true);
	}

	public void setRowHeightIsFixed(boolean value) {
		this.setAttribute("rowHeightIsFixed", value, true);
	}

	public void setScrollToTopOnHeaderTap(boolean value) {
		this.setAttribute("scrollToTopOnHeaderTap", value, true);
	}

	public void setStripeRows(boolean value) {
		this.setAttribute("stripeRows", value, true);
	}

	public void setTabularViewClass(int value) {
		this.setAttribute("tabularViewClass", value, true);
	}

	private native JavaScriptObject _getRowCls(UberGridRowFunction fn)/*-{
		return (function(m) {
			var ugModel = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.data.UberGridModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			return fn.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridRowFunction::onRender(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/data/UberGridModel;)(ugModel);
		});
	}-*/;

	public native void toggleColumn(int index)/*-{
		var grid = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		grid.toggleColumn(index);
	}-*/;

	public native void hideColumn(int index)/*-{
		var grid = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		grid.hideColumn(index);
	}-*/;

	public native void showColumn(int index)/*-{
		var grid = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		grid.showColumn(index);
	}-*/;

	public List<UberGridColumn> getColumns() {
		return UberGridColumn.fromJsArray(_getColums());
	}

	private native JsArray<JavaScriptObject> _getColums()/*-{
		var grid = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return grid.columns;
	}-*/;

	private static native JavaScriptObject _createNative(
			JavaScriptObject store, JavaScriptObject cols)/*-{
		var grid = $wnd.Ext.create('UberGrid.Panel', {
			store : store,
			columns : cols
		});
		return grid;
	}-*/;

	private static native JavaScriptObject _createNative(
			JavaScriptObject store, JavaScriptObject cols, JsArrayString array)/*-{
		var config = {};
		config.store = store;
		config.columns = cols;
		var grid = $wnd.Ext.create('UberGrid.Panel', config);
		return grid;
	}-*/;

}
