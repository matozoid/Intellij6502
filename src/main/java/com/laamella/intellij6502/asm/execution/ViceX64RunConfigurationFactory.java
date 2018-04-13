package com.laamella.intellij6502.asm.execution;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

public class ViceX64RunConfigurationFactory extends ConfigurationFactory {
    protected ViceX64RunConfigurationFactory(ViceX64RunConfigurationType viceX64RunConfigurationType) {
        super(viceX64RunConfigurationType);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new ViceX64RunConfiguration(project, this, "ASM");
    }

    @Nls
    @Override
    public String getName() {
        return "Vice X64 configuration factory";
    }
}
