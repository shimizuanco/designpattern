package com.hakotrain.designpattern.iterator.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ BookTest.class, BookShelfTest.class, BookShelfIteratorTest.class })
public class AllTests {

}
