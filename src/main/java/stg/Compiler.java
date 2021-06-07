package stg;

import model.XBMCode;

public class Compiler {
    XBMCode x;

    public Compiler(XBMCode x) {
        this.x = x;
    }

    public void Compile() {
//        System.out.println(compiler);

        System.out.print("\n.inputs ");
        for (int i = 0; i < x.inputs().size(); i++) {
            System.out.print(x.inputs().get(i).getName() + " ");
        }

        System.out.print("\n.outputs ");
        for (int i = 0; i < x.outputs().size(); i++) {
            System.out.print(x.outputs().get(i).getName() + " ");
        }

        System.out.print("\n.graph");

        System.out.print("\n\nSTEPS\n");

        int places = -1;
        String last = null;

        for (int i = 0; i < x.steps().size(); i++) {
//            System.out.println(x.steps().get(i) + " ");

            for (int j = 0; j < x.steps().get(i).getInXBMStep().size(); j++) {
                places++;
                if (last != null)
                    System.out.println(last);

                System.out.print("p" + places + " ");
                System.out.println(x.steps().get(i).getInXBMStep().get(j) + " ");
                last = String.valueOf(x.steps().get(i).getInXBMStep().get(j));

                for (int h = 0; h < x.steps().get(h).getOutXBMStep().size(); h++) {
                    places++;
                    System.out.println(last + " p" + places + " ");
//                    System.out.println("o/");
                    System.out.println(x.steps().get(i).getOutXBMStep().get(h) + " ");
                    last = String.valueOf(x.steps().get(i).getOutXBMStep().get(h));
                }
//                System.out.println(last);
            }

            System.out.println();
        }

        System.out.println();

    }

    private void dealConcurrence() {

    }

}
