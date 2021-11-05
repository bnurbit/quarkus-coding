package pt.bnurbit.coding.quarkus.greeting;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/hello/datasource")
public class GreetingResourceDataSource {

    @Inject
    AgroalDataSource dataSource;

    @Inject
    @DataSource("users")
    AgroalDataSource usersDataSource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();

        try(CallableStatement cs = dataSource.getConnection().prepareCall("select * from greeting")) {
            cs.execute();
            final ResultSet resultSet = cs.getResultSet();
            stringBuilder.append("Hello:");
            while(resultSet.next()){
                stringBuilder.append('\n').append(resultSet.getString("greeting"));
            }
        }
        try(CallableStatement cs = usersDataSource.getConnection().prepareCall("select * from user")) {
            cs.execute();
            final ResultSet resultSet = cs.getResultSet();
            stringBuilder.append('\n').append("Users:");
            while(resultSet.next()){
                stringBuilder.append('\n').append(resultSet.getString("name"));
            }
        }
        return stringBuilder.toString();
    }
}
