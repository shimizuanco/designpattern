package com.hakotrain.designpattern.iterator;

public record Book(String name) {
	
	public Book {
		if(name == null) {
			throw new IllegalArgumentException("Bookの名前(name)にnullは指定できません");
		} else if( name.length() < 1) {
			throw new IllegalArgumentException("Bookの名前(name)に空文字列は指定できません");
		}
	}
}
