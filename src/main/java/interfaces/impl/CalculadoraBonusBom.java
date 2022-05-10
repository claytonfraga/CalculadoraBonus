package interfaces.impl;

import interfaces.ICalculadoraBonus;
import model.Bonus;
import model.Funcionario;

public class CalculadoraBonusBom implements ICalculadoraBonus {

    @Override
    public void calculaBonus(Funcionario funcionario) {
        funcionario.setBonus(new Bonus("Bom", 1.05));
    }
}
