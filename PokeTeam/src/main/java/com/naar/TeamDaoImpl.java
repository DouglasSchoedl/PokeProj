import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
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
    public Team add(Team team) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO Team (teamId, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbc.update(connection -> {
            PreparedStatement prep = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prep.setString(1, team.getTeamId());
            prep.setString(2, team.getPokemon1());
            prep.setString(2, team.getPokemon2());
            prep.setString(2, team.getPokemon3());
            prep.setString(2, team.getPokemon4());
            prep.setString(2, team.getPokemon5());
            prep.setString(2, team.getPokemon6());
            return prep;
        }, keyHolder);
        team.setTeamId(String.valueOf(keyHolder.getKey()));
        return team;
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