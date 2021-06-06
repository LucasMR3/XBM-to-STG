package model;

import java.util.List;

public class XBMCode {

    private final List<VarXBM> inputs;
    private final List<VarXBM> outputs;
    private final List<Step> steps;

    public XBMCode(List<VarXBM> inputs, List<VarXBM> outputs, List<Step> steps) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.steps = steps;
    }

    public List<VarXBM> inputs() {
        return inputs;
    }

    public List<VarXBM> outputs() {
        return outputs;
    }

    public List<Step> steps() {
        return steps;
    }

    @Override
    public String toString() {
        return "XBMCode{" +
                "inputs=" + inputs +
                ", outputs=" + outputs +
                ", steps=" + steps +
                '}';
    }
}
