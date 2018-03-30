package com.laamella.intellij6502.asm.psi;

import com.intellij.psi.tree.IElementType;
import com.laamella.intellij6502.asm.AssemblyLanguage;
import org.jetbrains.annotations.*;

public class AssemblyElementType extends IElementType {
    public AssemblyElementType(@NotNull @NonNls String debugName) {
        super(debugName, AssemblyLanguage.INSTANCE);
    }
}