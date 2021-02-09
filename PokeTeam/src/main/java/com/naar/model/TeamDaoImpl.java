import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

    private JdbcTemplate jdbc;
    public DataSource dataSource = this.getDataSource();

    public TeamDaoImpl(DataSource dataSource) throws SQLException {
        jdbc = new JdbcTemplate(dataSource);
    }

    public TeamDaoImpl() throws SQLException {
        DataSource ds = dataSource;
        jdbc = new JdbcTemplate(ds);
    }

    @Override
    public int update(Pokemon pokemon, int teampoke) {
        String sql = "UPDATE Team SET pokemon = ? WHERE pokemonId = ?";
        return jdbc.update(sql, pokemon, teampoke);
    }

    @Override
    public List<Pokemon> getAll() {
        String sql = "SELECT * FROM Team";
        RowMapper<Team> rowMapper = (resultSet, i) -> {
            String teamId = resultSet.getString("teamId");
            String pokemonName = resultSet.getString("pokemonName");
            return new Team(teamId, pokemonName);
        };
        return jdbc.query(sql, rowMapper);
    }

}