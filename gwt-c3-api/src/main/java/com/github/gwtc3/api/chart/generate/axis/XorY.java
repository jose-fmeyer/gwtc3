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
package com.github.gwtc3.api.chart.generate.axis;

import com.github.gwtc3.api.AbstractJavaScriptObject;
import com.github.gwtc3.api.chart.generate.padding.Padding;

/**
 */
public final class XorY extends AbstractJavaScriptObject {
	protected XorY() {
	}

	public native boolean getShow() /*-{ return this.show; }-*/;

	public native void setShow(boolean show) /*-{ this.show = show; }-*/;

	public native int getHeight() /*-{ return this.height; }-*/;

	public native void setHeight(int height) /*-{ this.height = height; }-*/;

	public native String getLabel() /*-{ return this.label; }-*/;

	public native void setLabel(String label) /*-{ this.label = label; }-*/;

	public native String getType() /*-{ return this.type; }-*/;

	public final void setType(Type type) {
		setType(fromEnum(type));
	}

	public native void setType(String type) /*-{ this.type = type; }-*/;

	public native Tick getTick() /*-{ return this.tick; }-*/;

	public native void setTick(Tick tick) /*-{ this.tick = tick; }-*/;

	public native Padding getPadding() /*-{ return this.padding; }-*/;

	public native void setPadding(Padding padding) /*-{ this.padding = padding; }-*/;

	public static enum Type {
		CATEGORY, TIMESERIES
	}
}
