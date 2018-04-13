package com.laamella.intellij6502.asm.execution;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.laamella.intellij6502.Intellij6502Icons;

public class ViceX64RunConfigurationType extends ConfigurationTypeBase {
    protected ViceX64RunConfigurationType() {
        super("vice-x64-runner", "Vice X64", "Runs the Vice x64 executable", Intellij6502Icons.INSTANCE.getFILE());
        addFactory(new ViceX64RunConfigurationFactory(this));
    }
}
