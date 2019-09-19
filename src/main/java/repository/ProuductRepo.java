package repository;

import model.Prouduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProuductRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Prouduct prouduct){
        jdbcTemplate.execute(String.format("insert into prouduct(name, description) values('%s', '%s')",
                prouduct.getName(), prouduct.getDescription()));
    }

    public List<Prouduct> getAll(){
        String query = "select * from prouduct";
        List<Prouduct> prouductList = jdbcTemplate.query(query, new BeanPropertyRowMapper<Prouduct>(Prouduct.class));
        return prouductList;
    }

    public Prouduct findByName(String name){
        String query = String.format("select * from prouduct where name = '%S'", name);
        Prouduct prouduct = jdbcTemplate.queryForObject(query, Prouduct.class);
        return prouduct;
    }
}
