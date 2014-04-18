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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ait.toolkit.core.client.Attribute;
import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * This is a base column class in UberGrid. Column in UberGrid is a model class
 * - its instance does not have any reference to the visual presentation of the
 * column. All column headers are rendered as a whole by UberGrid.Header.
 * <p>
 * Usually column definitions are provided as an array of column configuration
 * objects or column instances. In case of configuration objects one can use the
 * xclass property to specify the desired class for the column.
 */
public class UberGridColumn extends JsObject {

	public UberGridColumn() {
		jsObj = JsoHelper.createObject();
	}

	public UberGridColumn(String header, String dataIndex) {
		this();
		setHeader(header);
		setDataIndex(dataIndex);
	}

	UberGridColumn(JavaScriptObject obj) {
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
	 * A unique id for the column. Id has to be unique among all columns -
	 * including the columns from other grids. If not provided, an
	 * auto-generated id will be used.
	 */
	public void setId(String value) {
		JsoHelper.setAttribute(jsObj, "id", value);
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
	 * A CSS class to be added to the data cell DOM elements for this column.
	 * Can be a single class or several classes, separated with spaces.
	 * 
	 * @param value
	 */
	public void setCellCls(String value) {
		JsoHelper.setAttribute(jsObj, "cellCls", value);
	}

	/**
	 * A CSS class to be added to the data cell DOM elements for this column.
	 * Can be a single class or several classes, separated with spaces.
	 * 
	 * @param value
	 */
	public String getCellCls() {
		return JsoHelper.getAttribute(jsObj, "cellCls");
	}

	/**
	 * A CSS style definition to be added to the data cell DOM elements for this
	 * column.
	 */
	public void setCellStyle(String value) {
		JsoHelper.setAttribute(jsObj, "cellStyle", value);
	}

	/**
	 * A CSS style definition to be added to the data cell DOM elements for this
	 * column.
	 * 
	 */
	public String getCellStyle() {
		return JsoHelper.getAttribute(jsObj, "cellStyle");
	}

	/**
	 * An array of child column config objects or column instances. If a column
	 * has some children columns then it becomes a "group" column and will not
	 * generate data cells. Only "leaf" columns generate data cells.
	 */
	public void setChildren(List<UberGridColumn> children) {
		JsoHelper.setAttribute(jsObj, "children",
				UberGridColumn.fromList(children));
	}

	/**
	 * An array of child column config objects or column instances. If a column
	 * has some children columns then it becomes a "group" column and will not
	 * generate data cells. Only "leaf" columns generate data cells.
	 * 
	 */
	public void setChildren(UberGridColumn... children) {
		setChildren(Arrays.asList(children));
	}

	public List<UberGridColumn> getChildren() {
		return UberGridColumn.fromJsArray(_getChildren());
	}

	private native JsArray<JavaScriptObject> _getChildren()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return obj.children;
	}-*/;

	/**
	 * A flex value used to calculate the width of the column. All columns with
	 * the width specified as flex property will share the remaining width after
	 * sizing columns with specified width property. The actual width of flex
	 * columns is calculated proportionally to their flex values.
	 * 
	 */
	public void setFlex(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.FLEX.getValue(), value);
	}

	/**
	 * Name of the field in the model to take the value from. Synonym for field.
	 * Use getField method to get a normalized value of the field name.
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

	public void setDefaultWidth(double value) {
		JsoHelper.setAttribute(jsObj, "defaultWidth", value);
	}

	public double getDefaultWidth() {
		return JsoHelper.getAttributeAsDouble(jsObj, "defaultWidth");
	}

	/**
	 * Name of the field in the model to take the value from. Has a synonym -
	 * dataIndex. Use getField method to get a normalized value of the field
	 * name.
	 */
	public void setField(String value) {
		JsoHelper.setAttribute(jsObj, "field", value);
	}

	public String getField() {
		return JsoHelper.getAttribute(jsObj, "field");
	}

	public void setFlex(int value) {
		JsoHelper.setAttribute(jsObj, "flex", value);
	}

	public int getFlex() {
		return JsoHelper.getAttributeAsInt(jsObj, "field");
	}

	/**
	 * 
	 * A CSS class to be added to the header cell DOM element of this column.
	 * Can be a single class or several classes, separated with spaces.
	 */
	public void setHeaderCls(String value) {
		JsoHelper.setAttribute(jsObj, "headerCls", value);
	}

	public String getHeaderCls() {
		return JsoHelper.getAttribute(jsObj, "headerCls");
	}

