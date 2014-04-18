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
import com.ait.toolkit.sencha.touch.client.core.IsComponent;
import com.ait.toolkit.sencha.touch.client.layout.Type;
import com.ait.toolkit.sencha.touch.client.ui.Container;

/**
 * Container with an accordion layout.
 * 
 */
public class AccordionContainer implements IsComponent {

	private Container container;
	private AccordionLayout layout;

	public AccordionContainer() {
		layout = new AccordionLayout();
		layout.setType(Type.ACCORDION);
		layout.setMode(AccordionMode.MULTI);
		container = new Container();
		container.setLayout(layout);
	}

	public void setMode(AccordionMode mode) {
		layout.setMode(mode);
	}

	public AccordionMode getMode() {
		return layout.getMode();
	}

	public void add(Container child, int height) {
		child.setHeight(height);
		this.container.add(child);
	}

	public void setExpandedItem(Component component) {
		this.layout.setExpandedItem(component);
	}

	public Component getExpandedItem() {
		return this.layout.getExpandedItem();
	}

	public void setFullScreen(boolean fullScreen) {
		this.container.setFullScreen(true);
	}

	public Container getRawContainer() {
		return this.container;
	}

	/**
	 * This method is no more needed and will be removed in upcoming releases
	 * 
	 * @param parent
	 */
	@Deprecated
	public void addTo(Container parent) {
		parent.add(this.container);
	}

	@Override
	public Component asComponent() {
		return this.container;
	}

}
