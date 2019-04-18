package org.app.controller;

import javax.servlet.http.HttpSession;

import org.model.QTHomeForm;
import org.model.QTSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class QuickTaxController {

    @GetMapping("/qthome")
    public String qthome(Model model, HttpSession session) {
    	QTSession qtSession = (QTSession) session.getAttribute("qtSession");
		QTHomeForm qtHomeForm = new QTHomeForm();
		if(qtSession == null || !qtSession.isInit()) {
			qtSession = new QTSession();
		} else {
			qtHomeForm.setFilingStatus(qtSession.getFilingStatus());
			qtHomeForm.setIncome(Double.parseDouble(qtSession.getIncome()));
		}

		
		

		model.addAttribute("qtHomeForm", qtHomeForm);
		session.setAttribute("qtSession", qtSession);
        return "qthome";
    }

}
