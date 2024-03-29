/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.Modelo.Computer;
import tutoria.Interface.InterfaceComputer;

/**
 *
 * @author USUARIO
 */
@Repository
public class ComputerRepositorio {
      @Autowired
    private InterfaceComputer crud;
    

    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();       
    }
    
    public Optional <Computer> getComputer(int id){
        return crud.findById(id);
    }
    
    public Computer save(Computer computer){
        return crud.save(computer);
    }
     public void delete(Computer computer){
        crud.delete(computer);
    }

   
    
}
