package br.com.chronosAcademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class TesteWeb {

    @Test
    // Primeiro passo - Organizar o ambiente virtual do teste//
    // WebDriverManager é o gerenciador - ele já é uma classe
    // chromedriver é o navegador do teste, poderia ser o Firefoxdriver ou o Edgedriver por exemplo - ele já é o metodo, por ser statico não precisa instanciar
    // setup é para organizar o ambiente do teste
    public void primeiroTeste(){
        WebDriverManager.chromedriver().setup();
        // Agora tem que criar o objeto//
        // ChromeDriver é a classe//
        // driver é o objeto que vai ser instanciado e vai virar o novo objeto ChromeDriver
        ChromeDriver driver;
        driver = new ChromeDriver();
        // após executar o teste o chrome foi aberto, porem a janela estava reduzida no seu tamanho, para resolver isso
        // é preciso alterar a configuração de tela
        // driver sempre sera chamado para realizar alteracoes em tela
        // maneger é o gerenciador que tbm deve ser chamado//
        // maximize é para almentar p tamanho da tela
        driver.manage().window().maximize();
        driver.get("https://www.chronosacademy.com.br");
        // agora ele vai abrir o navegador chrome, vai maximizar a tela e vai consultar (get) o site
        String xpathTitulo = "/html/body/div/div/div/div/div/section[2]/div[3]/div/div/div/div/div[1]/div/h4";
        // a ideia é validar o texto do site (Porque tempo é conhecimento) então o xpath foi capturado através do Inspecionar no site
        // ele foi guardado em uma string, mas ainda não da para fazer nada com apenas o caminho, é preciso buscar o elemento na tela
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        // WebElement é chamado com o nome escolhido pelo Adam para buscar o titulo
        // driver vai fazer a busca no site
        // find.Element vai encontar o elemento na página
        // By.xpath esta dizendo que é através do xpath e o que foi passado no parametro é a variavel que guardou o caminho
        String titulo = txtTitulo.getText();
        // agora podemos comparar se no caminho tem realmente o texto correto
        // String é o tipo da classe
        // titulo é o nome do objeto do teste
        // txtTitulo é o objeto que já esta criado, aqui ele é chamado novamente para compor a busca da consulta do texto (getText)
        assertEquals("Porque Tempo É Conhecimento" , titulo); // assertEquals faz a comparação do texto com o titulo

        driver.close(); // close fecha o navegador no final do teste para não deixar abas abertas


    }
}
