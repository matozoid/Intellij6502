package com.laamella.intellij6502.asm.execution;

import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.DefaultProgramRunner;
import org.jetbrains.annotations.NotNull;

public class ViceX64Runner extends DefaultProgramRunner {
    @NotNull
    @Override
    public String getRunnerId() {
        return "vice-x64-program-runner";
    }

    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        return profile instanceof ViceX64RunConfiguration &&
                executorId.equals(DefaultRunExecutor.EXECUTOR_ID);
//                        executorId.equals(DefaultDebugExecutor.EXECUTOR_ID));
    }
}
