package tutor.spring.DeploySpring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComentarioController {
    
    @Autowired
    private ComentarioCRUD comentario;

    @RequestMapping("/comentar")
    public String comentar(Model model) {
        model.addAttribute("comentario", new Comentario());
        model.addAttribute("cmtList", comentario.read());
        return "comentarios";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Comentario comment, Model model) {
        comentario.insert(comment);
        return "redirect:/comentar";
    }
}
