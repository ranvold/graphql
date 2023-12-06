package org.example;

import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.example.component.Database;
import org.example.resolver.ColumnResolver;
import org.example.resolver.DatabaseResolver;
import org.example.resolver.RowResolver;
import org.example.resolver.TableResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

  private final ColumnResolver columnResolver;
  private final RowResolver rowResolver;
  private final TableResolver tableResolver;
  private final DatabaseResolver databaseResolver;

  public GraphQLConfig(ColumnResolver columnResolver,
      RowResolver rowResolver, TableResolver tableResolver, DatabaseResolver databaseResolver) {
    this.columnResolver = columnResolver;
    this.rowResolver = rowResolver;
    this.tableResolver = tableResolver;
    this.databaseResolver = databaseResolver;
  }

  @Bean
  public GraphQLSchema getGraphQLSchema() {
    return new GraphQLSchemaGenerator()
        .withBasePackages("com.example.graphql.demo.models")
        .withOperationsFromSingletons(columnResolver, rowResolver, tableResolver,databaseResolver)
        .generate();
  }

  @Bean
  public GraphQL getGraphQL(GraphQLSchema graphQLSchema) {
    return GraphQL.newGraphQL(graphQLSchema)
        .queryExecutionStrategy(new AsyncExecutionStrategy())
        .instrumentation(new CustomTracingInstrumentation())
        .build();
  }
}

