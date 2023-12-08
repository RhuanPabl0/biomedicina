package com.fasipe.biomedicina.Services;

import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Repositorys.ProcedimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentosRepository repository;
    public List<Procedimentos> getAllProcedimentos(){
       return repository.findAll();
    }


}
