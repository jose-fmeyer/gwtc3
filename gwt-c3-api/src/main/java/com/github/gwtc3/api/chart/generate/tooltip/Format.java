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
package com.github.gwtc3.api.chart.generate.tooltip;

import com.github.gwtc3.api.AbstractJavaScriptObject;
import com.github.gwtc3.api.ObjectHandler;
import com.github.gwtc3.api.chart.generate.data.Map;
import com.github.gwtd3.api.core.Formatter;

/**
 */
public final class Format extends AbstractJavaScriptObject {
	protected Format() {
	}

	public native void setTitle(ObjectHandler objectHandler) /*-{
		this.title = function (value) {
			return objectHandler.@com.github.gwtc3.api.ObjectHandler::handle(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
		};
	}-*/;

	public native void setName(Map<Formatter> formatters) /*-{
		this.name = function (value, ratio, id, index) {
			return formatters[id](value);
		};
	}-*/;

	public native void setValue(Map<Formatter> formatters) /*-{
		this.value = function (value, ratio, id, index) {
			return formatters[id](value);
		};
	}-*/;

}
