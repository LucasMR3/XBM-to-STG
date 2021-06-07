package model;

import java.util.List;

public class Step {
    private final int inStep;
    private final int goStep;

    private final List<VarXBM> inXBMStep;
    private final List<VarXBM> outXBMStep;

    public Step(int inStep, int goStep, List<VarXBM> inXBMStep, List<VarXBM> outXBMStep) {
        this.inStep = inStep;
        this.goStep = goStep;
        this.inXBMStep = inXBMStep;
        this.outXBMStep = outXBMStep;
    }

//    public int getInStep() {
//        return inStep;
//    }
//
//    public int getGoStep() {
//        return goStep;
//    }

    public List<VarXBM> getInXBMStep() {
        return inXBMStep;
    }

    public List<VarXBM> getOutXBMStep() {
        return outXBMStep;
    }

    @Override
    public String toString() {
        return "Step{" +
                "inStep=" + inStep +
                ", goStep=" + goStep +
                ", inXBMStep=" + inXBMStep +
                ", outXBMStep=" + outXBMStep +
                '}';
    }
}
