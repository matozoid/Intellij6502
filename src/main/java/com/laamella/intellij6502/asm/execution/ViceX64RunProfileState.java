package com.laamella.intellij6502.asm.execution;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

public class ViceX64RunProfileState extends CommandLineState {
    private final Executor executor;

    ViceX64RunProfileState(Executor executor, ExecutionEnvironment environment) {
        super(environment);
        this.executor = executor;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        ViceX64RunConfiguration runConfiguration = (ViceX64RunConfiguration) getEnvironment().getRunProfile();
        GeneralCommandLine commandLine = new GeneralCommandLine(runConfiguration.getExecutable());
        OSProcessHandler handler = new KillableColoredProcessHandler(commandLine);
        ProcessTerminatedListener.attach(handler);
        return handler;
    }
}
