package org.example.restaurantkiosk.config;

import org.example.restaurantkiosk.io.InputHandler;
import org.example.restaurantkiosk.io.OutputHandler;

public class ServiceConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public ServiceConfig(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
