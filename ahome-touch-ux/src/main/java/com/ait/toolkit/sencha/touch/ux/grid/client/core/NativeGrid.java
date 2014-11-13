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
package com.ait.toolkit.sencha.touch.ux.grid.client.core;

import java.util.List;

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class NativeGrid extends ListView {

	protected NativeGrid(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.ux.touch.grid.List({
			columns : []
		});
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	protected NativeGrid() {
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.touch.grid.List(config);
	}-*/;

	public static NativeGrid newInstance(Store store, List<GridColumn> cols) {
		JavaScriptObject obj = _createNative(store.getJsObj(),
				GridColumn.fromValues(cols));
		return new NativeGrid(obj);
	}

	public static NativeGrid newInstance(Store store, List<GridColumn> cols,
			boolean itemDisclosure) {
		JavaScriptObject obj = _createNative(store.getJsObj(),
				GridColumn.fromValues(cols), itemDisclosure);
		return new NativeGrid(obj);
	}

	public static NativeGrid newInstance(Store store, List<GridColumn> cols,
			List<String> features) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : features) {
			values.push(s);
		}
		JavaScriptObject obj = _createNative(store.getJsObj(),
				GridColumn.fromList(cols), values);
		return new NativeGrid(obj);
	}

	public static NativeGrid newInstance(Store store, List<GridColumn> cols,
			List<String> features, boolean itemDisclosure) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : features) {
			values.push(s);
		}
		JavaScriptObject obj = _createNative(store.getJsObj(),
				GridColumn.fromList(cols), values, itemDisclosure);
		return new NativeGrid(obj);
	}

	@Override
	public String getXType() {
		return XType.TOUCH_GRID.getValue();
	}

	public native GridColumn getColumn(int index)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var obj = dataView.getColumn(index);
		var toReturn = @com.ait.toolkit.sencha.touch.ux.grid.client.core.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
	}-*/;

	public native void toggleColumn(int index)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.toggleColumn(index);
	}-*/;

	public native void hideColumn(int index)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.hideColumn(index);
	}-*/;

	public native void showColumn(int index)/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataView.showColumn(index);
	}-*/;

	public List<GridColumn> getColumns() {
		return GridColumn.fromJsArray(_getColumns());
	}

	private static native JavaScriptObject _createNative(
			JavaScriptObject store, JavaScriptObject cols)/*-{
		var grid = $wnd.Ext.create('Ext.ux.touch.grid.List', {
			store : store,
			columns : cols,
			features : [ {
				ftype : 'Ext.ux.touch.grid.feature.Sorter',
				launchFn : 'initialize'
			} ]
		});
		return grid;
	}-*/;

	private static native JavaScriptObject _createNative(
			JavaScriptObject store, JavaScriptObject cols,
			boolean useItemDisclosure)/*-{
		var grid = $wnd.Ext.create('Ext.ux.touch.grid.List', {
			store : store,
			columns : cols,
			onItemDisclosure : useItemDisclosure,
			features : [ {
				ftype : 'Ext.ux.touch.grid.feature.Sorter',
				launchFn : 'initialize'
			} ]
		});
		return grid;
	}-*/;

	private static native JavaScriptObject _createNative(
			JavaScriptObject store, JavaScriptObject cols, JsArrayString array)/*-{
		var myFeatures = [];
		var config = {};
		config.store = store;
		config.columns = cols;

		for (var i = 0; i < array.length; i++) {
			var string = array[i];
			if (string == 'horizontal') {
				config.scrollable = 'horizontal';
			} else {
				var feature = @com.ait.toolkit.sencha.touch.ux.grid.client.core.NativeGrid::createFeatureFrom(Ljava/lang/String;)(string);
				myFeatures.push(feature);
			}

		}
		config.features = myFeatures;
		var grid = $wnd.Ext.create('Ext.ux.touch.grid.List', config);
		return grid;
	}-*/;

	private static native JavaScriptObject _createNative(
			JavaScriptObject store, JavaScriptObject cols, JsArrayString array,
			boolean useItemDisclosure)/*-{
		var myFeatures = [];
		var config = {};
		config.store = store;
		config.columns = cols;

		for (var i = 0; i < array.length; i++) {
			var string = array[i];
			if (string == 'horizontal') {
				config.scrollable = 'horizontal';
			} else {
				var feature = @com.ait.toolkit.sencha.touch.ux.grid.client.core.NativeGrid::createFeatureFrom(Ljava/lang/String;)(string);
				myFeatures.push(feature);
			}

		}
		config.features = myFeatures;
		config.onItemDisclosure = useItemDisclosure;
		var grid = $wnd.Ext.create('Ext.ux.touch.grid.List', config);
		return grid;
	}-*/;

	private native JsArray<JavaScriptObject> _getColumns()/*-{
		var dataView = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataView.getColumns();
	}-*/;

	private static native JavaScriptObject createFeatureFrom(String value)/*-{
		if (value == 'Ext.ux.touch.grid.feature.Sorter') {
			return ({
				ftype : 'Ext.ux.touch.grid.feature.Sorter',
				launchFn : 'initialize'
			});
		} else if (value == 'Ext.ux.touch.grid.feature.Editable') {
			return ({
				ftype : 'Ext.ux.touch.grid.feature.Editable',
				launchFn : 'initialize'
			});
		} else if (value == 'Ext.ux.touch.grid.feature.Paging') {
			return ({
				ftype : 'Ext.ux.touch.grid.feature.Paging',
				launchFn : 'initialize'
			});
		}
	}-*/;

}
