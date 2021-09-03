package com.project.foodbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodbox.model.Cusine;
import com.project.foodbox.repository.CusineRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CusineRepository cusineRepository;
	
	@Override
	public Cusine createCusine(Cusine cusine) throws Exception {
		Cusine cus=this.cusineRepository.findByCusname(cusine.getCusname());
		if(cus!=null) {
			System.out.println("Cusine name already exists..");
			throw new Exception("Cusine name already exists");
		}else {
			cus=this.cusineRepository.save(cusine);
		}
		return cus;
	}

	@Override
	public Cusine updateCusine(int cusid,Cusine cusine) {
		
		Cusine cus=this.cusineRepository.findByCusid(cusid);
		
		cus.setCusname(cusine.getCusname());
		cus.setPrice(cusine.getPrice());
		cus.setDescription(cusine.getDescription());
		cus.setEnabled(cusine.isEnabled());
		cus.setCategory(cusine.getCategory());
		
		return this.cusineRepository.save(cus);

	}

	@Override
	public void deleteCusine(int cusid) {
		
		this.cusineRepository.deleteById(cusid);
	}

	@Override
	public List<Cusine> GetAllCusines() {
		List<Cusine> cusines=this.cusineRepository.findAll();
		return cusines;
	}

	@Override
	public Cusine getCusineByID(int cusineid) {
		return this.cusineRepository.findByCusid(cusineid);
	}

	@Override
	public Cusine getCusineByName(String cusname) {
		return this.cusineRepository.findByCusname(cusname);
	}

}
