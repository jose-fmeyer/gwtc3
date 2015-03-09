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

package com.github.gwtc3.js.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class C3Js implements EntryPoint {
	@Override
	public void onModuleLoad() {
		C3Resources resources = loadResources();

		boolean pretty = isPretty(resources);
		GWT.log("[C3Js] Loading " + (pretty ? "pretty" : "obfuscated") + " resources");

		TextResource c3Css = resources.c3Css();
		GWT.log("[C3Js] Injecting CSS " + c3Css.getName());
		StyleInjector.inject(c3Css.getText());

		TextResource c3JavaScript = resources.c3JavaScript();
		GWT.log("[C3Js] Injecting JavaScript " + c3JavaScript.getName());
		ScriptInjector.fromString(c3JavaScript.getText()).setRemoveTag(pretty).setWindow(getWindow()).inject();

		GWT.log("[C3Js] C3 v" + getC3Version() + " (using D3 v" + getD3Version() + ") loaded!");
	}

	private boolean isPretty(C3Resources resources) {
		return (resources instanceof PrettyC3Js.PrettyC3Resources);
	}

	private static native JavaScriptObject getWindow() /*-{ return $wnd; }-*/;

	private static native String getD3Version() /*-{ return $wnd.d3.version; }-*/;

	private static native String getC3Version() /*-{ return $wnd.c3.version; }-*/;

	protected C3Resources loadResources() {return GWT.create(C3Resources.class);}

	protected static interface C3Resources extends ClientBundle {
		@Source("c3.min.js")
		TextResource c3JavaScript();

		@Source("c3.min.css")
		TextResource c3Css();
	}
}
