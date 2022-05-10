/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import interfaces.impl.CalculadoraBonusBom;
import interfaces.impl.CalculadoraDistanciaDoTrabalho;
import model.Funcionario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author clayton
 */
public class CalculadoraBonusTest {

    public CalculadoraBonusTest() {

    }

    @DisplayName("Testa o salário calculado com bonus do tipo Bom")
    @Test
    public void calculaBonusTest() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());

        funcionario.calculadoraSalario(new CalculadoraBonusBom());

        double valorTotalSalarioEsperado = 3780.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }
}