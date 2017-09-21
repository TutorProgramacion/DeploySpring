package tutor.spring.DeploySpring.data;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ComentarioCRUD {

    @Autowired
    private JdbcTemplate jdbc;

    public void insert(Comentario comment) {
        String sql = "insert into comments (nombre, fecha, texto) values (?, ?, ?)";
        
        jdbc.update(sql,
                comment.getNombre(),
                comment.getFecha(),
                comment.getTexto());
    }
    
    public List<Comentario> read() {
        String sql ="select * from comments";
        
        return jdbc.query(sql, (rs, row) -> {
            Comentario cmt = new Comentario();
            cmt.setFecha(rs.getDate("fecha"));
            cmt.setNombre(rs.getString("nombre"));
            cmt.setTexto(rs.getString("texto"));       
            return cmt;
        });
    }
}
