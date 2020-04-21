package kh.java.point.controller;

import kh.java.point.service.pointService;
import kh.java.point.view.pointView;

public class pointController {

	pointService service = new pointService();
	pointView view = new pointView();

	public void main() {
		while (true) {
			switch (view.main()) {
			case 1:
				insertMbr();
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				break;

			case 0:
				break;

			default:
				break;
			}
		}
	}
	
	public void insertMbr() {
		
	}
}
