package stg;

import model.XBMCode;

public class Compiler {
    XBMCode x;

    public Compiler(XBMCode x) {
        this.x = x;
    }

    public void Compile(){
//        System.out.println(compiler);

        System.out.print("\ninputs ");
        for (int i = 0; i < x.inputs().size(); i++){
            System.out.print(x.inputs().get(i).getName() + " ");
        }

        System.out.print("\noutputs ");
        for (int i = 0; i < x.outputs().size(); i++){
            System.out.print(x.outputs().get(i).getName() + " ");
        }

        System.out.print("\nSTEPS\n");
        for (int i = 0; i < x.steps().size(); i++){
            System.out.println(x.steps().get(i) + " ");
//
//            String a = c.inputs().get(c.steps().get(i).getInputVarIndex()).getName() + Service.convertBoolToSymbol(c.steps().get(i).getInputVar());
//
//            System.out.println("P" + c.steps().get(i).getInStep() + " " + a);
//
//            System.out.print(a + " P" + c.steps().get(i).getGoStep());
//
//            System.out.print(a + " P" + c.steps().get(i).getGoStep());
//
//            System.out.println();
        }

        System.out.println();

    }

}
