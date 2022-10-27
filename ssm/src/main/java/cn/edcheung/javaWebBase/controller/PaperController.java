package cn.edcheung.javaWebBase.controller;

import cn.edcheung.javaWebBase.pojo.Paper;
import cn.edcheung.javaWebBase.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * PaperController TODO
 *
 * @author Edward Cheung
 * 2019/5/14
 */
@Controller
@RequestMapping(value = "/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @RequestMapping("/allPaper")
    public String list(Model model) {
        List<Paper> list = paperService.queryAllPaper();
        model.addAttribute("list", list);
        return "allPaper";
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper() {
        return "toAddPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/delete/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id) {
        paperService.deletePaperById(id);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(Model model, Long id) {
        model.addAttribute("paper", paperService.queryById(id));
        return "toUpdatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Model model, Paper paper) {
        paperService.updatePaper(paper);
        paper = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper", paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping(value = "/getPaper/{paperId}", method = RequestMethod.POST,
            produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Paper appoint(@PathVariable("paperId") long paperId) {
        return paperService.queryById(paperId);
    }
}
