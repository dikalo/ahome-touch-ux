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

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.core.client.Attribute;
import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Represents a Column in the Gridwidget
 */
public class GridColumn extends JsObject {

	public GridColumn() {
		jsObj = JsoHelper.createObject();
	}

	public GridColumn(String header, String dataIndex) {
		this();
		setHeader(header);
		setDataIndex(dataIndex);
	}

	GridColumn(JavaScriptObject obj) {
		jsObj = obj;
	}

	/**
	 * The header of the gridcolumn
	 * 
	 * @param value
	 */
	public void setHeader(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.GRID_HEADER.getValue(), value);
	}

	/**
	 * The header of the gridcolumn
	 * 
	 * @param value
	 */
	public String getHeader() {
		return JsoHelper.getAttribute(jsObj, Attribute.GRID_HEADER.getValue());
	}

	/**
	 * The dataIndex of the gridcolumn
	 * 
	 * @param value
	 */
	public void setDataIndex(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.DATAINDEX.getValue(), value);
	}

	/**
	 * The dataIndex of the gridcolumn
	 * 
	 * @param value
	 */
	public String getDataIndex() {
		return JsoHelper.getAttribute(jsObj, Attribute.DATAINDEX.getValue());
	}

	/**
	 * The CSS Class of the gridcolumn
	 * 
	 * @param value
	 */
	public void setCls(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.CLS.getValue(), value);
	}

	/**
	 * The CSS Class of the gridcolumn
	 * 
	 * @param value
	 */
	public String getCls() {
		return JsoHelper.getAttribute(jsObj, Attribute.CLS.getValue());
	}

	/**
	 * The css style of the gridcolumn
	 * 
	 * @param value
	 */
	public void setStyle(String value) {
		JsoHelper.setAttribute(jsObj, "style", value);
	}

	/**
	 * The css style of the gridcolumn
	 * 
	 * @param value
	 */
	public String getStyle() {
		return JsoHelper.getAttribute(jsObj, Attribute.STYLE.getValue());
	}

	/**
	 * The css height of the gridcolumn
	 * 
	 * @param value
	 */
	public void setHeight(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.HEIGHT.getValue(), value);
	}

	/**
	 * The css height of the gridcolumn
	 * 
	 * @param value
	 */
	public String getHeight() {
		return JsoHelper.getAttribute(jsObj, Attribute.HEIGHT.getValue());
	}

	/**
	 * The css width of the gridcolumn
	 * 
	 * @param value
	 */
	public void setWidth(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.WIDTH.getValue(), value);
	}

	/**
	 * The hidden attribut of the gridcolumn
	 * 
	 * @param value
	 */
	public void setHidden(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.HIDDEN.getValue(), value);
	}

	/**
	 * The hidden attribut of the gridcolumn
	 * 
	 * @param value
	 */
	public boolean isHidden() {
		return JsoHelper.getAttributeAsBoolean(jsObj,
				Attribute.HIDDEN.getValue());
	}

	/**
	 * The sortable attribut of the gridcolumn
	 * 
	 * @param value
	 */
	public void setSortable(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.SORTABLE.getValue(), value);
	}

	/**
	 * The hidden attribut of the gridcolumn
	 * 
	 * @param value
	 */
	public boolean isSortable() {
		return JsoHelper.getAttributeAsBoolean(jsObj,
				Attribute.SORTABLE.getValue());
	}

	/**
	 * The css width of the gridcolumn
	 * 
	 * @param value
	 */
	public String getWidth() {
		return JsoHelper.getAttribute(jsObj, Attribute.WIDTH.getValue());
	}

	/**
	 * The css style of the gridcolumn
	 * 
	 * @param value
	 */
	public void setFilter(GridColumnFilter value) {
		JsoHelper.setAttribute(jsObj, Attribute.FILTER.getValue(),
				value.getJsObj());
	}

	/**
	 * The filter of the gridcolumn
	 * 
	 * @param value
	 */
	public GridColumnFilter getFilter() {
		JavaScriptObject obj = JsoHelper.getAttributeAsJavaScriptObject(jsObj,
				Attribute.FILTER.getValue());
		return new GridColumnFilter(obj);
	}

	public native void setRenderer(GridColumnRenderer renderer)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.renderer = $entry(function(value, values) {
			return renderer.@com.ait.toolkit.sencha.touch.ux.grid.client.core.GridColumnRenderer::onRender(Ljava/lang/String;)(value);
		});
	}-*/;

	public native void setRenderer(ColumnRenderer renderer)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.renderer = $entry(function(value, model) {
			var modelObject = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			return renderer.@com.ait.toolkit.sencha.touch.ux.grid.client.core.ColumnRenderer::onRender(Ljava/lang/String;Lcom/ait/toolkit/data/client/BaseModel;)(value, modelObject);
		});
	}-*/;

	public void setEditor(GridColumnEditor value) {
		JsoHelper.setAttribute(jsObj, Attribute.EDITOR.getValue(),
				value.getJsObj());
	}

	static JsArray<JavaScriptObject> fromList(List<GridColumn> columns) {
		JsArray<JavaScriptObject> values = JsArray.createArray().cast();
		for (GridColumn column : columns) {
			values.push(column.getJsObj());
		}
		return values;
	}

	static JsArray<JavaScriptObject> fromValues(List<GridColumn> columns) {
		ArrayList<GridColumn> cols = new ArrayList<GridColumn>();
		for (GridColumn column : columns) {
			cols.add(column);
		}
		return fromList(cols);
	}

	static ArrayList<GridColumn> fromJsArray(JsArray<JavaScriptObject> values) {
		ArrayList<GridColumn> columns = new ArrayList<GridColumn>();
		for (int i = 0; i < values.length(); i++) {
			columns.add(new GridColumn(values.get(i)));
		}
		return columns;
	}

}
