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
package com.github.gwtc3.api;

import com.google.gwt.core.client.*;

import java.util.Date;

/**
 */
public class AbstractJavaScriptObject extends JavaScriptObject {
	protected AbstractJavaScriptObject() {
	}

	public final void set(Entry... entries) {
		for (Entry entry : entries) {
			set(entry.getKey(), entry.getValue());
		}
	}

	protected final void set(String prefix, Entry... entries) {
		set(prefix, create());
		for (Entry entry : entries) {
			set(prefix, entry.getKey(), entry.getValue());
		}
	}

	protected final native void set(String object, String key, JavaScriptObject value) /*-{ this[object][key] = value; }-*/;

	public final native void set(String key, JavaScriptObject value) /*-{ this[key] = value; }-*/;

	public static Date cast(JsDate value) {
		return new Date((long)value.getTime());
	}

	public static native JavaScriptObject cast(Date value) /*-{ return value; }-*/;

	public static native JavaScriptObject cast(String value) /*-{ return value; }-*/;

	public static <T extends JavaScriptObject> T create(Class<T> tClass) {
		return create();
	}

	public static <T extends JavaScriptObject> T create() {
		return JavaScriptObject.createObject().cast();
	}

	public static JsArrayMixed numberArray(String label, double... numbers) {
		JsArrayMixed jsArray = JsArrayMixed.createArray(numbers.length + 1).cast();
		jsArray.set(0, label);
		for (int i = 1; i < numbers.length + 1; i++) {
			jsArray.set(i, numbers[i - 1]);
		}

		return jsArray;
	}

	public static JsArrayNumber numberArray(double... numbers) {
		JsArrayNumber jsArray = JsArrayNumber.createArray(numbers.length).cast();
		for (int i = 0; i < numbers.length; i++) {
			jsArray.set(i, numbers[i]);
		}

		return jsArray;
	}

	public static JsArrayMixed integerArray(String label, int... integers) {
		JsArrayMixed jsArray = JsArrayMixed.createArray(integers.length + 1).cast();
		jsArray.set(0, label);
		for (int i = 1; i < integers.length + 1; i++) {
			jsArray.set(i, integers[i - 1]);
		}

		return jsArray;
	}

	public static JsArrayMixed integerArray(long label, int... integers) {
		JsArrayMixed jsArray = JsArrayMixed.createArray(integers.length + 1).cast();
		jsArray.set(0, label);
		for (int i = 1; i < integers.length + 1; i++) {
			jsArray.set(i, integers[i - 1]);
		}

		return jsArray;
	}

	public static JsArrayInteger integerArray(int... integers) {
		JsArrayInteger jsArray = JsArrayInteger.createArray(integers.length).cast();
		for (int i = 0; i < integers.length; i++) {
			jsArray.set(i, integers[i]);
		}

		return jsArray;
	}

	public static JsArrayString stringArray(String... strings) {
		JsArrayString jsArray = JsArrayInteger.createArray(strings.length).cast();
		for (int i = 0; i < strings.length; i++) {
			jsArray.set(i, strings[i]);
		}

		return jsArray;
	}

	@SafeVarargs
	public static <T extends JavaScriptObject> JsArray<T> array(T... javaScriptObjects) {
		JsArray<T> jsArray = JsArrayInteger.createArray(javaScriptObjects.length).cast();
		for (int i = 0; i < javaScriptObjects.length; i++) {
			jsArray.set(i, javaScriptObjects[i]);
		}

		return jsArray;
	}

	public static <E extends Enum<E>> String fromEnum(Enum<E> anEnum) {
		return anEnum.name().replace('_', '-').toLowerCase();
	}

	public static class Entry {
		private final String key;

		private final JavaScriptObject value;

		public Entry(String key, String value) {
			this(key, cast(value));
		}

		public Entry(String key, JavaScriptObject value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public JavaScriptObject getValue() {
			return value;
		}
	}
}
