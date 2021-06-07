package stg;

import model.XBMCode;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    XBMCode x;

    public Compiler(XBMCode x) {
        this.x = x;
    }

    public void Compile() {
        List<String> write = new ArrayList<>();
//        System.out.println(compiler);

        System.out.print("\n.inputs ");
        for (int i = 0; i < x.inputs().size(); i++) {
            System.out.print(x.inputs().get(i).getName() + " ");
            write.add(x.inputs().get(i).getName() + " ");
        }

        System.out.print("\n.outputs ");
        for (int i = 0; i < x.outputs().size(); i++) {
            System.out.print(x.outputs().get(i).getName() + " ");
            write.add(x.outputs().get(i).getName() + " ");
        }

        System.out.print("\n.graph\n");
        write.add("\n.graph\n");

//        System.out.print("\n\nSTEPS\n");

        int places = -1;
        String last = null;

        for (int i = 0; i < x.steps().size(); i++) {
//            System.out.println(x.steps().get(i) + " ");

            for (int j = 0; j < x.steps().get(i).getInXBMStep().size(); j++) {
                places++;
                if (last != null) {
                    System.out.println(last + " p" + places + " ");
                    System.out.println("p" + places + " " + x.steps().get(i).getInXBMStep().get(j));
                    last = String.valueOf(x.steps().get(i).getInXBMStep().get(j));
                } else {
                    System.out.print("p" + places + " ");
                    System.out.println(x.steps().get(i).getInXBMStep().get(j) + " ");
                    last = String.valueOf(x.steps().get(i).getInXBMStep().get(j));
                }
            }
                for (int h = 0; h < x.steps().get(h).getOutXBMStep().size(); h++) {
                    places++;
                    System.out.println(last + " p" + places + " ");
                    System.out.println("p" + places + " " + x.steps().get(i).getOutXBMStep().get(h));
                    last = String.valueOf(x.steps().get(i).getOutXBMStep().get(h));

                    if (x.steps().size() == i + 1){
                        System.out.println(last + " p" + 0 + " ");
                    }
                }
//                System.out.println(last);
            System.out.println();
        }

        System.out.println(".marking {p0} ");
        System.out.println(".end");

        System.out.println();


        WriteFile.write("file", write);

    }

    private void dealConcurrence() {

    }

}
