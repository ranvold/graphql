package org.example.resolver;

import io.leangen.graphql.annotations.GraphQLQuery;
import org.example.component.Database;
import org.example.component.Table;
import org.example.service.DatabaseService;
import org.example.service.TableService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DatabaseResolver {

    private final DatabaseService databaseService;

    public DatabaseResolver(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GraphQLQuery(name = "databases")
    public CompletableFuture<List<Database>> getDatabases() {
        return CompletableFuture.supplyAsync(databaseService::getDatabase);
    }
}
