package org.example.service;

import org.example.DBManager;
import org.example.component.Column;
import org.example.component.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService {

  public List<Column> getColumns(Table table){
    return table.columns;
  }
}
