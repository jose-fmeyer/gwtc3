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

package pl.psobiech.client;

import com.github.gwtc3.api.C3;
import com.github.gwtc3.api.ObjectHandler;
import com.github.gwtc3.api.chart.Chart;
import com.github.gwtc3.api.chart.generate.Generate;
import com.github.gwtc3.api.chart.generate.Generate.Builder;
import com.github.gwtc3.api.chart.generate.axis.Axis;
import com.github.gwtc3.api.chart.generate.axis.Tick;
import com.github.gwtc3.api.chart.generate.axis.XorY;
import com.github.gwtc3.api.chart.generate.data.Data;
import com.github.gwtc3.api.chart.generate.data.FlowData;
import com.github.gwtc3.api.chart.generate.data.Map;
import com.github.gwtc3.api.chart.generate.subchart.Subchart;
import com.github.gwtc3.api.chart.generate.tooltip.Format;
import com.github.gwtc3.api.chart.generate.tooltip.Tooltip;
import com.github.gwtc3.api.chart.generate.zoom.Zoom;
import com.github.gwtd3.api.D3;
import com.github.gwtd3.api.core.Formatter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

import static com.github.gwtc3.api.AbstractJavaScriptObject.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Webapp implements EntryPoint {
	long ts = 1390575600000L;

	private DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyy.MM.dd");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Data data = Data.create();
		data.setX("x");
		data.setColumns(//
				array(//
						numberArray("x", (ts += 1000), (ts += 1000), (ts += 1000), (ts += 1000), (ts += 1000), (ts += 1000)),//
						integerArray("data1", (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000)),//
						integerArray("data2", (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000))//
				)//
		);
		Map names = Map.create();
		names.put("data1", "data1 Name");
		names.put("data2", "data2 Name");

		data.setNames(names);

		Tick tick = Tick.create();
		tick.setFormat("%H:%M:%S");

		XorY x = XorY.create();
		x.setType(XorY.Type.TIMESERIES);
		x.setTick(tick);

		Axis axis = Axis.create();
		axis.setX(x);

		Subchart subchart = Subchart.create();
		subchart.setShow(true);

		Zoom zoom = Zoom.create();
		zoom.setEnabled(true);

		Format format = Format.create();
		format.setTitle(new ObjectHandler<JsDate>() {
			@Override
			public String handle(JsDate element) {
				Date date = cast(element);
				return dateTimeFormat.format(date);
			}
		});

		Map<Formatter> formatters = Map.create();
		formatters.put("data1", D3.format(","));
		formatters.put("data2", D3.format("$"));
		format.setValue(formatters);

		Tooltip tooltip = Tooltip.create();
		tooltip.setFormat(format);

		Generate generate = new Builder()//
				.withAxis(axis)//
				.withData(data)//
				.withSubchart(subchart)//
				.withZoom(zoom)//
				.withTooltip(tooltip)//
				.build();

		dir(generate);
		final Chart chart = C3.generate(//
				generate//
		);

		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
			@Override
			public boolean execute() {
				FlowData flowData = FlowData.create();
				flowData.setRows(array(//
						stringArray("x", "data1", "data2"),//
						integerArray((ts += 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000))//
				));

				dir(flowData);
				chart.flow(flowData);

				return true;
			}
		}, 4000);
	}

	public static native void dir(JavaScriptObject jso) /*-{ console.dir(jso); }-*/;
}
