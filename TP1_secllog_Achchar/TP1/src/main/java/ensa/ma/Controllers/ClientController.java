package ensa.ma.Controllers;

import ensa.ma.beans.Client;
import ensa.ma.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @GetMapping("api/rest/Clients/{id}")
    public Optional<Client> getClient(@PathVariable Long id){
        return clientRepository.findById(id);
    }
    @GetMapping("/loginPage")
    public String login() {
        return "login.html";
    }
}
