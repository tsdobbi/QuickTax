package org.app.controller;

import javax.servlet.http.HttpSession;

import org.model.QTHomeForm;
import org.model.QTSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuickTaxController {

    @GetMapping("/qthome")
    public String qthome(Model model, HttpSession session) {
    	QTSession qtSession = (QTSession) session.getAttribute("qtSession");
		if(qtSession == null || !qtSession.isInit()) {
			qtSession = new QTSession();
		}
		QTHomeForm qtHomeForm = new QTHomeForm();
		model.addAttribute("qtHomeForm", qtHomeForm);
		session.setAttribute("qtSession", qtSession);
        return "qthome";
    }

}
