package com.qascript.StepDefs;

import com.qascript.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass
{
    @Before
    public void setUp()
    {
        InitializeDriver();
    }

    @After
    public void tearDown()
    {
        CloseDriver();
    }
}
