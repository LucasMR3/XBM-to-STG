import model.VarXBM;
import org.junit.jupiter.api.Assertions;
import xbm.Extractor;

public class Test {

    public static void main(String[] args) {
        ExtractorDeclarationTest();
    }

    private static void ExtractorDeclarationTest() {
        Assertions.assertEquals(Extractor.declarations("input prech 1"), new VarXBM("prech", false));
        Assertions.assertEquals(Extractor.declarations("input        start          0"), new VarXBM("start", false));
    }
}
