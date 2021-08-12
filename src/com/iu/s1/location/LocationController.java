package com.iu.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	private LocationInput locationInput;
	
	public LocationController() {
		// TODO Auto-generated constructor stub
		locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		sc=new Scanner(System.in);
		locationInput = new LocationInput();
	}

	public void start() {
			
			boolean check = true;
			
			while(check) {
				System.out.println("1.전체 정보 출력");
				System.out.println("2.1개 정보 출력");
				System.out.println("3.나가기");
				
				int select = sc.nextInt();	
				
				if(select==1) {
					ArrayList<LocationDTO> ar = locationDAO.getList();
					
					if(ar.size()>0) {
						locationView.view(ar);
					}else {
						locationView.view("Data가 없습니다.");
					}
					
					
				}else if(select==2) {
					
					LocationDTO locationDTO=locationInput.inputId(sc);
					locationDTO=locationDAO.getOne(locationDTO);
					
					if(locationDTO !=null) {
						locationView.view(locationDTO);	
					}else {
						locationView.view("없는 ID 입니다");
					}
					
					
				}else {
					check=false;
					break;
				}
				
			}//while문 종료

	}//start문종료 

}