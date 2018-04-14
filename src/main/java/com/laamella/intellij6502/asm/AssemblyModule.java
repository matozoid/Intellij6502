package com.laamella.intellij6502.asm;

import com.intellij.openapi.module.ModuleType;
import com.laamella.intellij6502.Intellij6502Icons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AssemblyModule extends ModuleType<AssemblyModuleBuilder> {
    public static final ModuleType INSTANCE = new AssemblyModule();

    public AssemblyModule() {
        super("assembly-module");
    }

    @NotNull
    @Override
    public AssemblyModuleBuilder createModuleBuilder() {
        return new AssemblyModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "Assembly module";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "6510 assembly module";
    }

    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return Intellij6502Icons.INSTANCE.getFILE();
    }
}
