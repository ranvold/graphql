package org.example.resolver;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.example.component.Row;
import org.example.component.Table;
import org.example.service.RowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class RowResolver {

  private final RowService rowService;

  public RowResolver(RowService rowService) {
    this.rowService = rowService;
  }

  @GraphQLQuery(name = "rows")
  public CompletableFuture<List<Row>> getRows(@GraphQLContext Table table) {
    return CompletableFuture.supplyAsync(() -> rowService.getRows(table));
  }

}
