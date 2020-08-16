package br.unipe.allsolution.calculadoradedescontos;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "br.unipe.allsolution.calculadoradedescontos.model",
        "br.unipe.allsolution.calculadoradedescontos"
})

@IncludeTags("ClienteB")
public class SuiteTipoClienteB {
}