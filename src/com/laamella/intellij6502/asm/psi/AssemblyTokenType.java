package com.laamella.intellij6502.asm.psi;

import com.intellij.psi.tree.IElementType;
import com.laamella.intellij6502.asm.AssemblyLanguage;
import org.jetbrains.annotations.*;

public class AssemblyTokenType extends IElementType {
    public AssemblyTokenType(@NotNull @NonNls String debugName) {
        super(debugName, AssemblyLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "AssemblyTokenType." + super.toString();
    }
}