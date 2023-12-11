package com.example;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AccountSpecification.class, CustomerSpecification.class })
@IncludeTags(value = "unit")
public class AllUnitTests {

}
