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
/**
 *
 */
package com.github.gwtc3.api.chart.generate.regions;

import com.github.gwtc3.api.AbstractJavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 */
public final class Region extends AbstractJavaScriptObject {
	protected Region() {
	}

	public native String getAxis() /*-{ return this.axis; }-*/;

	public native void setAxis(String axis) /*-{ this.axis = axis; }-*/;

	public native String getStart() /*-{ return this.start; }-*/;

	public native void setStart(int start) /*-{ this.start = start; }-*/;

	public native void setStart(String start) /*-{ this.start = start; }-*/;

	public native void setStart(JsDate start) /*-{ this.start = start; }-*/;

	public native String getEnd() /*-{ return this.end; }-*/;

	public native void setEnd(int end) /*-{ this.end = end; }-*/;

	public native void setEnd(String end) /*-{ this.end = end; }-*/;

	public native void setEnd(JsDate end) /*-{ this.end = end; }-*/;

	public native String getCssClass() /*-{ return this['class']; }-*/;

	public native void setCssClass(String cssClass) /*-{ this['class'] = cssClass; }-*/;
}
