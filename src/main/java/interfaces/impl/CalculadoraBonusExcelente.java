package interfaces.impl;

import interfaces.ICalculadoraBonus;
import model.Bonus;
import model.Funcionario;

public class CalculadoraBonusExcelente implements ICalculadoraBonus {

    @Override
    public void calculaBonus(Funcionario funcionario) {
        funcionario.setBonus(new Bonus("Excelente", 1.2));
    }
}
