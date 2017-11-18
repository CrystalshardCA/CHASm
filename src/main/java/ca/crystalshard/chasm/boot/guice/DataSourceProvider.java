package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.mysql.cj.jdbc.MysqlDataSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.sql.DataSource;

public class DataSourceProvider implements Provider<DataSource> {

    private RubyDataConfiguration configuration;

    @Inject
    public DataSourceProvider(RubyDataConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public DataSource get() {

        switch (configuration.getDatabaseType()) {
            case MySql:
                return getMySqlServerDataSource();
            default:
                throw new NotImplementedException();
        }
    }

    private MysqlDataSource getMySqlServerDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(configuration.getUsername());
        dataSource.setPassword(configuration.getPassword());
        dataSource.setServerName(configuration.getServerName());
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("Chasm");
        return dataSource;
    }

}
