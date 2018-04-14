package com.laamella.intellij6502.asm;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleBuilderListener;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.jetbrains.annotations.NotNull;

public class AssemblyModuleBuilder extends ModuleBuilder implements ModuleBuilderListener {
    public AssemblyModuleBuilder() {
    }

    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {

    }

    @Override
    public ModuleType getModuleType() {
        return AssemblyModule.INSTANCE;
    }

    @Override
    public void moduleCreated(@NotNull Module module) {
        // post setup
    }
}
