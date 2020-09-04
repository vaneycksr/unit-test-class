package net.diegoquirino.calculadora;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "net.diegoquirino.calculadora.model",
        "net.diegoquirino.calculadora.service",
        "net.diegoquirino.calculadora.controller",
})
@IncludeTags("all")
//@ExcludeTags("")
public class RunAllTestSuite {
}
