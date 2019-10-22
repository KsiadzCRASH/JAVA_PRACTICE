package com.ts.generics;

import java.lang.invoke.MethodHandle;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;



public class TypeInheritance {
	static class GenType<T> {
		List<String> bla() {
			return null;
		}

		T blabal() {
			return null;
		}
	}

		public void test(int a) throws NoSuchMethodException, IllegalAccessException {
			GenType bla1 = new GenType(); /* */
			bla1.bla().stream().filter(new Predicate<String>() {
				@Override
				public boolean test(String s) {
					return a > 0 ? aaa(s) : false;
				}
			});
			bla1.bla().stream().filter(new Predicate<String>() {
				@Override
				public boolean test(String s) {
					return dupa(s);
				}
			});/*		List bbb = new ArrayList(); Class sa  = void.class; MethodHandles.Lookup lookup = MethodHandles.lookup(); MethodHandle handle = lookup.findVirtual(GenType2.class, "dupa", MethodType.methodType(String.class));*//*	handle.bindTo()*/

			Predicate<String> zz = this::aaa;

			bla1.bla().stream().filter(zz);
			//bla1.bla().stream().filter(this::dupa);
			//bla1.bla().stream().filter(this::aaa);

			Predicate<String> p = t -> t.charAt(3) == 9;
			//Predicate z = (String t) ->( t.charAt(3) == 9);


		}

		boolean aaa(String a) {

			return true;
		}

		boolean dupa(String a) {
			return false;
		}






}
