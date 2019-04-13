package org.app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.model.QTSession;
import org.model.TaxBracket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.util.Calculator;

@Controller
public class QuickTaxCalcController {

	@GetMapping("/qtcalc")
	public String qtCalcController(@RequestParam(name = "fincome", required = true, defaultValue = "0") double fincome,
			Model model, HttpSession session) {

		QTSession qtSession = (QTSession) session.getAttribute("qtSession");
		if (qtSession == null || !qtSession.isInit()) {
			qtSession = new QTSession();
		}
		DecimalFormat df = new DecimalFormat("#.00");
		
		if (fincome > 0 && !(fincome == Double.parseDouble(qtSession.getIncome()))) {
			List<TaxBracket> tbList = new ArrayList<TaxBracket>();

			tbList = Calculator.process(fincome);

			qtSession.setRateCalculated(true);
			qtSession.setTbList(tbList);
			qtSession.setIncome(df.format(fincome));

			String annualTaxPaid = Calculator.calculateTotalTax(tbList);
			String annualTaxRate = Calculator.calculateTaxRate(fincome, annualTaxPaid);

			qtSession.setTotalAnnualTaxPaid(annualTaxPaid);
			qtSession.setTotalAnnualTaxRate(annualTaxRate);
		}

		model.addAttribute("fincome", fincome);
		session.setAttribute("qtSession", qtSession);

		return "qtcalc";
	}



}
