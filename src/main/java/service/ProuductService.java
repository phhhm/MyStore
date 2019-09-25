package service;

import model.Prouduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MyProductRepository;

import java.util.List;

@Service
public class ProuductService {
    @Autowired
    MyProductRepository myProductRepository;

    public void save(Prouduct prouduct){
        myProductRepository.save(prouduct);
    }

    public List<Prouduct> getAll(){
        return myProductRepository.findAll();
    }

    public Prouduct findByName(String name){
        return myProductRepository.findByName(name);
    }
}
