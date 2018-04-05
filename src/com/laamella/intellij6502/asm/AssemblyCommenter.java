package com.laamella.intellij6502.asm;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

public class AssemblyCommenter implements Commenter {
    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return ";";
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return ".comment";
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return ".endc";
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}