package dev.java10x.CadastroDeNinjas.Missoes;

//LOCALHOST:8080

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    };

    @PutMapping("/alterar")

}
