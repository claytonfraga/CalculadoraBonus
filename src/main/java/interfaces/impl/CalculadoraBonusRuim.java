package interfaces.impl;

import interfaces.ICalculadoraBonus;
import model.Bonus;
import model.Funcionario;

public class CalculadoraBonusRuim implements ICalculadoraBonus {

    @Override
    public void calculaBonus(Funcionario funcionario) {
        funcionario.setBonus(new Bonus("Ruim", 1));
    }
}
