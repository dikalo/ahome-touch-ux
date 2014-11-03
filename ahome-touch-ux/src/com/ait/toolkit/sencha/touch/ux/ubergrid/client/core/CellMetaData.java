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

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.core.config.BaseConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An object that can be used for styling of the data cell.
 * 
 */
public class CellMetaData extends BaseConfig {

	protected CellMetaData(JavaScriptObject obj) {
		jsObj = obj;
	}

	/**
	 * 
	 * A CSS style definition to be added to cellStyle. Can be a string or an
	 * object, which keys will correspond to CSS propertis and values - to
	 * values of properties.
	 */
	public void setCellStyle(String value) {
		JsoHelper.setAttribute(jsObj, "cellStyle", value);
	}

	/**
	 * 
	 A CSS class declaration in addition to headerCls. Can be a single class
	 * or several classes, separated with space.
	 */
	public void setCellCls(String value) {
		JsoHelper.setAttribute(jsObj, "cellCls", value);
	}

	/**
	 * 
	 * Additional attributes for data cell DOM element. Can be a string of
	 * HTML-like format or an object. In the latter case keys will correspond to
	 * attribute names and values - to values.
	 */
	public void setCellAttr(BaseConfig value) {
		JsoHelper.setAttribute(jsObj, "cellAttr", value.getJsObj());
	}

	/**
	 * 
	 A row height. The biggest row height from all cells will be used. If none
	 * of columns set this property of the meta object a default value rowHeight
	 * will be used.
	 */
	public void setRowHeight(double value) {
		JsoHelper.setAttribute(jsObj, "rowHeight", value);
	}
}
