import com.xsdefault.cageprint.*;


public class Main {

    public static void main(String[] args) {

        /*Cage Configuration*/
        CagePrint.cageColor = Colors.BLUE;
        CagePrint.defaultTextColor = Colors.GREEN;
        //CagePrint.DrawChars = new char[]{'-', '|'};
        //CagePrint.cageSizeOffset = 0;

        /*Add Items*/
        CagePrint.addItemToDraw("Test", CagePrint.Align.MIDDLE);
        CagePrint.addItemToDraw("", CagePrint.Align.MIDDLE);

        try{
            Integer.parseInt("a");
        }catch (Exception e){
            CagePrint.addItemToDraw(e, CagePrint.Align.RIGHT,Colors.RED);
        }
        CagePrint.addItemToDraw(null, CagePrint.Align.LEFT,Colors.RED);

        /*Render Screen*/
        CagePrint.drawScreen();
        CagePrint.clearItems();
    }
}
