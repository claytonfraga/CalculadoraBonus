/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import interfaces.impl.CalculadoraBonusBom;
import interfaces.impl.CalculadoraBonusExcelente;
import interfaces.impl.CalculadoraBonusRuim;
import interfaces.impl.CalculadoraDistanciaDoTrabalho;
import model.Bonus;
import model.Funcionario;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author clayton
 */
class CalculadoraBonusTest {

    private Funcionario funcionario;

    public CalculadoraBonusTest() {

    }

    @BeforeEach
    void instanciaFuncionario() {
        funcionario = new Funcionario("Fulano", 3600.00);
    }

    @DisplayName("Testa o salário calculado com bonus do tipo Bom")
    @Test
    void calculaBonusBomTest() {

        funcionario.calculadoraSalario(new CalculadoraBonusBom());

        double valorTotalSalarioEsperado = 3780.00;
        String tipoBonusEsperado = "Bom";

        double valorTotalSalarioObtido = funcionario.getSalario();
        Bonus bonusRecebido = funcionario.getBonus();

        assertAll(
                () -> assertEquals(valorTotalSalarioEsperado, valorTotalSalarioObtido, 0.001),
                () -> assertEquals(tipoBonusEsperado, bonusRecebido.getTipo()));
        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Testa o salário calculado com bonus do Excelente")
    @Test
    void calculaBonusExcelenteTest() {

        funcionario.calculadoraSalario(new CalculadoraBonusExcelente());

        double valorTotalSalarioEsperado = 4320.00;

        String tipoBonusEsperado = "Excelente";

        double valorTotalSalarioObtido = funcionario.getSalario();
        Bonus bonusRecebido = funcionario.getBonus();

        assertAll(
                () -> assertEquals(valorTotalSalarioEsperado, valorTotalSalarioObtido, 0.001),
                () -> assertEquals(tipoBonusEsperado, bonusRecebido.getTipo()));
    }

    @DisplayName("Testa o salário calculado com bonus do tipo Ruim")
    @Test
    void calculaBonusRuimTest() {

        funcionario.calculadoraSalario(new CalculadoraBonusRuim());

        double valorTotalSalarioEsperado = 3600.00;
        String tipoBonusEsperado = "Ruim";

        double valorTotalSalarioObtido = funcionario.getSalario();
        Bonus bonusRecebido = funcionario.getBonus();

        assertAll(
                () -> assertEquals(valorTotalSalarioEsperado, valorTotalSalarioObtido, 0.001),
                () -> assertEquals(tipoBonusEsperado, bonusRecebido.getTipo()));
    }

    @DisplayName("Testa o salário calculado com bônus de distância do Trabalho")
    @Test
    void calculaBonusDistanciaDoTrabalhoTest() {

        funcionario.setDistanciaDoTrablaho(20);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());
        double valorTotalSalarioEsperado = 3636.00;

        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Testa o salário calculado com bônus de distância do Trabalho > 150")
    @Test
    void calculaBonusDistanciaDoTrabalhoAcima150Test() {

        funcionario.setDistanciaDoTrablaho(220);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());
        double valorTotalSalarioEsperado = 3852.00;

        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Testa o salário calculado com bônus de distância do Trabalho = 150")
    @Test
    void calculaBonusDistanciaDoTrabalho150Test() {

        funcionario.setDistanciaDoTrablaho(150);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());
        double valorTotalSalarioEsperado = 3780.00;

        assertEquals(valorTotalSalarioEsperado, funcionario.getSalario(), 0.001);
    }

    @DisplayName("Avaliar o funcionamento do métdo to String")
    @Test
    void calculaToStringTest() {

        funcionario.setDistanciaDoTrablaho(150);

        funcionario.calculadoraSalario(new CalculadoraDistanciaDoTrabalho());

        String funcionarioString = funcionario.toString();

        assertAll(
                () -> assertThat(funcionarioString, containsString("Fulano")),
                () -> assertThat(funcionarioString, containsString("3600")),                
                () -> assertThat(funcionarioString, containsString("3780")),                                
                () -> assertThat(funcionarioString, containsString("150")));

    }
}