package service;

import model.Prouduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProuductRepo;

import java.util.List;

@Service
public class ProuductService {
    @Autowired
    ProuductRepo prouductRepo;

    public void save(Prouduct prouduct){
        prouductRepo.save(prouduct);
    }

    public List<Prouduct> getAll(){
        return prouductRepo.getAll();
    }

    public Prouduct findByName(String name){
        return prouductRepo.findByName(name);
    }
}
