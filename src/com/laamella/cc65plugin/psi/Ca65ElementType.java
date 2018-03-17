package com.laamella.cc65plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.laamella.cc65plugin.Ca65Language;
import org.jetbrains.annotations.*;

public class Ca65ElementType extends IElementType {
    public Ca65ElementType(@NotNull @NonNls String debugName) {
        super(debugName, Ca65Language.INSTANCE);
    }
}