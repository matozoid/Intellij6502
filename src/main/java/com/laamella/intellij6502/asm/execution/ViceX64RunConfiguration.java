package com.laamella.intellij6502.asm.execution;

import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ViceX64RunConfiguration extends LocatableConfigurationBase {
    private String executable;

    ViceX64RunConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    public ViceX64SettingsEditor getConfigurationEditor() {
        return new ViceX64SettingsEditor();
    }

    @Override
    public void checkConfiguration() {

    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
        return new ViceX64RunProfileState(executor, environment);
    }

    void setExecutable(String executable) {
        this.executable = executable;
    }

    String getExecutable() {
        return executable;
    }
}
