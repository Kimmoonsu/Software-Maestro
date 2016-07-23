package letter.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import letter.service.UserService;

@Controller
public class LetterController {
	@Resource(name = "UserService")
	private UserService service;

	@RequestMapping("/hello.do")
	public void hello(HttpServletRequest request) throws Exception {
		String letter_id = String.valueOf(service.selectLetterPK());
		// System.out.println("letter_id : " + letter_id);
		letterPush("16", "1035494069897172", "Moonsu Kim", "1061337893942895", "김문성", "마에스트로", "37.5041151",
				"127.0447707", "내용이다", "2016-07-21 21:10",
				"APA91bG2CEluXaBMuP0OqcjxzXxCwhXLscF0Dgk0sOPLDgYtDxxWYSzNjRDhLq_Tu5AjUdLfuL5-SBR1Gcz9CqXoPm_pTgFof1T97-gt9_dCt80vz0gIK6hBsm0iNwgnhDBPfo9qPoJPlMYs_8vdTH_a_HY3sxfj9A");
	}

	@RequestMapping("/test.do")
	public ModelAndView test(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("greeting", "Hello AWS");

		return mv;
	}

	// 관리자 홈페이지 시작 화면 호출
	@RequestMapping("/login.do")
	public ModelAndView loginView() throws Exception {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/main.do")
	public ModelAndView mainView() throws Exception {
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}

	// login check
	@RequestMapping("/check.do")
	public ModelAndView checkAdmin(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		ModelAndView mv = null;
		if (id.equals("admin") && passwd.equals("1234")) {
			mv = new ModelAndView("main");
		} else {
			mv = new ModelAndView("loginError");
			mv.addObject("error", "잘못된 계정입니다.");
		}

		return mv;
	}

	@RequestMapping("/testing.do")
	public void testing(HttpServletRequest request) throws Exception {
		String register_id = service.selectFindRegister("1035494069897172");
		System.out.println("register_id : " + register_id);
	}

	@RequestMapping(value = "/json.do")
	public ModelAndView selectUser(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> list = service.selectMemberList(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	@RequestMapping(value = "/userList.do")
	public ModelAndView userList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("userList");
		List<Map<String, Object>> list = service.selectMemberList(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	@RequestMapping(value = "/letterList.do")
	public ModelAndView letterList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("letterList");
		List<Map<String, Object>> list = service.selectLetterList(commandMap);
		// double latitude =
		// Double.parseDouble((String)list.get(0).get("latitude"));
		// double longitude =
		// Double.parseDouble((String)list.get(0).get("longitude"));
		// System.out.println("latitude : " + latitude + " longitude : " +
		// longitude);
		// double distance = getDistance(latitude, longitude, 37.504479,
		// 127.04894100000001);
		mv.addObject("List", list);
		return mv;
	}

	@RequestMapping(value = "/accessList.do")
	public ModelAndView accessList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("accessList");
		List<Map<String, Object>> list = service.selectAccessList(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	@RequestMapping(value = "/findLetter.do")
	public ModelAndView findLetter(Map<String, Object> commandMap, HttpServletRequest request) throws Exception {
		String from_id = request.getParameter("from_id");
		commandMap.put("from_id", from_id);
		ModelAndView mv = new ModelAndView("findLetter");
		List<Map<String, Object>> list = service.selectFindLetter(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	// delete Member
	@RequestMapping("/delete.do")
	public ModelAndView memberDelete(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = request.getParameter("id");
		map.put("id", id);
		service.deleteMember(map);
		ModelAndView mv = new ModelAndView("userList");
		List<Map<String, Object>> list = service.selectMemberList(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	// delete letter
	@RequestMapping("/deleteLetter.do")
	public ModelAndView deleteLetter(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String letter_id = request.getParameter("letter_id");
		map.put("letter_id", letter_id);
		service.deleteLetter(map);
		ModelAndView mv = new ModelAndView("letterList");
		List<Map<String, Object>> list = service.selectLetterList(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	// delete Access Member
	@RequestMapping("/deleteAccess.do")
	public ModelAndView deleteAccess(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String number = request.getParameter("number");
		map.put("number", number);
		service.deleteAccess(map);
		ModelAndView mv = new ModelAndView("accessList");
		List<Map<String, Object>> list = service.selectAccessList(commandMap);
		mv.addObject("List", list);
		return mv;
	}

	@RequestMapping("/insertUser.do")
	public void userInput(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		Map<String, Object> map = new HashMap<String, Object>();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String register_id = request.getParameter("register_id");
		System.out.println(name);
		System.out.println("id : " + id + " date : " + date);
		map.put("name", name);
		map.put("id", id);
		map.put("date", date);
		map.put("register_id", register_id);
		service.insertMember(map);
		service.accessMember(map);
	}

	// insert app close date
	@RequestMapping("/closeUser.do")
	public void closeInput(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		Map<String, Object> map = new HashMap<String, Object>();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String access_date = request.getParameter("access_date");
		String close_date = request.getParameter("close_date");
		map.put("access_name", name);
		map.put("access_id", id);
		map.put("access_date", access_date);
		map.put("close_date", close_date);
		service.closeUser(map);
	}
	
	// update letter read state
	@RequestMapping("/updateLetterState.do")
	public void updateLetterState(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		Map<String, Object> map = new HashMap<String, Object>();
		String letter_id = request.getParameter("letter_id");
		System.out.println("letter_id : " + letter_id);
		map.put("letter_id", letter_id);
		service.updateLetterState(map);
	}
	
	@RequestMapping("/insertLetter.do")
	public void letterInput(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		String letter_id = String.valueOf(service.selectLetterPK());
		Map<String, Object> map = new HashMap<String, Object>();
		String to_id = request.getParameter("to_id");
		String to_name = request.getParameter("to_name");
		String from_id = request.getParameter("from_id");
		String from_name = request.getParameter("from_name");
		String address = request.getParameter("address");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		System.out.println("to_name : " + to_name);
		System.out.println("from_name : " + from_name);
		System.out.println("address : " + address);
		System.out.println("date : " + date);
		map.put("to_id", to_id);
		map.put("to_name", to_name);
		map.put("from_id", from_id);
		map.put("from_name", from_name);
		map.put("address", address);
		map.put("latitude", latitude);
		map.put("longitude", longitude);
		map.put("content", content);
		map.put("read_state", 0);
		map.put("date", date);
		service.insertLetter(map);
		// to_id(받는이)에 해당하는 register_id를 찾아 push알림 제공
		String register_id = service.selectFindRegister(to_id);
		 letterPush(letter_id, to_id, to_name, from_id, from_name, address,latitude, longitude, content, date, register_id);
	}

	public void letterPush(String letter_id, String to_id, String to_name, String from_id, String from_name,
			String address, String latitude, String longitude, String content, String date, String register_id) {
		String msg = "새로운 편지가 도착했습니다!";
		try {
			to_name = URLEncoder.encode(to_name, "euc-kr");
			from_name = URLEncoder.encode(from_name, "euc-kr");
			address = URLEncoder.encode(address, "euc-kr");
			content = URLEncoder.encode(content, "euc-kr");
			msg = URLEncoder.encode(msg, "euc-kr");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String simpleApiKey = "AIzaSyDQ8J1e2CqzeGQ0y9sSMmlWyjM0ugk74P0";
		ArrayList<String> regid = new ArrayList<String>(); // reg_id

		String MESSAGE_ID = String.valueOf(Math.random() % 100 + 1);

		boolean SHOW_ON_IDLE = false;

		int LIVE_TIME = 1; 

		int RETRY = 2;
		regid.add(register_id);
		Sender sender = new Sender(simpleApiKey);
		Message message = new Message.Builder()

				.collapseKey(MESSAGE_ID)

				.delayWhileIdle(SHOW_ON_IDLE)

				.timeToLive(LIVE_TIME).addData("letter_id", letter_id).addData("msg", msg)
				.addData("to_id", to_id).addData("to_name", to_name).addData("from_id", from_id)
				.addData("from_name", from_name).addData("address", address).addData("latitude", latitude)
				.addData("longitude", longitude).addData("content", content).addData("date", date)

				.build();

		MulticastResult result1 = null;
		try {
			result1 = sender.send(message, regid, RETRY);
			System.out.println(result1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result1 != null) {

			List<Result> resultList = result1.getResults();

			for (Result result : resultList) {

				System.out.println(result.getErrorCodeName());

			}

		}

	}

	/******************* get distance method ************************/
	public Double getDistance(Double latitude_1, Double longitude_1, Double latitude_2, Double longitude_2) {
		Double distance = calDistance(latitude_1, longitude_1, latitude_2, longitude_2);
		System.out.println("거리: " + distance);
		return distance;
	}

	public static double calDistance(double lat1, double lon1, double lat2, double lon2) {

		double theta, dist;
		theta = lon1 - lon2;
		dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);

		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344; // mile to km
		dist = dist * 1000.0; // km to m

		return dist;
	}

	//
	private static double deg2rad(double deg) {
		return (double) (deg * Math.PI / (double) 180d);
	}

	//
	private static double rad2deg(double rad) {
		return (double) (rad * (double) 180d / Math.PI);
	}
	/************************************/

}
