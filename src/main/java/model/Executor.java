package model;

import java.util.List;

public class Executor {

    private final List<VarXBM> inputs;
    private final List<VarXBM> outputs;

    private final List<Step> steps;

    public Executor(List<VarXBM> inputs, List<VarXBM> outputs, List<Step> steps) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.steps = steps;
    }

    public List<VarXBM> getInputs() {
        return inputs;
    }

    public List<VarXBM> getOutputs() {
        return outputs;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
