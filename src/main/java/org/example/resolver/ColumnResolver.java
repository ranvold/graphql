package org.example.resolver;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.example.component.Column;
import org.example.component.Table;
import org.example.service.ColumnService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ColumnResolver {


  private final ColumnService columnService;

  public ColumnResolver(ColumnService columnService) {
    this.columnService = columnService;
  }

  @GraphQLQuery(name = "columns")
  public CompletableFuture<List<Column>> getColumns(@GraphQLContext Table table) {
    return CompletableFuture.supplyAsync(() -> columnService.getColumns(table));
  }

}
