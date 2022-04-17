package br.com.chronosAcademy.automacaoWeb;

//Primeiro teste automatizado do curso, primeira amostra de uma automação//

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.pages.CursoPage;
import br.com.chronosAcademy.pages.PrincipalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class TesteWeb {
    WebDriver driver;// para ficar visível para todos os metodos
    Driver driverWeb ;
    PrincipalPage principalPage;
    CursoPage cursoPage;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("Chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }
    @Test
    public void primeiroTeste(){
        assertEquals("Porque Tempo É Conhecimento" , principalPage.getTitulo()); // assertEquals faz a comparação do texto com o titulo
    }
    @Test
    public void segundoTeste(){
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();
        assertEquals("Conheça todos os nossos cursos", cursoPage.getTitulo2());
    }
    @After
    public void finalizaTeste(){
        driver.quit();
    }
}
