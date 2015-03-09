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
package com.github.gwtc3.api.chart.generate;

import com.github.gwtc3.api.AbstractJavaScriptObject;
import com.github.gwtc3.api.chart.generate.axis.Axis;
import com.github.gwtc3.api.chart.generate.data.Data;
import com.github.gwtc3.api.chart.generate.grid.Grid;
import com.github.gwtc3.api.chart.generate.legend.Legend;
import com.github.gwtc3.api.chart.generate.padding.Padding;
import com.github.gwtc3.api.chart.generate.point.Point;
import com.github.gwtc3.api.chart.generate.subchart.Subchart;
import com.github.gwtc3.api.chart.generate.tooltip.Tooltip;
import com.github.gwtc3.api.chart.generate.transition.Transition;
import com.github.gwtc3.api.chart.generate.zoom.Zoom;

/**
 */
public final class Generate extends AbstractJavaScriptObject {
	protected Generate() {
	}

	public native String getBindTo() /*-{ return this.bindto; }-*/;

	public native void setBindTo(String bindTo) /*-{ this.bindto = bindTo; }-*/;

	public native Data getData() /*-{ return this.data; }-*/;

	public native void setData(Data data) /*-{ this.data = data; }-*/;

	public native Axis getAxis() /*-{ return this.axis; }-*/;

	public native void setAxis(Axis axis) /*-{ this.axis = axis; }-*/;

	public native Subchart getSubchart() /*-{ return this.subchart; }-*/;

	public native void setSubchart(Subchart subchart) /*-{ this.subchart = subchart; }-*/;

	public native Zoom getZoom() /*-{ return this.zoom; }-*/;

	public native void setZoom(Zoom zoom) /*-{ this.zoom = zoom; }-*/;

	public native Legend getLegend() /*-{ return this.legend; }-*/;

	public native void setLegend(Legend legend) /*-{ this.legend = legend; }-*/;

	public native Padding getPadding() /*-{ return this.padding; }-*/;

	public native void setPadding(Padding padding) /*-{ this.padding = padding; }-*/;

	public native Tooltip getTooltip() /*-{ return this.tooltip; }-*/;

	public native void setTooltip(Tooltip tooltip) /*-{ this.tooltip = tooltip; }-*/;

	public native Grid getGrid() /*-{ return this.grid; }-*/;

	public native void setGrid(Grid grid) /*-{ this.grid = grid; }-*/;

	public native Transition getTransition() /*-{ return this.transition; }-*/;

	public native void setTransition(Transition transition) /*-{ this.transition = transition; }-*/;

	public native Point getPoint() /*-{ return this.point; }-*/;

	public native void setPoint(Point point) /*-{ this.point = point; }-*/;

	public static class Builder {
		private Data data = Data.create();

		private Axis axis = Axis.create();

		private Subchart subchart = Subchart.create();

		private Zoom zoom = Zoom.create();

		private Legend legend = Legend.create();

		private Padding padding = Padding.create();

		private Tooltip tooltip = Tooltip.create();

		private Grid grid = Grid.create();

		private Transition transition = Transition.create();

		private Point point = Point.create();

		public Builder withData(Data data) {
			this.data = data;
			return this;
		}

		public Builder withAxis(Axis axis) {
			this.axis = axis;
			return this;
		}

		public Builder withSubchart(Subchart subchart) {
			this.subchart = subchart;
			return this;
		}

		public Builder withZoom(Zoom zoom) {
			this.zoom = zoom;
			return this;
		}

		public Builder withLegend(Legend legend) {
			this.legend = legend;
			return this;
		}

		public Builder withPadding(Padding padding) {
			this.padding = padding;
			return this;
		}

		public Builder withTooltip(Tooltip tooltip) {
			this.tooltip = tooltip;
			return this;
		}

		public Builder withTransition(Transition transition) {
			this.transition = transition;
			return this;
		}

		public Builder withGrid(Grid grid) {
			this.grid = grid;
			return this;
		}

		public Builder withPoint(Point point) {
			this.point = point;
			return this;
		}

		public Generate build() {
			Generate generate = create();
			generate.setData(data);
			generate.setAxis(axis);
			generate.setSubchart(subchart);
			generate.setZoom(zoom);
			generate.setLegend(legend);
			generate.setPadding(padding);
			generate.setTooltip(tooltip);
			generate.setTransition(transition);
			generate.setGrid(grid);
			generate.setPoint(point);

			return generate;
		}
	}
}
