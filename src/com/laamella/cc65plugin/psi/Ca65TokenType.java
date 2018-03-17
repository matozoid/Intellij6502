package com.laamella.cc65plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.laamella.cc65plugin.Ca65Language;
import org.jetbrains.annotations.*;

public class Ca65TokenType extends IElementType {
    public Ca65TokenType(@NotNull @NonNls String debugName) {
        super(debugName, Ca65Language.INSTANCE);
    }

    @Override
    public String toString() {
        return "Ca65TokenType." + super.toString();
    }
}