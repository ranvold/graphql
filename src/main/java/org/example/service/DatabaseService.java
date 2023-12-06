package org.example.service;

import org.example.DBManager;
import org.example.component.Database;
import org.example.component.Table;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {

    public List<Database> getDatabase(){
        List<Database> list = new ArrayList<>();
        list.add(DBManager.database);
        return list;
    }
}
