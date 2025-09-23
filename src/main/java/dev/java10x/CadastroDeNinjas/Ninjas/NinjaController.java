package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

   //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }


    //Mostrar ninja por ID(READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar o ninja por ID";
    }

   //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar o ninja por ID";
    }

    // Deleta ninja (DELETE)

    @DeleteMapping("/DeletarID")
    public String DeletarNinjaPorId(){
        return "Deletar o ninja por ID";
    }
}
