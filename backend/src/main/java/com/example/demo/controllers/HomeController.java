package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CompanyModel;
import com.example.demo.models.UserModel;
import com.example.demo.models.MySharesModel;
import com.example.demo.models.WatchListModel;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.MySharesRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WatchListRepository;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private MySharesRepository mySharesRepository;
	
	@Autowired
	private WatchListRepository watchListRepository;
	
	@PostMapping("/signin")
	public Map<String, String>  login(@RequestBody Map<String, Object> payload)
	{
		HashMap<String, String> map = new HashMap<>();
		List<UserModel> users = (List<UserModel>) userRepository.findAll();

		try 
		{
			Iterator<UserModel> iter = users.iterator();
			while(iter.hasNext())
			{
				UserModel us = (UserModel) iter.next();
				if(payload.get("email").equals(""+us.getEmail()))
				{
					if(us.getPassword().equals(payload.get("password")))
					{
						map.put("status", "success");
						return map;
					}
					else
					{
						map.put("status", "failure");
						return map;
					}
				}
			}
		}
		catch(Exception e)
		{
			map.put("status",  e.getMessage());
			return map;
		}
		

		map.put("status",  "uncaugh error");
		return map;
	}
	
	@PostMapping("/register")
	public Map<String, String> register(@RequestBody Map<String, Object> payload) 
	{
		String email = (String) payload.get("email");
		long phone = Long.parseLong((String) payload.get("phone"));
		String name = (String) payload.get("name");
		String password = (String) payload.get("password");
		
		UserModel user = new UserModel(name,email,password,phone);
		userRepository.save(user);
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "success");
		return map;
	}

	@GetMapping("/get-user")
	public List<UserModel> getOne(@RequestParam String email)
	{
		List<UserModel> users = (List<UserModel>) userRepository.findAll();
		List<UserModel> user = new ArrayList<UserModel>();
		try 
		{
			Iterator<UserModel> iter = users.iterator();
			while(iter.hasNext())
			{
				UserModel us = (UserModel) iter.next();
				if(email.equals(us.getEmail()))
				{
					user.add(us);
				}
			}
		}
		catch(Exception e)		
		{	System.out.print("Exception : ");	
			System.out.print(e.getMessage());
		}
		return user;
	}
	
	@GetMapping("/get-all")
	public List<CompanyModel> getAll()
	{
		List<CompanyModel> companyDetails = (List<CompanyModel>)companyRepository.findAll();
		return companyDetails;
	}
	
	
	@GetMapping("/my-share")
	public List<MySharesModel> myShare(@RequestParam("email") String email)
	{
		List<MySharesModel> allShares = (List<MySharesModel>)mySharesRepository.findAll();
		List<MySharesModel> myShares = new ArrayList<MySharesModel>();
		try 
		{
			Iterator<MySharesModel> iter = allShares.iterator();
			while(iter.hasNext())
			{
				MySharesModel ms = (MySharesModel) iter.next();
				if(email.equals(ms.getUser_id()))
				{
					System.out.print(ms);
					myShares.add(ms);
				}
			}
		}
		catch(Exception e)		
		{	System.out.print("Exception : ");	
			System.out.print(e.getMessage());
		}
		
		return myShares;
	}
	
	@GetMapping("/watch-list")
	public List<WatchListModel> watchList(@RequestParam("email") String email)
	{
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		List<WatchListModel> myWatchList = new ArrayList<WatchListModel>();
		try 
		{
			Iterator<WatchListModel> iter = allWatchList.iterator();
			while(iter.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter.next();
				if(email.equals(wl.getUser_id()))
				{
					System.out.print(wl);
					myWatchList.add(wl);
				}
			}
		}
		catch(Exception e)		
		{	System.out.print("Exception : ");	
			System.out.print(e.getMessage());
		}
		
		return myWatchList;
	}

	@GetMapping("/get-one")
	public Optional <CompanyModel> getOne(@RequestParam int id)
	{
		return companyRepository.findById(id);
	}

	@GetMapping("/add-watchlist")
	public Map<String, String>  addWatchList(@RequestParam String email, @RequestParam int id)
	{
		List<CompanyModel> allCompany = (List<CompanyModel>)companyRepository.findAll();
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		
		try 
		{
			Iterator<WatchListModel> iter1 = allWatchList.iterator();
			while(iter1.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter1.next();
				if(email.equals(wl.getUser_id())&&(id == wl.getCompany_id()))
				{
					HashMap<String, String> map = new HashMap<>();
					map.put("status", "company exist");
					return map;
				}
			}
			
			Iterator<CompanyModel> iter2 = allCompany.iterator();
			while(iter2.hasNext())
			{
				CompanyModel cm = (CompanyModel) iter2.next();
				if(id == cm.getCompany_id())
				{
					WatchListModel wl = new WatchListModel(cm.getCompany_id(),cm.getName(),email,cm.getOpen_rate(),cm.getClose_rate(),cm.getPeak_rate(),cm.getLeast_rate(),cm.getCurrent_rate(),cm.getYear_low(),cm.getYear_high(),cm.getMarket_cap(),cm.getP_e_ratio(),cm.getVolume());
					watchListRepository.save(wl);
				}
			}
		}
		catch(Exception e)		
		{	
			HashMap<String, String> map = new HashMap<>();
			map.put("status", e.getMessage());
			return map;
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "success");
		return map;
	}
	
	@GetMapping("/remove-watchlist")
	public Map<String, String>  removeWatchList(@RequestParam String email, @RequestParam int id)
	{
		HashMap<String, String> map = new HashMap<>();		
		List<CompanyModel> allCompany = (List<CompanyModel>)companyRepository.findAll();
		List<WatchListModel> allWatchList = (List<WatchListModel>)watchListRepository.findAll();
		
		try 
		{
			Iterator<WatchListModel> iter1 = allWatchList.iterator();
			while(iter1.hasNext())
			{
				WatchListModel wl = (WatchListModel) iter1.next();
				if(email.equals(wl.getUser_id())&&(id == wl.getCompany_id()))
				{
					watchListRepository.delete(wl);
					map.put("status", "success");
					return map;
				}
			}
			
			
		}
		catch(Exception e)		
		{	
			map.put("status", e.getMessage());
			return map;
		}
		
		map.put("status", "success");
		return map;
	}
	
	@PostMapping("/buy")
	public Map<String, String> buy(@RequestBody Map<String, Object> payload) 
	{
		String email = (String) payload.get("email");
		int companyId = Integer.parseInt(payload.get("companyId").toString());
		int qty = Integer.parseInt(payload.get("quantity").toString());
		HashMap<String, String> map = new HashMap<>();

		List<UserModel> users = (List<UserModel>) userRepository.findAll();
		List<UserModel> user = new ArrayList<UserModel>();
		
		List<MySharesModel> allShares = (List<MySharesModel>)mySharesRepository.findAll();
		List<MySharesModel> myShares = new ArrayList<MySharesModel>();
		
		List<CompanyModel> allCompany = (List<CompanyModel>)companyRepository.findAll();
		List<CompanyModel> company = new ArrayList<CompanyModel>();
		
		
				
		try
		{
			Iterator<UserModel> iter = users.iterator();
			while(iter.hasNext())
			{
				UserModel us = (UserModel) iter.next();
				if(email.equals(us.getEmail()))
					user.add(us);				
			}
			
			Iterator<MySharesModel> iter2 = allShares.iterator();
			while(iter2.hasNext())
			{
				MySharesModel ms = (MySharesModel) iter2.next();
				if(email.equals(ms.getUser_id()))				
				{					
					if(ms.getCompany_id() == companyId)
						myShares.add(ms);
				}
			}
			
			Iterator<CompanyModel> iter3 = allCompany.iterator();
			while(iter3.hasNext())
			{
				CompanyModel cm = (CompanyModel) iter3.next();
				if(companyId == cm.getCompany_id())				
					company.add(cm);					
			}
			
			if(user.get(0).getAmount_left()<=(qty*company.get(0).getCurrent_rate()))
			{
				map.put("status", "insufficient balance");
				return map;
			}			
			else if(!myShares.isEmpty())
			{
				int userAmount = user.get(0).getAmount_left();
				int currentAmount = userAmount - qty*company.get(0).getCurrent_rate();
				
				int userQty = myShares.get(0).getQuantity();
				int currentQty = userQty + qty;
				
				myShares.get(0).setQuantity(currentQty);
				myShares.get(0).setBought_rate(company.get(0).getCurrent_rate());
				mySharesRepository.save(myShares.get(0));
				
				user.get(0).setAmount_left(currentAmount);
				userRepository.save(user.get(0));
				
				map.put("status", "success");
				return map;
			}
			else
			{
				int userAmount = user.get(0).getAmount_left();
				int currentAmount = userAmount - qty*company.get(0).getCurrent_rate();
				
				user.get(0).setAmount_left(currentAmount);
				userRepository.save(user.get(0));
				
				MySharesModel msm = new MySharesModel(companyId,company.get(0).getName(),email,company.get(0).getOpen_rate(),company.get(0).getClose_rate(),company.get(0).getPeak_rate(),company.get(0).getLeast_rate(),company.get(0).getCurrent_rate(),qty,company.get(0).getCurrent_rate(),company.get(0).getYear_low(),company.get(0).getYear_high(), company.get(0).getMarket_cap(),company.get(0).getP_e_ratio(),company.get(0).getVolume());
				mySharesRepository.save(msm);
			}
		}
		catch(Exception e)		
		{	
			map.put("status", e.getMessage());
			return map;
		}

		map.put("status", "success");
		return map;
	}

	@PostMapping("/sell")
	public Map<String, String> sell(@RequestBody Map<String, Object> payload)
	{
		String email = (String) payload.get("email");
		int companyId = Integer.parseInt(payload.get("companyId").toString());
		int qty = Integer.parseInt(payload.get("quantity").toString());
		HashMap<String, String> map = new HashMap<>();

		List<UserModel> users = (List<UserModel>) userRepository.findAll();
		List<UserModel> user = new ArrayList<UserModel>();
		
		List<MySharesModel> allShares = (List<MySharesModel>)mySharesRepository.findAll();
		List<MySharesModel> myShares = new ArrayList<MySharesModel>();
		
		List<CompanyModel> allCompany = (List<CompanyModel>)companyRepository.findAll();
		List<CompanyModel> company = new ArrayList<CompanyModel>();
		
		try
		{
			Iterator<UserModel> iter = users.iterator();
			while(iter.hasNext())
			{
				UserModel us = (UserModel) iter.next();
				if(email.equals(us.getEmail()))
					user.add(us);				
			}
			
			Iterator<MySharesModel> iter2 = allShares.iterator();
			while(iter2.hasNext())
			{
				MySharesModel ms = (MySharesModel) iter2.next();
				if(email.equals(ms.getUser_id()))				
				{					
					if(ms.getCompany_id() == companyId)
						myShares.add(ms);
				}
			}
			
			Iterator<CompanyModel> iter3 = allCompany.iterator();
			while(iter3.hasNext())
			{
				CompanyModel cm = (CompanyModel) iter3.next();
				if(companyId == cm.getCompany_id())				
					company.add(cm);					
			}
			
			int userAmount = user.get(0).getAmount_left();
			int currentAmount = userAmount - qty*company.get(0).getCurrent_rate();
			
			int userQty = myShares.get(0).getQuantity();
			int currentQty = userQty - qty;
			
			if(currentQty == 0)
			{
				mySharesRepository.delete(myShares.get(0));				
			}
			else
			{
				myShares.get(0).setQuantity(currentQty);
				mySharesRepository.save(myShares.get(0));
			}
			user.get(0).setAmount_left(currentAmount);
			userRepository.save(user.get(0));
			
			map.put("status", "success");
			return map;
			
		}
		catch(Exception e)
		{
			map.put("status", e.getMessage());
			return map;
		}
	}
}























