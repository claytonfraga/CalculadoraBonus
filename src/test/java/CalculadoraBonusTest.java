/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import interfaces.impl.CalculadoraBonusBom;
import interfaces.impl.CalculadoraBonusExcelente;
import interfaces.impl.CalculadoraBonusRuim;
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
    public void calculaBonusBomTest() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);


        funcionario.calculadoraSalario(new CalculadoraBonusBom());

        double valorTotalSalarioEsperado = 3780.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Testa o salário calculado com bonus do tipo Excelente")
    @Test
    public void calculaBonusExcelenteTest() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);


        funcionario.calculadoraSalario(new CalculadoraBonusExcelente());

        double valorTotalSalarioEsperado = 4320.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Testa o salário calculado com bonus do tipo Ruim")
    @Test
    public void calculaBonusRuimTest() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);

        funcionario.calculadoraSalario(new CalculadoraBonusRuim());
        double valorTotalSalarioEsperado = 3600.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Testa o salário calculado com bônus de distância do Trabalho")
    @Test
    public void calculaBonusDistanciaDoTrabalhoTest() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);

        funcionario.setDistanciaDoTrablaho(20);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());
        double valorTotalSalarioEsperado = 3636.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }    

    @DisplayName("Testa o salário calculado com bônus de distância do Trabalho > 150")
    @Test
    public void calculaBonusDistanciaDoTrabalhoAcima150Test() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);

        funcionario.setDistanciaDoTrablaho(220);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());
        double valorTotalSalarioEsperado = 3852.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }        

    @DisplayName("Testa o salário calculado com bônus de distância do Trabalho = 150")
    @Test
    public void calculaBonusDistanciaDoTrabalho150Test() {

        Funcionario funcionario = new Funcionario("Fulano", 3600.00);

        funcionario.setDistanciaDoTrablaho(150);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());
        double valorTotalSalarioEsperado = 3780.00;


        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }        
}