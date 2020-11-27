package dao;

import beans.Pracownik;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PracownikDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Pracownik p) {
        String sql = "insert into pracownik (nazwisko,pensja,firma) "
                + "values('" + p.getNazwisko() + "'," + p.getPensja() + ",'" + p.getFirma() + "')";
        return template.update(sql);
    }

    public List<Pracownik> getAll() {
        return template.query("select * from pracownik",
                (rs, row) -> {
                    Pracownik e = new Pracownik();
                    e.setId(rs.getInt(1));
                    e.setNazwisko(rs.getString(2));
                    e.setPensja(rs.getFloat(3));
                    e.setFirma(rs.getString(4));
                    return e;
                });
    }

    public int update(Pracownik p) {
        String sql = "update pracownik " + "SET nazwisko ='" + p.getNazwisko() + "', pensja = " + p.getPensja() + ", firma = '" + p.getFirma() + "' WHERE id = "+ p.getId();
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "DELETE FROM pracownik WHERE id = " + id;
        return template.update(sql);
    }

    public Pracownik getPracownikById(int id){
        String sql="select * from pracownik where id=?";
        return template.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(Pracownik.class));
    }
}