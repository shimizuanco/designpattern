package com.hakotrain.designpattern.iterator.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ BookShelfIteratorTest.class, BookShelfTest.class, BookTest.class })
public class AllTests {

}
