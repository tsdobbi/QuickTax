package org.app;

import javax.servlet.http.HttpSession;

import org.model.QTSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuickTaxController {

    @GetMapping("/qthome")
    public String qthome(HttpSession session) {
    	QTSession qtSession = (QTSession) session.getAttribute("qtSession");
		if(qtSession == null || !qtSession.isInit()) {
			qtSession = new QTSession();
			qtSession.setIncome("0.00");
		}
		session.setAttribute("qtSession", qtSession);
        return "qthome";
    }

}
