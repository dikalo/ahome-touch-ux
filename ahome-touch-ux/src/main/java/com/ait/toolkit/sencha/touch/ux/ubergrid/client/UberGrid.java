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
package com.ait.toolkit.sencha.touch.ux.ubergrid.client;

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.IsComponent;
import com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.NativeUberGrid;
import com.ait.toolkit.sencha.touch.ux.ubergrid.client.core.UberGridColumn;

public class UberGrid implements IsComponent {

	private Store store;
	private List<UberGridColumn> columns;
	private boolean gridWasCreated = false;

	private NativeUberGrid widget;

	public UberGrid() {
		columns = new ArrayList<UberGridColumn>();

	}

	public void addColumn(UberGridColumn column) {
		if (this.gridWasCreated) {
			throw new IllegalStateException(
					"The columns for this widgets are allready set. Dis you use a constructor with columns arguments ?");
		}
		this.columns.add(column);
	}

	public void setStore(Store store) {
		if (this.gridWasCreated) {
			throw new IllegalStateException(
					"The store for this widgets is allready set. Dis you use a constructor with store argument ?");
		}
		this.store = store;
	}

	public UberGrid(Store store, List<UberGridColumn> cols) {
		widget = NativeUberGrid.newInstance(store, cols);
		gridWasCreated = true;
	}

	public UberGrid(Store store, UberGridColumn... cols) {
		List<UberGridColumn> columns = new ArrayList<UberGridColumn>();
		List<String> values = new ArrayList<String>();
		for (UberGridColumn column : cols) {
			columns.add(column);
		}

		widget = NativeUberGrid.newInstance(store, columns, values);
		gridWasCreated = true;
	}

	public UberGridColumn getColumn(int index) {
		if (this.columns == null) {
			this.getColumns();
		}
		return this.columns.get(index);
	}

	public List<UberGridColumn> getColumns() {
		this.columns = widget.getColumns();
		return this.columns;
	}

	public NativeUberGrid getView() {
		return (NativeUberGrid) this.asComponent();
	}

	public void toggleColumn(int index) {
		widget.toggleColumn(index);
	}

	public void showColumn(int index) {
		widget.showColumn(index);
	}

	public void hideColumn(int index) {
		widget.hideColumn(index);
	}

	@Override
	public Component asComponent() {
		if (this.gridWasCreated) {
			return this.widget;
		}
		return create(this.store, this.columns);
	}

	private Component create(Store s, List<UberGridColumn> cols) {
		if (s == null || s.getCount() == 0) {
			throw new IllegalStateException(
					"The store for this grid  seems to be null or empty");
		} else if (cols.size() <= 0) {
			throw new IllegalStateException(
					"The columns for this grid  seems to be null or empty");
		}

		this.widget = NativeUberGrid.newInstance(s, cols);
		this.gridWasCreated = true;
		return this.widget;
	}

}
