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
package com.ait.toolkit.sencha.touch.ux.grid.client;

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.IsComponent;
import com.ait.toolkit.sencha.touch.ux.grid.client.core.GridColumn;
import com.ait.toolkit.sencha.touch.ux.grid.client.core.GridFeature;
import com.ait.toolkit.sencha.touch.ux.grid.client.core.NativeGrid;

public class Grid implements IsComponent {

	private Store store;
	private List<GridColumn> columns;
	private List<GridFeature> features;
	private boolean gridWasCreated = false;
	private boolean useItemDisclosure;

	private NativeGrid widget;

	public Grid() {
		columns = new ArrayList<GridColumn>();
		features = new ArrayList<GridFeature>();
	}

	public void addColumn(GridColumn column) {
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

	public void addFeatures(GridFeature feature) {
		if (this.gridWasCreated) {
			throw new IllegalStateException(
					"The features for this widgets are allready set. Dis you use a constructor with features arguments ?");
		}
		this.features.add(feature);
	}

	public Grid(Store store, List<GridColumn> cols) {
		widget = NativeGrid.newInstance(store, cols);
		gridWasCreated = true;
	}

	public Grid(Store store, List<GridFeature> features, GridColumn... cols) {
		List<GridColumn> columns = new ArrayList<GridColumn>();
		List<String> values = new ArrayList<String>();
		for (GridColumn column : cols) {
			columns.add(column);
		}
		for (GridFeature feature : features) {
			if (feature == GridFeature.ITEM_DISCLOSURE) {
				this.useItemDisclosure = true;
			} else {
				values.add(feature.getValue());
			}

		}
		widget = NativeGrid.newInstance(store, columns, values);
		gridWasCreated = true;
	}

	public Grid(Store store, List<GridColumn> cols, List<GridFeature> features) {
		List<String> values = new ArrayList<String>();
		for (GridFeature feature : features) {
			values.add(feature.getValue());
		}
		widget = NativeGrid.newInstance(store, cols, values,
				this.useItemDisclosure);
		gridWasCreated = true;
	}

	public Grid(Store store, List<GridColumn> cols, GridFeature... features) {
		List<String> values = new ArrayList<String>();
		for (GridFeature feature : features) {
			if (feature == GridFeature.ITEM_DISCLOSURE) {
				this.useItemDisclosure = true;
			} else {
				values.add(feature.getValue());
			}
		}
		widget = NativeGrid.newInstance(store, cols, values,
				this.useItemDisclosure);
		gridWasCreated = true;
	}

	public GridColumn getColumn(int index) {
		return widget.getColumn(index);
	}

	public List<GridColumn> getColumns() {
		return widget.getColumns();
	}

	public NativeGrid getView() {
		return (NativeGrid) this.asComponent();
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
		return create(this.store, this.columns, this.features);
	}

	private Component create(Store s, List<GridColumn> cols,
			List<GridFeature> fts) {
		if (s == null || s.getCount() == 0) {
			throw new IllegalStateException(
					"The store for this grid  seems to be null or empty");
		} else if (cols.size() <= 0) {
			throw new IllegalStateException(
					"The columns for this grid  seems to be null or empty");
		}

		if (fts.size() > 0) {
			List<String> values = new ArrayList<String>();
			for (GridFeature feature : features) {
				if (feature == GridFeature.ITEM_DISCLOSURE) {
					this.useItemDisclosure = true;
				} else {
					values.add(feature.getValue());
				}
			}
			this.widget = NativeGrid.newInstance(s, cols, values,
					this.useItemDisclosure);
		} else {
			this.widget = NativeGrid.newInstance(s, cols,
					this.useItemDisclosure);
		}
		this.gridWasCreated = true;
		return this.widget;
	}

}
