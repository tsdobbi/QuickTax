package org.app.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.model.QTCalcForm;
import org.model.QTHomeForm;
import org.model.QTSession;
import org.model.TaxBracket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.util.Calculator;

@Controller
public class QuickTaxCalcController {

	@GetMapping("/qtcalc")
	public String qtCalcController(Model model, @ModelAttribute QTHomeForm qtHomeForm,
			@ModelAttribute QTCalcForm qtCalcForm, HttpSession session) {

		QTSession qtSession = (QTSession) session.getAttribute("qtSession");
		if (qtCalcForm == null) {
			qtCalcForm = new QTCalcForm();
		}
		if (qtSession == null || !qtSession.isInit()) {
			qtSession = new QTSession();
		}
		DecimalFormat df = new DecimalFormat("#.00");

		if (qtHomeForm.getIncome() > 0 && (!(qtHomeForm.getIncome() == Double.parseDouble(qtSession.getIncome()))
				|| !(qtHomeForm.getFilingStatus().equalsIgnoreCase(qtSession.getFilingStatus())))) {

			List<TaxBracket> tbList = new ArrayList<TaxBracket>();
			tbList = Calculator.process(qtHomeForm.getIncome(), qtHomeForm.getFilingStatus());
			String annualTaxPaid = Calculator.calculateTotalTax(tbList);
			String annualTaxRate = Calculator.calculateTaxRate(qtHomeForm.getIncome(), annualTaxPaid);
			String income = df.format(qtHomeForm.getIncome());

			qtCalcForm = Calculator.setupCalcForm(tbList, Double.toString(qtHomeForm.getIncome()),
					qtHomeForm.getFilingStatus(), annualTaxPaid, annualTaxRate);
			qtSession.setRateCalculated(true);
			qtSession.setIncome(income);
			qtSession.setFilingStatus(qtHomeForm.getFilingStatus());
		}

		model.addAttribute("qtCalcForm", qtCalcForm);
		model.addAttribute("qtHomeForm", qtHomeForm);
		session.setAttribute("qtSession", qtSession);

		return "qtcalc";
	}

}
