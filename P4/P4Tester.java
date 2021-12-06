/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar P4Tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar P4Tester        # run tests
 */
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class P4Tester {
  public static void main(String args[]){
      org.junit.runner.JUnitCore.main("P4Tester");
    }
     
  private final double ERR = 0.00001;
        
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  P4Tester %%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Test(timeout=1000) public void ClothingException_Class_00() {
        ClothingException e = new ClothingException();
        assertNull("Incorrect default error message", e.getMessage());
    }
    @Test(timeout=1000) public void ClothingException_Class_01() {
        ClothingException e = new ClothingException("invalid input");
        assertEquals("Incorrect error message", "invalid input", e.getMessage());
    }
    @Test(timeout=1000) public void ClothingException_Class_02() {
        Object o = new ClothingException();
        assertTrue("ClothingException should be an Exception", o instanceof Exception);
        assertFalse("ClothingException should not be a RuntimeException", o instanceof RuntimeException);
    }

    @Test(timeout=1000) public void Graphic_Class_00() {
        Graphic g = new Graphic("a", "b");
        assertEquals("Error in Graphic class constructor", "a", g.getStyle());
        assertEquals("Error in Graphic class constructor", "b", g.getDescription());
    }
    @Test(timeout=1000) public void Graphic_Class_01() {
        Graphic g = new Graphic("", "");
        g.setStyle("a");
        g.setDescription("b");
        assertEquals("Error in Graphic class setter", "a", g.getStyle());
        assertEquals("Error in Graphic class setter", "b", g.getDescription());
    }

    @Test(timeout=1000) public void GraphicTShirt_Class_00() {
        Graphic g = new Graphic("", "");
        Object o = new GraphicTshirt(g, 0, "");
        assertTrue("GraphicTShirt should extend Tops", o instanceof Tops);
        assertTrue("GraphicTShirt should be Clothing", o instanceof Clothing);
        assertFalse("GraphicTShirt should not extend Pants", o instanceof Pants);
    }
    @Test(timeout=1000) public void GraphicTShirt_Class_01() {
        String msg = "Error in GraphicTshirt class";
        Graphic g = new Graphic("a", "b");
        GraphicTshirt obj = new GraphicTshirt(g, 10, "c");
        assertEquals(msg, "Graphic T-Shirt", obj.getType());
        assertEquals(msg, 10, obj.getSize());
        assertEquals(msg, "c", obj.getColor());
        String expected = "Type: Graphic T-Shirt Size: 10 Color: c Graphic Style: a Graphic Description: b";
        assertEquals(msg, expected, obj.toString());
    }

    @Test(timeout=1000) public void Sweater_Class_00() {
        Object o = new Sweater(SWEATERTYPE.Shrug, 0, "");
        assertTrue("Sweater should extend Tops", o instanceof Tops);
        assertTrue("Sweater should be Clothing", o instanceof Clothing);
        assertFalse("Sweater should not extend Pants", o instanceof Pants);
    }
    @Test(timeout=1000) public void Sweater_Class_01() {
        String msg = "Error in Sweater class";
        Sweater obj = new Sweater(SWEATERTYPE.Shrug, 33, "c");
        assertEquals(msg, "Sweater(Shrug)", obj.getType());
        assertEquals(msg, 33, obj.getSize());
        assertEquals(msg, "c", obj.getColor());
        String expected = "Type: Sweater(Shrug) Size: 33 Color: c";
        assertEquals(msg, expected, obj.toString());
    }

    @Test(timeout=1000) public void TankTop_Class_00() {
        Object o = new TankTop("", 0, "");
        assertTrue("TankTop should extend Tops", o instanceof Tops);
        assertTrue("TankTop should be Clothing", o instanceof Clothing);
        assertFalse("TankTop should not extend Pants", o instanceof Pants);
    }
    @Test(timeout=1000) public void TankTop_Class_01() {
        String msg = "Error in TankTop class";
        TankTop obj = new TankTop("w", 22, "b");
        assertEquals(msg, "Tank Top", obj.getType());
        assertEquals(msg, 22, obj.getSize());
        assertEquals(msg, "b", obj.getColor());
        String expected = "Type: Tank Top Size: 22 Color: b Strap Type: w";
        assertEquals(msg, expected, obj.toString());
    }

    @Test(timeout=1000) public void Jeans_Class_00() {
        Object o = new Jeans(0, "", JEANFIT.Skinny);
        assertTrue("Jeans should extend Pants", o instanceof Pants);
        assertTrue("Jeans should be Clothing", o instanceof Clothing);
        assertTrue("Jeans should be Bottoms", o instanceof Bottoms);
        assertFalse("Jeans should not extend Tops", o instanceof Tops);
    }
    @Test(timeout=1000) public void Jeans_Class_01() {
        String msg = "Error in Jeans class";
        Jeans obj = new Jeans(21, "blue", JEANFIT.Skinny);
        assertEquals(msg, "Jeans", obj.getType());
        assertEquals(msg, 21, obj.getSize());
        assertEquals(msg, "blue", obj.getColor());
        assertEquals(msg, "Skinny", obj.getFit());
        String expected = "Type: Jeans Size: 21 Color: blue Fit: Skinny";
        assertEquals(msg, expected, obj.toString());
    }

    @Test(timeout=1000) public void Legging_Class_00() {
        Object o = new Legging(0, "", "");
        assertTrue("Legging should extend Pants", o instanceof Pants);
        assertTrue("Legging should be Clothing", o instanceof Clothing);
        assertTrue("Legging should be Bottoms", o instanceof Bottoms);
        assertFalse("Legging should not extend Tops", o instanceof Tops);
    }
    @Test(timeout=1000) public void Legging_Class_01() {
        String msg = "Error in Legging class";
        Legging obj = new Legging(1, "c", "Skinny");
        assertEquals(msg, "Legging", obj.getType());
        assertEquals(msg, 1, obj.getSize());
        assertEquals(msg, "c", obj.getColor());
        assertEquals(msg, "Skinny", obj.getFit());
        String expected = "Type: Legging Size: 1 Color: c Fit: Skinny";
        assertEquals(msg, expected, obj.toString());
    }

    @Test(timeout=1000) public void Shorts_Class_00() {
        Object o = new Shorts(0, "", "");
        assertTrue("Shorts should extend Pants", o instanceof Pants);
        assertTrue("Shorts should be Clothing", o instanceof Clothing);
        assertTrue("Shorts should be Bottoms", o instanceof Bottoms);
        assertFalse("Shorts should not extend Tops", o instanceof Tops);
    }
    @Test(timeout=1000) public void Shorts_Class_01() {
        String msg = "Error in Shorts class";
        Shorts obj = new Shorts(2, "c", "f");
        assertEquals(msg, "Shorts", obj.getType());
        assertEquals(msg, 2, obj.getSize());
        assertEquals(msg, "c", obj.getColor());
        assertEquals(msg, "f", obj.getFit());
        String expected = "Type: Shorts Size: 2 Color: c Fit: f";
        assertEquals(msg, expected, obj.toString());
    }


    @Test(timeout=1000) public void SweaterType_Enum() {
        String msg = "Error in SWEATERTYPE enum";
        ArrayList<SWEATERTYPE> ExpectedTypes = new ArrayList<SWEATERTYPE>();
        ExpectedTypes.add(SWEATERTYPE.Cardigan);
        ExpectedTypes.add(SWEATERTYPE.Pullover);
        ExpectedTypes.add(SWEATERTYPE.Shrug);

        ArrayList<SWEATERTYPE> ActualTypes = new ArrayList<SWEATERTYPE>();
        for(SWEATERTYPE e : SWEATERTYPE.values()){
            ActualTypes.add(e);
        }

        assertArrayEquals(msg, ExpectedTypes.toArray(), ActualTypes.toArray());
    }
    @Test(timeout=1000) public void JeanFit_Enum() {
        String msg = "Error in JEANFIT enum";
        ArrayList<JEANFIT> ExpectedTypes = new ArrayList<JEANFIT>();
        ExpectedTypes.add(JEANFIT.Skinny);
        ExpectedTypes.add(JEANFIT.Straight);
        ExpectedTypes.add(JEANFIT.Bootcut);

        ArrayList<JEANFIT> ActualTypes = new ArrayList<JEANFIT>();
        for(JEANFIT e : JEANFIT.values()){
            ActualTypes.add(e);
        }

        assertArrayEquals(msg, ExpectedTypes.toArray(), ActualTypes.toArray());
    }

    @Test(timeout=1000) public void Label_Class_00() {
        String msg = "Error in Label class";
        Label<String, String> obj = new Label<String, String>("a", "b");
        assertEquals(msg, "a", obj.getKey());
        assertEquals(msg, "b", obj.getValue());
    }
    @Test(timeout=1000) public void Label_Class_01() {
        String msg = "Error in Label class";
        Label<Double, Double> obj = new Label<Double, Double>(3.4, 5.5);
        double key = obj.getKey();
        double value = obj.getValue();
        assertEquals(msg, 3.4, key, 0.0);
        assertEquals(msg, 5.5, value, 0.0);
    }
    @Test(timeout=1000) public void Label_Class_02() {
        String msg = "Error in Label class";
        Label<String, Integer> obj = new Label<String, Integer>("", 0);
        obj.setKey("word");
        obj.setValue(222);
        assertEquals(msg, "word", obj.getKey());
        assertEquals(msg, 222, (int)obj.getValue());
    }
    @Test(timeout=1000) public void Label_Class_03() {
        String msg = "Error in Label class";
        Clothing item = new Legging(11, "blue", "capri");
        Label<String, Clothing> obj = new Label<String, Clothing>("Legging", item);
        assertEquals(msg, "Legging", obj.getKey());
        assertEquals(msg, item, obj.getValue());
    }

    @Test(timeout=1000) public void InsideCloset_Class_00() {
        String msg = "Error in InsideCloset class, printWholeCloset()";
        InsideCloset closet = new InsideCloset("inputData.csv");
        String expected = "Type: Shorts Size: 13 Color: white black Fit: jegging\n"+
        "Type: Graphic T-Shirt Size: 12 Color: white burgundy Graphic Style: art and design Graphic Description: skull\n"+
        "Type: Tank Top Size: 12 Color: white black Strap Type: wide strap\n"+
        "Type: Graphic T-Shirt Size: 11 Color: black white Graphic Style: music Graphic Description: joan jett\n"+
        "Type: Graphic T-Shirt Size: 10 Color: light blue dark blue Graphic Style: pop culture Graphic Description: little mermaid\n"+
        "Type: Tank Top Size: 13 Color: red blue white Strap Type: spaghetti\n"+
        "Type: Legging Size: 12 Color: gold black Fit: crop\n"+
        "Type: Tank Top Size: 12 Color: white Strap Type: halter\n"+
        "Type: Jeans Size: 11 Color: light blue Fit: Straight\n"+
        "Type: Shorts Size: 11 Color: dark blue Fit: boyfriend\n"+
        "Type: Sweater(Cardigan) Size: 13 Color: blue white\n"+
        "Type: Graphic T-Shirt Size: 13 Color: white purple yellow Graphic Style: pop culture Graphic Description: golden girls\n"+
        "Type: Sweater(Shrug) Size: 13 Color: black orange green blue\n"+
        "Type: Jeans Size: 13 Color: dark blue Fit: Skinny\n"+
        "Type: Sweater(Pullover) Size: 12 Color: yellow blue\n"+
        "Type: Jeans Size: 13 Color: white Fit: Bootcut\n"+
        "Type: Legging Size: 10 Color: black white Fit: full length\n"+
        "Type: Shorts Size: 12 Color: blue Fit: skinny\n";
        setCapture();
        closet.printWholeCloset();
        String actual = getCapture();
        assertEquals(msg, expected, actual);
        unsetCapture();
    }
    @Test(timeout=1000) public void InsideCloset_Class_01() {
        String msg = "Error in InsideCloset class, organizedCloset()";
        InsideCloset closet = new InsideCloset("inputData.csv");
        String expected = "Type: Graphic T-Shirt Size: 12 Color: white burgundy Graphic Style: art and design Graphic Description: skull\n"+
        "Type: Graphic T-Shirt Size: 11 Color: black white Graphic Style: music Graphic Description: joan jett\n"+
        "Type: Graphic T-Shirt Size: 10 Color: light blue dark blue Graphic Style: pop culture Graphic Description: little mermaid\n"+
        "Type: Graphic T-Shirt Size: 13 Color: white purple yellow Graphic Style: pop culture Graphic Description: golden girls\n"+
        "Type: Jeans Size: 11 Color: light blue Fit: Straight\n"+
        "Type: Jeans Size: 13 Color: dark blue Fit: Skinny\n"+
        "Type: Jeans Size: 13 Color: white Fit: Bootcut\n"+
        "Type: Legging Size: 12 Color: gold black Fit: crop\n"+
        "Type: Legging Size: 10 Color: black white Fit: full length\n"+
        "Type: Shorts Size: 13 Color: white black Fit: jegging\n"+
        "Type: Shorts Size: 11 Color: dark blue Fit: boyfriend\n"+
        "Type: Shorts Size: 12 Color: blue Fit: skinny\n"+
        "Type: Sweater(Cardigan) Size: 13 Color: blue white\n"+
        "Type: Sweater(Shrug) Size: 13 Color: black orange green blue\n"+
        "Type: Sweater(Pullover) Size: 12 Color: yellow blue\n"+
        "Type: Tank Top Size: 12 Color: white black Strap Type: wide strap\n"+
        "Type: Tank Top Size: 13 Color: red blue white Strap Type: spaghetti\n"+
        "Type: Tank Top Size: 12 Color: white Strap Type: halter\n";

        ArrayList<Clothing> clothes = closet.organizedCloset();
        String actual = "";
        for(int i = 0; i < clothes.size(); i++)
        {
            actual+=clothes.get(i)+"\n";
        }

        assertEquals(msg, expected, actual);
    }

    @Rule public ExpectedException cException = ExpectedException.none();
    @Test(timeout=1000) public void InsideCloset_Class_02() throws Exception {
        cException.expect(ClothingException.class);
        cException.expectMessage("invalid item");
        cException.reportMissingExceptionWithMessage("missing exception in printSpecificClothing");
        InsideCloset closet = new InsideCloset("inputData.csv");
        closet.printSpecificClothing("a");
    }

    String [] expected = new String[]{"Type: Graphic T-Shirt Size: 12 Color: white burgundy Graphic Style: art and design Graphic Description: skull\n"+
            "Type: Graphic T-Shirt Size: 11 Color: black white Graphic Style: music Graphic Description: joan jett\n"+
            "Type: Graphic T-Shirt Size: 10 Color: light blue dark blue Graphic Style: pop culture Graphic Description: little mermaid\n"+
            "Type: Graphic T-Shirt Size: 13 Color: white purple yellow Graphic Style: pop culture Graphic Description: golden girls\n",
            "Type: Jeans Size: 11 Color: light blue Fit: Straight\n"+
            "Type: Jeans Size: 13 Color: dark blue Fit: Skinny\n"+
            "Type: Jeans Size: 13 Color: white Fit: Bootcut\n",
            "Type: Legging Size: 12 Color: gold black Fit: crop\n"+
            "Type: Legging Size: 10 Color: black white Fit: full length\n",
            "Type: Shorts Size: 13 Color: white black Fit: jegging\n"+
            "Type: Shorts Size: 11 Color: dark blue Fit: boyfriend\n"+
            "Type: Shorts Size: 12 Color: blue Fit: skinny\n",
            "Type: Sweater(Cardigan) Size: 13 Color: blue white\n"+
            "Type: Sweater(Shrug) Size: 13 Color: black orange green blue\n"+
            "Type: Sweater(Pullover) Size: 12 Color: yellow blue\n",
            "Type: Tank Top Size: 12 Color: white black Strap Type: wide strap\n"+
            "Type: Tank Top Size: 13 Color: red blue white Strap Type: spaghetti\n"+
            "Type: Tank Top Size: 12 Color: white Strap Type: halter\n"};

    void TestPrintSpecificClothing(int i, String clothes) throws Exception {
        String msg = "Error in InsideCloset class, printSpecificClothing()";
        InsideCloset closet = new InsideCloset("inputData.csv");
        setCapture();
        closet.printSpecificClothing(clothes);
        String actual = getCapture();
        assertEquals(msg, expected[i], actual);
        unsetCapture();
    }

    @Test(timeout=1000) public void InsideCloset_Class_03() throws Exception {TestPrintSpecificClothing(0, "Graphic T-Shirt");}
    @Test(timeout=1000) public void InsideCloset_Class_04() throws Exception {TestPrintSpecificClothing(1, "Jeans");}
    @Test(timeout=1000) public void InsideCloset_Class_05() throws Exception {TestPrintSpecificClothing(2, "Legging");}
    @Test(timeout=1000) public void InsideCloset_Class_06() throws Exception {TestPrintSpecificClothing(3, "Shorts");}
    @Test(timeout=1000) public void InsideCloset_Class_07() throws Exception {TestPrintSpecificClothing(4, "Sweater");}
    @Test(timeout=1000) public void InsideCloset_Class_08() throws Exception  {TestPrintSpecificClothing(5, "Tank Top");}

    @Test(timeout=1000) public void InsideCloset_Class_09() throws Exception {
        cException.expect(ClothingException.class);
        cException.expectMessage("invalid item");
        cException.reportMissingExceptionWithMessage("missing exception in colorCoordinate");
        InsideCloset closet = new InsideCloset("inputData.csv");
        ArrayList<Clothing> clothes = closet.colorCoordinate("", "burgundy");
    }
    @Test(timeout=1000) public void InsideCloset_Class_10() throws Exception {
        cException.expect(ClothingException.class);
        cException.expectMessage("nothing of that color in your closet");
        cException.reportMissingExceptionWithMessage("missing exception in colorCoordinate");
        InsideCloset closet = new InsideCloset("inputData.csv");
        ArrayList<Clothing> clothes = closet.colorCoordinate("Tank Top", "teal");
    }

    String [] expCoordinate = new String[]{"Type: Jeans Size: 11 Color: light blue Fit: Straight\n" +
            "Type: Shorts Size: 11 Color: dark blue Fit: boyfriend\n" +
            "Type: Jeans Size: 13 Color: dark blue Fit: Skinny\n" +
            "Type: Shorts Size: 12 Color: blue Fit: skinny\n",
            "Type: Tank Top Size: 13 Color: red blue white Strap Type: spaghetti\n",
            "Type: Shorts Size: 13 Color: white black Fit: jegging\n"+ "Type: Jeans Size: 13 Color: white Fit: Bootcut\n"+
            "Type: Legging Size: 10 Color: black white Fit: full length\n",
            "Type: Legging Size: 12 Color: gold black Fit: crop\n",
            "Type: Tank Top Size: 12 Color: white black Strap Type: wide strap\n"+
            "Type: Graphic T-Shirt Size: 11 Color: black white Graphic Style: music Graphic Description: joan jett\n"+
            "Type: Sweater(Shrug) Size: 13 Color: black orange green blue\n",
            "Type: Sweater(Shrug) Size: 13 Color: black orange green blue\n"
    };

    void TestColorCoordinate(int k, String item, String color) throws Exception {
        String msg = "Error in InsideCloset class, colorCoordinate()";
        InsideCloset closet = new InsideCloset("inputData.csv");
        ArrayList<Clothing> clothes = closet.colorCoordinate(item, color);
        String actual = "";
        for(int i = 0; i < clothes.size(); i++)
        {
            actual+=clothes.get(i)+"\n";
        }

        assertEquals(msg, expCoordinate[k], actual);
    }

    @Test(timeout=1000) public void InsideCloset_Class_11()throws Exception  {TestColorCoordinate(0, "Tank Top", "blue");}
    @Test(timeout=1000) public void InsideCloset_Class_12()throws Exception  {TestColorCoordinate(1, "Jeans", "red");}
    @Test(timeout=1000) public void InsideCloset_Class_13()throws Exception  {TestColorCoordinate(2, "Sweater", "white");}
    @Test(timeout=1000) public void InsideCloset_Class_14()throws Exception  {TestColorCoordinate(3, "Graphic T-Shirt", "gold");}
    @Test(timeout=1000) public void InsideCloset_Class_15()throws Exception  {TestColorCoordinate(4, "Legging", "black");}
    @Test(timeout=1000) public void InsideCloset_Class_16()throws Exception  {TestColorCoordinate(5, "Shorts", "orange");}

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /** the lines below are for setting up input/output redirection so that the
      * tests can see what is being set to the screen as well as produce its own
      * pseudo-keyboard input.  No test appear below here. */
  
    static ByteArrayOutputStream localOut, localErr;
    static ByteArrayInputStream localIn;
    static PrintStream sOut, sErr;
    static InputStream sIn;

    @BeforeClass public static void setup() throws Exception {
      sOut = System.out;
      sErr = System.err;
      sIn  = System.in;
      
    }
    
    @AfterClass public static void cleanup() throws Exception {
      unsetCapture();
      unsetInput();
    }
    
    private static void setCapture() {
     localOut = new ByteArrayOutputStream();
     localErr = new ByteArrayOutputStream();
     System.setOut(new PrintStream( localOut ) );
     System.setErr(new PrintStream( localErr ) );
    }

    private static String getCapture() {
     return localOut.toString().replaceAll("\\r?\\n", "\n");
    }

    private static void unsetCapture() {
     System.setOut( null );
     System.setOut( sOut );
     System.setErr( null );
     System.setErr( sErr );
    }
    
    private static void setInput(String input) {
      localIn = new ByteArrayInputStream(input.getBytes());
      System.setIn(localIn);
    }
    
    private static void unsetInput() throws IOException {
      if (localIn != null) localIn.close();
      System.setIn( null );
      System.setIn( sIn  );
    }

   
}
