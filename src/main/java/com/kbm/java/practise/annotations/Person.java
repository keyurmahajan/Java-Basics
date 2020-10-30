package com.kbm.java.practise.annotations;

import java.lang.reflect.Method;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Person {

	private String name;
	private long id;

	@MyAnnotation(value = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("ABC");
		person.setId(1);
		Method[] methods = person.getClass().getDeclaredMethods();
		for (Method method : methods) {
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
			if (annotation != null) {
				System.out.println(annotation.value());
			}

		}

	}
}
