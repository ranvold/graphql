package org.example.resolver;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.example.component.Database;
import org.example.component.Row;
import org.example.component.Table;
import org.example.service.RowService;
import org.example.service.TableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class TableResolver {

  private final TableService tableService;

  public TableResolver(TableService tableService) {
    this.tableService = tableService;
  }

  @GraphQLQuery(name = "tables")
  public CompletableFuture<List<Table>> getTables(@GraphQLContext Database database) {
    return CompletableFuture.supplyAsync(() -> tableService.getTables(database));
  }
}
