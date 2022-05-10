package interfaces.impl;

import interfaces.ICalculadoraBonus;
import model.Bonus;
import model.Funcionario;

public class CalculadoraDistanciaDoTrabalho implements ICalculadoraBonus {


    @Override
    public void calculaBonus(Funcionario funcionario) {
        if (funcionario.getDistanciaDoTrablaho() <= 50)
            funcionario.setBonus(new Bonus("Distancia50km", 1.01));
        else if (funcionario.getDistanciaDoTrablaho() <= 100)
            funcionario.setBonus(new Bonus("Distancia100km", 1.03));
        else if (funcionario.getDistanciaDoTrablaho() <= 150)
            funcionario.setBonus(new Bonus("Distancia150km", 1.05));
        else if (funcionario.getDistanciaDoTrablaho() > 150)
            funcionario.setBonus(new Bonus("MaiorDistancia150km", 1.07));
    }
}
