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
package com.github.gwtc3.api.chart;

import com.github.gwtc3.api.AbstractJavaScriptObject;
import com.github.gwtc3.api.chart.generate.data.Data;
import com.github.gwtc3.api.chart.generate.data.FlowData;
import com.github.gwtc3.api.chart.generate.grid.Line;
import com.github.gwtc3.api.chart.grids.Grids;
import com.github.gwtc3.api.chart.resize.Size;
import com.google.gwt.core.client.JsArray;

/**
 */
public final class Chart extends AbstractJavaScriptObject {
	protected Chart() {
	}

	public native Chart load(Data data) /*-{ return this.load(data); }-*/;

	public native Chart flow(FlowData data) /*-{ return this.flow(data); }-*/;

	public Chart xGrids(Line... lines) {
		return xGrids(array(lines));
	}

	public native Chart xGrids(JsArray<Line> lines) /*-{ return this.xgrids(lines); }-*/;

	public native Grids xGrids() /*-{ return this.xgrids; }-*/;

	public native Grids yGrids() /*-{ return this.ygrids; }-*/;

	public native Chart resize(Size size) /*-{ return this.resize(size); }-*/;

	public native Chart resize() /*-{ return this.resize(); }-*/;

	public native Chart flush() /*-{ return this.flush(); }-*/;

	public native Chart zoom(int from, int to) /*-{ return this.zoom([from, to]); }-*/;

	public native Chart unzoom() /*-{ return this.unzoom(); }-*/;

	public native void destroy() /*-{ return this.destroy(); }-*/;
}
