/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Servicios;

import tutoria.Modelo.Computer;
import tutoria.Repositorio.ComputerRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosComputer {
        @Autowired
    private ComputerRepositorio metodosCrud;
    
    public List<Computer> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Computer> getComputer(int idComputer){
        return metodosCrud.getComputer(idComputer);
    }
    
    public Computer save(Computer computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<Computer> evt=metodosCrud.getComputer(computer.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }
    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> e=metodosCrud.getComputer(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getAddress()!=null){
                    e.get().setAddress(computer.getAddress());
                }
                if(computer.getExtension()!=null){
                    e.get().setExtension(computer.getExtension());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
