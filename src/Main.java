import models.ConversorMenu;
import models.MainMenu;
import useCases.ConverterMoeda;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        ConversorMenu conversorMenu = new ConversorMenu();
        ConverterMoeda converterMoeda = new ConverterMoeda();
        while (mainMenu.close()){
            mainMenu.generate();
            conversorMenu.generate();
            converterMoeda.executar(
                    mainMenu.getSourceCoin(),
                    mainMenu.getEndCoin(),
                    conversorMenu.getAmount()
            );
        }
    }
}
