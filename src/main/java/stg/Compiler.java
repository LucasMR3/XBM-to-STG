package stg;

import model.XBMCode;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    XBMCode x;
    String fileName;

    public Compiler(XBMCode x, String fileName) {
        this.x = x;
        this.fileName = fileName;
    }

    public void Compile() {
        List<String> toWrite = new ArrayList<>();
//        System.out.println(compiler);

        System.out.print("\n.inputs ");
        toWrite.add(".inputs ");
        for (int i = 0; i < x.inputs().size(); i++) {
            System.out.print(x.inputs().get(i).getName() + " ");
            toWrite.add(x.inputs().get(i).getName() + " ");
        }

        System.out.print("\n.outputs ");
        toWrite.add("\n.outputs ");
        for (int i = 0; i < x.outputs().size(); i++) {
            System.out.print(x.outputs().get(i).getName() + " ");
            toWrite.add(x.outputs().get(i).getName() + " ");
        }

        System.out.print("\n.graph\n");
        toWrite.add("\n.graph\n");

//        System.out.print("\n\nSTEPS\n");

        int places = -1;
        String last = null;

        for (int i = 0; i < x.steps().size(); i++) {
//            System.out.println(x.steps().get(i) + " ");

            for (int j = 0; j < x.steps().get(i).getInXBMStep().size(); j++) {
                places++;
                if (last != null) {
                    System.out.println(last + " p" + places + " ");
                    toWrite.add(last + " p" + places + "\n");
                    System.out.println("p" + places + " " + x.steps().get(i).getInXBMStep().get(j));
                    toWrite.add("p" + places + " " + x.steps().get(i).getInXBMStep().get(j) + '\n');
                    last = String.valueOf(x.steps().get(i).getInXBMStep().get(j));
                } else {
                    System.out.print("p" + places + " ");
                    toWrite.add("p" + places + " ");
                    System.out.println(x.steps().get(i).getInXBMStep().get(j) + "");
                    toWrite.add(x.steps().get(i).getInXBMStep().get(j) + "\n");
                    last = String.valueOf(x.steps().get(i).getInXBMStep().get(j));
                }
            }
            for (int h = 0; h < x.steps().get(h).getOutXBMStep().size(); h++) {
                places++;
                System.out.println(last + " p" + places + " ");
                toWrite.add(last + " p" + places + " " + '\n');
                System.out.println("p" + places + " " + x.steps().get(i).getOutXBMStep().get(h));
                toWrite.add("p" + places + " " + x.steps().get(i).getOutXBMStep().get(h) + '\n');
                last = String.valueOf(x.steps().get(i).getOutXBMStep().get(h));

                if (x.steps().size() == i + 1) {
                    System.out.println(last + " p" + 0 + " ");
                    toWrite.add(last + " p" + 0 + "\n");
                }
            }
//                System.out.println(last);
            System.out.println();
        }

        System.out.println(".marking {p0} ");
        toWrite.add(".marking {p0} \n");

        System.out.println(".end");
        toWrite.add(".end");

        WriteFile.write(fileName, toWrite);
    }

    private void dealConcurrence() {

    }

}
