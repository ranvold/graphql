package org.example.service;

import org.example.DBManager;
import org.example.component.Database;
import org.example.component.Row;
import org.example.component.Table;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

  public List<Table> getTables(Database database){
    List<Table> list = new ArrayList<>();
    list = database.tables;
    return list;
  }
}