	/**
	 * The css width of the gridcolumn
	 * 
	 * @param value
	 */
	public void setWidth(double value) {
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
	 * Whether this column is "locked" - belongs to "locked" section. Setting
	 * this option to true is equivalent to specifying the type as "locked".
	 * <p>
	 * Defaults to: false
	 */
	public void setLocked(boolean value) {
		JsoHelper.setAttribute(jsObj, "locked", value);
	}

	/**
	 * A maxium width to which a column with flex width can be sized. Please
	 * refer to Getting Started Guide for more info on how column widths are
	 * calculated.
	 */
	public void setMaxWidth(double value) {
		JsoHelper.setAttribute(jsObj, "maxWidth", value);
	}

	/**
	 * A minimum width to which a column with flex width can be sized. Please
	 * refer to Getting Started Guide for more info on how column widths are
	 * calculated.
	 */
	public void setMinWidth(double value) {
		JsoHelper.setAttribute(jsObj, "minWidth", value);
	}

	/**
	 * 
	 * Header text. Synonym for header. Use getHeader method to get a normalized
	 * value of the header.
	 */
	public void setText(String value) {
		JsoHelper.setAttribute(jsObj, "text", value);
	}

	/**
	 * 
	 * The type of this column. Should be one of the strings:
	 * "normal/locked/right". Columns of the same type will be grouped together
	 * in the grid "section" or "subgrid". Each grid section can be scrolled
	 * individually in horizontal direction, but vertical scrolling is
	 * synchronized among all sections.
	 */
	public void setType(String value) {
		JsoHelper.setAttribute(jsObj, "type", value);
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
	public double getWidth() {
		return JsoHelper.getAttributeAsFloat(jsObj, Attribute.WIDTH.getValue());
	}

	/**
	 * 
	 * A function to use for customized rendering of the header.
	 */
	public native void setHeaderRenderer(UberGridColumnHeaderRenderer renderer)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		obj.headerRenderer = function(headerText, m, c) {
			var meta = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.HeaderMetaData::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var column = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			renderer.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumnHeaderRenderer::onRender(Ljava/lang/String;Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/HeaderMetaData;Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;)(meta,column);

		};
	}-*/;

	/**
	 * 
	 A function to use for customized rendering of the data cells of this
	 * column.
	 */
	public native void setRenderer(UberGridColumnRenderer renderer)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		obj.renderer = function(value, m, r, rowIndex, colIndex, s, c) {
			var meta = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.CellMetaData::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var record = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.data.UberGridModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var store = @com.ait.toolkit.sencha.shared.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var column = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			renderer.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumnRenderer::onRender(Ljava/lang/String;Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/CellMetaData;Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/data/UberGridModel;IILcom/ait/toolkit/sencha/shared/client/data/Store;Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;)(value,metan,record,rowIndex,colIndex,store,column);
		};
	}-*/;

