package org.example.service;

import org.example.DBManager;
import org.example.component.Row;
import org.example.component.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowService {


  public List<Row> getRows(Table table){
    return table.rows;
  }
}
