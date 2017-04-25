package com.kbm.java.practise.annotations;

import java.lang.reflect.Method;

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
		Method[] annotations = person.getClass().getDeclaredMethods();
		for (Method method : annotations) {
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
			if (annotation != null) {
				System.out.println(annotation.value());
			}
		}
	}
}
