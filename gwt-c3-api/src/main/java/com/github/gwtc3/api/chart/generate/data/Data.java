/*
 * Copyright (c) 2015, Piotr Sobiech
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.gwtc3.api.chart.generate.data;

import com.github.gwtc3.api.AbstractJavaScriptObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 */
public class Data extends AbstractJavaScriptObject {
	protected Data() {
	}

	public final native void setX(String x) /*-{ this.x = x; }-*/;

	public final native void setXFormat(String xFormat) /*-{ this.xFormat = xFormat; }-*/;

	public final native void setLabels(boolean labels) /*-{ this.labels = labels; }-*/;

	public final void setNames(Map names) {
		setNames((JavaScriptObject)names);
	}

	public final native void setNames(JavaScriptObject names) /*-{ this.names = names; }-*/;

	public final void setColors(Map names) {
		setColors((JavaScriptObject)names);
	}

	public final native void setColors(JavaScriptObject colors) /*-{ this.colors = colors; }-*/;

	public final void setAxes(Map names) {
		setAxes((JavaScriptObject)names);
	}

	public final native void setAxes(JavaScriptObject axes) /*-{ this.axes = axes; }-*/;

	public final native void setUrl(String url) /*-{ this.url = url; }-*/;

	public final native void setMimeType(String mimeType) /*-{ this.mimeType = mimeType; }-*/;

	public final native void setJson(JavaScriptObject json) /*-{ this.json = json; }-*/;

	public final native JsArray<JsArrayString> getGroups() /*-{ return this.groups; }-*/;

	public final void setGroups(String... groups) {
		setGroups(array(stringArray(groups)));
	}

	public final native void setGroups(JsArray<JsArrayString> groups) /*-{ this.groups = groups; }-*/;

	@SafeVarargs
	public final <T extends JavaScriptObject> void setColumns(T... columns) {
		setColumns(array(columns));
	}

	public final native <T extends JavaScriptObject> void setColumns(JsArray<T> columns) /*-{ this.columns = columns; }-*/;

	@SafeVarargs
	public final <T extends JavaScriptObject> void setRows(T... rows) {
		setRows(array(rows));
	}

	public final native <T extends JavaScriptObject> void setRows(JsArray<T> rows) /*-{ this.rows = rows; }-*/;

	public final void setType(Type type) {
		setType(fromEnum(type));
	}

	public final native void setType(String type) /*-{ this.type = type; }-*/;

	public static enum Type {
		PIE, DONUT, LINE, SCATTER, SPLINE, BAR, AREA, AREA_SPLINE
	}
}
