package com.hakotrain.designpattern.iterator;

public record Book(String name) {
	
	public Book {
		boolean isIllegalArg = false;
		
		// nameにnullは設定できない
		if(name == null) {
			isIllegalArg = true;
		}
		
		// nameに空文字列は設定できない
		if(name != null && "".equals(name)) {
			isIllegalArg = true;
		}
		
		if(isIllegalArg) {
			throw new IllegalArgumentException("Bookの名前(name)に「" + name + "」は指定できません");
		}
	}
}
