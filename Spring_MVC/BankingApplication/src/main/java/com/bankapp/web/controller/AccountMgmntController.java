package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountType;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.AddAccountBean;
import com.bankapp.web.formbeans.Depositbean;
import com.bankapp.web.formbeans.Transferbean;
import com.bankapp.web.formbeans.WithdrawBean;

@Controller
public class AccountMgmntController {

	private AccountService accountService;

	@Autowired
	public AccountMgmntController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("home")
	public String home() {
		return "home";
	}

	@GetMapping("success")
	public String success() {
		return "success";
	}

	@GetMapping("transfer")
	public String tranferAmountGet(ModelMap mv) {
		mv.addAttribute("transferbean", new Transferbean());
		return "transfer";
	}

	@PostMapping("transfer")
	public String tranferAmountPost(/*@Valid*/ @ModelAttribute("transferbean") Transferbean transferBean) {
		/*	BindingResult result) {
		if (result.hasErrors()) {
			return "transfer";
		} else {*/
			Integer fromAcc = transferBean.getFromAccountId();
			Integer toAcc = transferBean.getToAccountId();
			double amount = transferBean.getAmount();
			accountService.tranfer(fromAcc, toAcc, amount);
			return "redirect:/success";
		}
	

	@GetMapping("deposit")
	public String depositAmountGet(ModelMap mv) {
		mv.addAttribute("depositbean", new Depositbean());
		return "deposit";
	}

	@PostMapping("deposit")
	public String depositMoneyPost(@Valid @ModelAttribute("depositbean") Depositbean depositbean) {
			/*BindingResult result) {
		if (result.hasErrors()) {
			return "deposit";
		} else {*/
			Integer accountId = depositbean.getAccountId();
			Double amount = depositbean.getAmount();
			accountService.deposit(accountId, amount);
			return "redirect:/success";
		}
	

	@GetMapping("withdraw")
	public String withDrawMoneyGet(ModelMap mv) {
		mv.addAttribute("withdrawbean", new WithdrawBean());
		return "withdraw";
	}

	@PostMapping("withdraw")
	public String withdrawMoneyPost(@Valid @ModelAttribute("withdrawbean") WithdrawBean withdrawbean) {
			/*BindingResult result) {
		if (result.hasErrors()) {
			return "withdraw";
		} else {*/
			Integer accountId = withdrawbean.getAccountId();
			Double amount = withdrawbean.getAmount();
			accountService.withdraw(accountId, amount);
			return "redirect:/success";
		}
	

	@GetMapping("addaccount")
	public String addAccountGet(ModelMap mv) {
		mv.addAttribute("addAccountBean", new AddAccountBean());
		return "addaccount";

	}

	@SuppressWarnings("unused")
	@PostMapping("addaccount")
	public String addAccountPost(@Valid @ModelAttribute("addAccountBean") AddAccountBean addAccountBean) {
			/*BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("error");
			return "addaccount";
		} else {*/
			Integer id = addAccountBean.getAccountId();
			Account account = new Account(addAccountBean.getName(), addAccountBean.getAddress(),
					addAccountBean.getPhone(), addAccountBean.getEmail(), 0.0, addAccountBean.getAccountType(),
					addAccountBean.getPanNumber(), addAccountBean.getAadharNumber());
			accountService.addAccount(account);
			return "redirect:/home";
		}
	

	@GetMapping("updateaccount")
	public String updateAccountGet(ModelMap mv, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		AddAccountBean account = new AddAccountBean();
		account.setAccountId(id);
		mv.addAttribute("updateAccountBean", account);
		return "updateaccount";

	}

	@PostMapping("updateaccount")
	public String updateAccountPost(@Valid @ModelAttribute("updateAccountBean") AddAccountBean updateAccountBean) {
			/*BindingResult result) {
		if (result.hasErrors()) {
			return "updateaccount";
		} else {*/
			Integer id = updateAccountBean.getAccountId();
			accountService.updateAddress(id, updateAccountBean.getAddress(), updateAccountBean.getPhone(),
					updateAccountBean.getEmail());
			return "redirect:/home";
		}
	

	@GetMapping("showaccounts")
	public ModelAndView showAllAccounts(ModelAndView mv) {
		mv.setViewName("showallaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		return mv;
	}

	@GetMapping("deleteaccount")
	public String deleteAccount(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		accountService.deleteAccount(id);
		return "redirect:/showaccounts";
	}

	@ModelAttribute(value = "accounttypes")
	public AccountType[] accountType() {
		return AccountType.values();
	}

}