	/**
	 * 
	 * A parent column of this column. If this column is the root one this
	 * property will contain null.
	 */
	public native UberGridColumn getParent()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var p = obj.parent;
		return @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
	}-*/;

	/**
	 * 
	 * This is an "in-depth" iterator for every child column of this column.
	 * Iterator starts from this column itself, then goes to the 1st child, then
	 * to the 1st child of that child, etc. Basically every time there's a
	 * possibility to go to a more nested column, this iterator does that.
	 * Returning false from the provided func will stop the iteration.
	 */
	public native void cascade(UberCascadeHandler fn)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.cascade) {
			obj
					.cascade(function(c) {
						var column = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
						return fn.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberCascadeHandler::onIteration(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;)(column);
					});
		}
	}-*/;

	/**
	 * 
	 * This is an "in-breadth" iterator for every child column of this column.
	 * Iterator starts from this column itself, then goes to all its direct
	 * children, and next their children. Basically every time when there's a
	 * possibility to continue iteration at the current nesting level this
	 * iterator does that. Returning false from the provided func will stop the
	 * iteration.
	 */
	public native void cascadeBreath(UberCascadeHandler fn)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.cascadeBreath) {
			obj
					.cascadeBreath(function(c) {
						var column = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
						return fn.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberCascadeHandler::onIteration(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;)(column);
					});
		}
	}-*/;

	/**
	 * This is an iterator for every direct child of this column. Returning
	 * false from the provided function will stop the iteration.
	 */
	public native void forEachChild(UberGridChildIterator it)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.cascadeBreath) {
			obj
					.cascadeBreath(function(c, index) {
						var column = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
						return it.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridChildIterator::onIteration(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;I)(column,index);
					});
		}
	}-*/;

	/**
	 * This is an iterator for every "leaf" column which is direct or indirect
	 * child of this column. Returning false from the provided function will
	 * stop the iteration.
	 */
	public native void forEachLeaf(UberGridChildIterator it)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.cascadeBreath) {
			obj
					.forEachLeaf(function(c, index) {
						var column = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
						return it.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridChildIterator::onIteration(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;I)(column,index);
					});
		}
	}-*/;

	/**
	 * 
	 * Returns a root column of this column. If column itself is a root - a
	 * reference to itself is returned.
	 */
	public native UberGridColumn getById(String id)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.getById) {
			var p = obj.getById(id);
			return @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p)
		}
		return null;
		;
	}-*/;

	/**
	 * 
	 * Returns a root column of this column. If column itself is a root - a
	 * reference to itself is returned.
	 */
	public List<UberGridColumn> getLeafs() {
		return UberGridColumn.fromJsArray(_getLeafs());
	}

	private native JsArray<JavaScriptObject> _getLeafs()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return p = obj.getLeafs();
	}-*/;

	/**
	 * 
	 * Returns a root column of this column. If column itself is a root - a
	 * reference to itself is returned.
	 */
	public native UberGridColumn getRoot()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var p = obj.getRoot();
		return @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
	}-*/;

	/**
	 * Return a total width of all child columns of this column.
	 */
	public native double getTotalWidth()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.getTotalWidth) {
			return obj.getTotalWidth();
		}
	}-*/;

	/**
	 * This method clears internal cache for various methods. It is safe to call
	 * it at any time if you've modified some important properties of this
	 * column.
	 */
	public native String getType()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.getType) {
			return obj.getType();
		}
	}-*/;

	/**
	 * This method clears internal cache for various methods. It is safe to call
	 * it at any time if you've modified some important properties of this
	 * column.
	 */
	public native void clearCache()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.clearCache) {
			obj.clearCache();
		}
	}-*/;

	/**
	 * Hides this column. See also hidden config, show and setHidden methods.
	 */
	public native void hide()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.hide) {
			obj.hide();
		}
	}-*/;

	/**
	 * Shows this column. See also hidden config, hide and setHidden methods.
	 */
	public native void show()/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.show) {
			obj.show();
		}
	}-*/;

	/**
	 * This event is fired when a structure of this column is changed - for
	 * example a child column is added / removed or moved to a different
	 * position.
	 * 
	 * @param handler
	 */
	public native void addColumnChangeHandler(
			UberGridColumnChangeHandler handler)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.addEventListener) {
			obj
					.addEventListener(
							'columnchange',
							function(col) {
								var ugCol = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(col);
								handler.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumnChangeHandler::onColumnChange(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;)(ugCol)

							});
		}
	}-*/;

	/**
	 * This event is fired when a width of this column is changed - via setWidth
	 * or setFlex methods.
	 */
	public native void addColumnWidthChangeHandler(
			UberGridColumnWidthChangeHandler handler)/*-{
		var obj = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (obj.addEventListener) {
			obj
					.addEventListener(
							'columnwidthchange',
							function(col, width, flex) {
								var ugCol = @com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(col);
								handler.@com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumnWidthChangeHandler::onColumnWidthChange(Lcom/ait/toolkit/sencha/touch/ux/ubergrid/client/core/UberGridColumn;DI)(ugCol, width, flex);

							});
		}
	}-*/;

	/**
	 * A CSS style definition to be added to the header cell DOM element of this
	 * column.
	 */
	public void setHeaderStyle(String value) {
		JsoHelper.setAttribute(jsObj, "headerStyle", value);
	}

	static JsArray<JavaScriptObject> fromList(List<UberGridColumn> columns) {
		JsArray<JavaScriptObject> values = JsArray.createArray().cast();
		for (UberGridColumn column : columns) {
			values.push(column.getJsObj());
		}
		return values;
	}

	static JsArray<JavaScriptObject> fromValues(List<UberGridColumn> columns) {
		ArrayList<UberGridColumn> cols = new ArrayList<UberGridColumn>();
		for (UberGridColumn column : columns) {
			cols.add(column);
		}
		return fromList(cols);
	}

	static ArrayList<UberGridColumn> fromJsArray(
			JsArray<JavaScriptObject> values) {
		ArrayList<UberGridColumn> columns = new ArrayList<UberGridColumn>();
		for (int i = 0; i < values.length(); i++) {
			columns.add(new UberGridColumn(values.get(i)));
		}
		return columns;
	}

}
