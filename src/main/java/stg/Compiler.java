package stg;

import model.VarXBM;
import model.XBMCode;
import service.WriteFile;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private final XBMCode x;
    private final String fileName;

    List<String> toWrite = new ArrayList<>();

    int places = -1;
    String last = null;

    public Compiler(XBMCode x, String fileName) {
        this.x = x;
        this.fileName = fileName;
    }

    public void Compile() {
        printAndWrite("\n.inputs ");
        for (int i = 0; i < x.inputs().size(); i++) {
            printAndWrite(x.inputs().get(i).getName() + " ");
        }

        printAndWrite("\n.outputs ");
        for (int i = 0; i < x.outputs().size(); i++) {
            printAndWrite(x.outputs().get(i).getName() + " ");
        }

        printAndWrite("\n.graph\n");

        boolean hasConcurrence = false;

        if (x.steps().get(0).getInXBMStep().size() == 1 && x.steps().get(0).getOutXBMStep().size() == 1) {

            for (int i = 0; i < x.steps().size(); i++) {
                places++;
                if (last != null) {
                    printAndWritePlus(last + " p" + places + " ");
                    printAndWritePlus("p" + places + " " + x.steps().get(i).getInXBMStep().get(0));
                } else {
                    printAndWrite("p" + places + " ");
                    printAndWritePlus(x.steps().get(i).getInXBMStep().get(0) + "");
                }
                last = String.valueOf(x.steps().get(i).getInXBMStep().get(0));

                places++;
                printAndWritePlus(last + " p" + places + " ");
                printAndWritePlus("p" + places + " " + x.steps().get(i).getOutXBMStep().get(0));
                last = String.valueOf(x.steps().get(i).getOutXBMStep().get(0));

                if (x.steps().size() == i + 1) {
                    printAndWritePlus(last + " p" + 0 + " ");
                }
            }
        } else {
            resolveConcurrence();
            hasConcurrence = true;
        }

        if (!hasConcurrence) {
            printAndWritePlus(".marking {p0} ");
        } else
            resolveMarking();

        printAndWritePlus(".end");

        WriteFile.write(fileName, toWrite);
    }

    int p = 0;

    private void resolveConcurrence() {
        for (VarXBM varXBM : x.steps().get(0).getInXBMStep()) {
            printAndWrite(varXBM + " ");
            for (VarXBM varXBMOut : x.steps().get(0).getOutXBMStep()) {
                p++;
                printAndWrite("p" + p + " ");
            }
            printAndWritePlus("");
        }

        for (int i = p - (x.steps().get(0).getInXBMStep().size() * x.steps().get(0).getOutXBMStep().size()) + 1; i < p; i++) {
            printAndWritePlus("p" + i + " " + x.steps().get(0).getOutXBMStep().get(0));
            i++;
            printAndWritePlus("p" + i + " " + x.steps().get(0).getOutXBMStep().get(1));
        }


        for (VarXBM varXBM : x.steps().get(0).getOutXBMStep()) {
            printAndWrite(String.valueOf(varXBM));
            p++;
            printAndWrite(" p" + p);
            p++;
            printAndWrite(" p" + p + '\n');
        }

        for (int i = p - (x.steps().get(1).getInXBMStep().size() * x.steps().get(1).getOutXBMStep().size()) + 1; i < p; i++) {
            printAndWritePlus("p" + i + " " + x.steps().get(1).getInXBMStep().get(0));
            i++;
            printAndWritePlus("p" + i + " " + x.steps().get(1).getInXBMStep().get(1));
        }

        p += x.steps().get(1).getInXBMStep().size() * x.steps().get(1).getOutXBMStep().size();

        for (int i = p - (x.steps().get(1).getInXBMStep().size() * x.steps().get(1).getOutXBMStep().size()) + 1; i < p; i++) {
            printAndWritePlus(x.steps().get(1).getInXBMStep().get(0) + " p" + i);
            i++;
            printAndWritePlus(x.steps().get(1).getInXBMStep().get(1) + " p" + i);
        }

        for (int i = p - (x.steps().get(1).getInXBMStep().size() * x.steps().get(1).getOutXBMStep().size()) + 1; i < p; i++) {
            printAndWritePlus("p" + i + " " + x.steps().get(1).getOutXBMStep().get(0));
            i++;
            printAndWritePlus("p" + i + " " + x.steps().get(1).getOutXBMStep().get(1));
        }

        for (VarXBM varXBM : x.steps().get(1).getOutXBMStep()) {
            printAndWrite(varXBM + " ");
            for (VarXBM varXBMOut : x.steps().get(1).getInXBMStep()) {
                p++;
                printAndWrite("p" + p + " ");
            }
            printAndWritePlus("");
        }

        for (int i = p - (x.steps().get(1).getInXBMStep().size() * x.steps().get(1).getOutXBMStep().size()) + 1; i < p; i++) {
            printAndWritePlus("p" + i + " " + x.steps().get(0).getInXBMStep().get(0));
            i++;
            printAndWritePlus("p" + i + " " + x.steps().get(0).getInXBMStep().get(1));
        }
    }

    private void resolveMarking() {
        printAndWrite(".marking{");
        for (int i = p - (x.steps().get(1).getInXBMStep().size() * x.steps().get(1).getOutXBMStep().size()) + 1; i < p; i++) {
            printAndWrite(" p" + i + " ");
            i++;
            printAndWrite(" p" + i + " ");
        }
        printAndWritePlus("}");
    }

    private void printAndWrite(String line){
        System.out.print(line);
        toWrite.add(line);
    }

    private void printAndWritePlus(String line){
        System.out.print(line + "\n");
        toWrite.add(line + "\n");
    }
}
