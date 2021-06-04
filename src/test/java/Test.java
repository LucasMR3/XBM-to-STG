import org.junit.jupiter.api.Assertions;
import xbm.Extractor;

public class Test {

    public static void main(String[] args) {
        ExtractorDeclarationTest();
        ExtractorNameTest();
    }

    private static void ExtractorDeclarationTest() {
        Extractor extractor = new Extractor();

        Assertions.assertEquals(extractor.declarations("input prech 1"), "prech=1");
        Assertions.assertEquals(extractor.declarations("input        start          0"), "start=0");
    }

    private static void ExtractorNameTest() {
        Extractor extractor = new Extractor();
        Assertions.assertEquals("start", extractor.name("   start+           |     done+"));
        Assertions.assertEquals("done", extractor.name("     done+ | "));
        Assertions.assertEquals("Es0", extractor.name("             Es0+  |   done-"));
    }
}
